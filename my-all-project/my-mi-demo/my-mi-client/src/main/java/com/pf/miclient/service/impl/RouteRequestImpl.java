package com.pf.miclient.service.impl;

import com.alibaba.fastjson.JSON;
import com.pf.miclient.config.AppConfiguration;
import com.pf.miclient.service.EchoService;
import com.pf.miclient.service.RouteRequest;
import com.pf.miclient.thread.ContextHolder;
import com.pf.miclient.vo.req.GroupReqVO;
import com.pf.miclient.vo.req.LoginReqVO;
import com.pf.miclient.vo.req.P2PReqVO;
import com.pf.miclient.vo.res.CIMServerResVO;
import com.pf.miclient.vo.res.OnlineUsersResVO;
import com.pf.micommon.core.proxy.ProxyManager;
import com.pf.micommon.enums.StatusEnum;
import com.pf.micommon.exception.CIMException;
import com.pf.micommon.res.BaseResponse;
import com.pf.miroutapi.RouteApi;
import com.pf.miroutapi.vo.req.ChatReqVO;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Function:
 *
 * @author crossoverJie
 *         Date: 2018/12/22 22:27
 * @since JDK 1.8
 */
@Service
public class RouteRequestImpl implements RouteRequest {

    private final static Logger LOGGER = LoggerFactory.getLogger(RouteRequestImpl.class);

    @Autowired
    private OkHttpClient okHttpClient ;

    @Value("${cim.route.url}")
    private String routeUrl ;

    @Autowired
    private EchoService echoService ;


    @Autowired
    private AppConfiguration appConfiguration ;

    @Override
    public void sendGroupMsg(GroupReqVO groupReqVO) throws Exception {
        RouteApi routeApi = new ProxyManager<>(RouteApi.class, routeUrl, okHttpClient).getInstance();
        ChatReqVO chatReqVO = new ChatReqVO(groupReqVO.getUserId(), groupReqVO.getMsg()) ;
        Response response = null;
        try {
            response = (Response)routeApi.groupRoute(chatReqVO);
        }catch (Exception e){
            LOGGER.error("exception",e);
        }finally {
            response.body().close();
        }
    }

    @Override
    public void sendP2PMsg(P2PReqVO p2PReqVO) throws Exception {
        RouteApi routeApi = new ProxyManager<>(RouteApi.class, routeUrl, okHttpClient).getInstance();
        com.pf.miroutapi.vo.req.P2PReqVO  vo = new com.pf.miroutapi.vo.req.P2PReqVO() ;
        vo.setMsg(p2PReqVO.getMsg());
        vo.setReceiveUserId(p2PReqVO.getReceiveUserId());
        vo.setUserId(p2PReqVO.getUserId());

        Response response = null;
        try {
            response = (Response) routeApi.p2pRoute(vo);
            String json = response.body().string() ;
            BaseResponse baseResponse = JSON.parseObject(json, BaseResponse.class);

            // account offline.
            if (baseResponse.getCode().equals(StatusEnum.OFF_LINE.getCode())){
                LOGGER.error(p2PReqVO.getReceiveUserId() + ":" + StatusEnum.OFF_LINE.getMessage());
            }

        }catch (Exception e){
            LOGGER.error("exception",e);
        }finally {
            response.body().close();
        }
    }

    @Override
    public CIMServerResVO.ServerInfo getCIMServer(LoginReqVO loginReqVO) throws Exception {

        RouteApi routeApi = new ProxyManager<>(RouteApi.class, routeUrl, okHttpClient).getInstance();
        com.pf.miroutapi.vo.req.LoginReqVO  vo = new com.pf.miroutapi.vo.req.LoginReqVO() ;
        vo.setUserId(loginReqVO.getUserId());
        vo.setUserName(loginReqVO.getUserName());

        Response response = null;
        CIMServerResVO cimServerResVO = null;
        try {
            response = (Response) routeApi.login(vo);
            String json = response.body().string();
            cimServerResVO = JSON.parseObject(json, CIMServerResVO.class);

            //重复失败
            if (!cimServerResVO.getCode().equals(StatusEnum.SUCCESS.getCode())){
                echoService.echo(cimServerResVO.getMessage());

                // when client in reConnect state, could not exit.
                if (ContextHolder.getReconnect()){
                    echoService.echo("###{}###", StatusEnum.RECONNECT_FAIL.getMessage());
                    throw new CIMException(StatusEnum.RECONNECT_FAIL);
                }

                System.exit(-1);
            }

        }catch (Exception e){
            LOGGER.error("exception",e);
        }finally {
            response.body().close();
        }

        return cimServerResVO.getDataBody();
    }

    @Override
    public List<OnlineUsersResVO.DataBodyBean> onlineUsers() throws Exception{
        RouteApi routeApi = new ProxyManager<>(RouteApi.class, routeUrl, okHttpClient).getInstance();

        Response response = null;
        OnlineUsersResVO onlineUsersResVO = null;
        try {
            response = (Response) routeApi.onlineUser();
            String json = response.body().string() ;
            onlineUsersResVO = JSON.parseObject(json, OnlineUsersResVO.class);

        }catch (Exception e){
            LOGGER.error("exception",e);
        }finally {
            response.body().close();
        }

        return onlineUsersResVO.getDataBody();
    }

    @Override
    public void offLine() {
        RouteApi routeApi = new ProxyManager<>(RouteApi.class, routeUrl, okHttpClient).getInstance();
        ChatReqVO vo = new ChatReqVO(appConfiguration.getUserId(), "offLine") ;
        Response response = null;
        try {
            response = (Response) routeApi.offLine(vo);
        } catch (Exception e) {
            LOGGER.error("exception",e);
        } finally {
            response.body().close();
        }
    }
}
