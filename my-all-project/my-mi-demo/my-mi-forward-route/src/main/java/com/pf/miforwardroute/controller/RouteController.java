package com.pf.miforwardroute.controller;

import com.pf.micommon.enums.StatusEnum;
import com.pf.micommon.pojo.RouteInfo;
import com.pf.micommon.res.BaseResponse;
import com.pf.micommon.route.algorithm.RouteHandle;
import com.pf.micommon.util.RouteInfoParseUtil;
import com.pf.miforwardroute.cache.ServerCache;
import com.pf.miforwardroute.service.AccountService;
import com.pf.miforwardroute.service.CommonBizService;
import com.pf.miroutapi.RouteApi;
import com.pf.miroutapi.vo.req.ChatReqVO;
import com.pf.miroutapi.vo.req.LoginReqVO;
import com.pf.miroutapi.vo.req.P2PReqVO;
import com.pf.miroutapi.vo.req.RegisterInfoReqVO;
import com.pf.miroutapi.vo.res.CIMServerResVO;
import com.pf.miroutapi.vo.res.RegisterInfoResVO;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class RouteController implements RouteApi {
    @Override
    public Object groupRoute(ChatReqVO groupReqVO) throws Exception {
        return null;
    }

    @Override
    public Object p2pRoute(P2PReqVO p2pRequest) throws Exception {
        return null;
    }

    @Override
    public Object offLine(ChatReqVO groupReqVO) throws Exception {
        return null;
    }


    @Override
    public Object onlineUser() throws Exception {
        return null;
    }

    private final static Logger LOGGER = LoggerFactory.getLogger(RouteController.class);

    @Autowired
    private ServerCache serverCache;

    @Autowired
    private RouteHandle routeHandle ;


    @Autowired
    private CommonBizService commonBizService ;

    @Autowired
    private AccountService accountService;


    /**
     * 注册账号
     *
     * @return
     */
    @ApiOperation("注册账号")
    @RequestMapping(value = "registerAccount", method = RequestMethod.POST)
    @ResponseBody()
    @Override
    public BaseResponse<RegisterInfoResVO> registerAccount(@RequestBody RegisterInfoReqVO registerInfoReqVO) throws Exception {
        BaseResponse<RegisterInfoResVO> res = new BaseResponse();

        long userId = Long.parseLong("1586617710861");
        RegisterInfoResVO info = new RegisterInfoResVO(userId, registerInfoReqVO.getUserName());
        info = accountService.register(info);

        res.setDataBody(info);
        res.setCode(StatusEnum.SUCCESS.getCode());
        res.setMessage(StatusEnum.SUCCESS.getMessage());
        return res;
    }


    /**
     * 获取一台 CIM server
     *
     * @return
     */
    @ApiOperation("登录并获取服务器")
    @RequestMapping(value = "login", method = RequestMethod.POST)
    @ResponseBody()
    @Override
    public BaseResponse<CIMServerResVO> login(@RequestBody LoginReqVO loginReqVO) throws Exception {
        BaseResponse<CIMServerResVO> res = new BaseResponse();

        // check server available
        String server = routeHandle.routeServer(serverCache.getServerList(),String.valueOf(loginReqVO.getUserId()));
        LOGGER.info("userName=[{}] route server info=[{}]", loginReqVO.getUserName(), server);

        RouteInfo routeInfo = RouteInfoParseUtil.parse(server);
        commonBizService.checkServerAvailable(routeInfo);

        //登录校验
        StatusEnum status = accountService.login(loginReqVO);
        if (status == StatusEnum.SUCCESS) {

            //保存路由信息
            accountService.saveRouteInfo(loginReqVO,server);

            CIMServerResVO vo = new CIMServerResVO(routeInfo);
            res.setDataBody(vo);

        }
        res.setCode(status.getCode());
        res.setMessage(status.getMessage());

        return res;
    }
}
