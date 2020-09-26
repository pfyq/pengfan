package com.pf.miserver.controller;


import com.pf.micommon.constant.Constants;
import com.pf.micommon.enums.StatusEnum;
import com.pf.micommon.res.BaseResponse;
import com.pf.miserver.server.CIMServer;
import com.pf.miserverapi.ServerApi;
import com.pf.miserverapi.vo.req.SendMsgReqVO;
import com.pf.miserverapi.vo.res.SendMsgResVO;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.metrics.CounterService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Function:
 *
 * @author crossoverJie
 *         Date: 22/05/2018 14:46
 * @since JDK 1.8
 */
@Controller
@RequestMapping("/")
public class IndexController implements ServerApi {

    @Autowired
    private CIMServer cimServer;

    /**a
     * 统计 service
     */
    @Autowired
    private CounterService counterService;

    /**
     *
     * @param sendMsgReqVO
     * @return
     */
    @Override
    @ApiOperation("Push msg to client")
    @RequestMapping(value = "sendMsg",method = RequestMethod.POST)
    @ResponseBody
    public BaseResponse<SendMsgResVO> sendMsg(@RequestBody SendMsgReqVO sendMsgReqVO){
        BaseResponse<SendMsgResVO> res = new BaseResponse();
        cimServer.sendMsg(sendMsgReqVO) ;

        counterService.increment(Constants.COUNTER_SERVER_PUSH_COUNT);

        SendMsgResVO sendMsgResVO = new SendMsgResVO() ;
        sendMsgResVO.setMsg("OK") ;
        res.setCode(StatusEnum.SUCCESS.getCode()) ;
        res.setMessage(StatusEnum.SUCCESS.getMessage()) ;
        res.setDataBody(sendMsgResVO) ;
        return res ;
    }

}
