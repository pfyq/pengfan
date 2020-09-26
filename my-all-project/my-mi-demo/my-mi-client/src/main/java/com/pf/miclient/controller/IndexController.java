package com.pf.miclient.controller;

import com.pf.miclient.client.CIMClient;
import com.pf.miclient.service.RouteRequest;
import com.pf.miclient.vo.req.StringReqVO;
import com.pf.miclient.vo.res.SendMsgResVO;
import com.pf.micommon.constant.Constants;
import com.pf.micommon.enums.StatusEnum;
import com.pf.micommon.res.BaseResponse;
import com.pf.micommon.res.NULLBody;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.metrics.CounterService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class IndexController {

    /**
     * 统计 service
     */
    @Autowired
    private CounterService counterService;

    @Autowired
    private CIMClient heartbeatClient ;



    @Autowired
    private RouteRequest routeRequest ;


    /**
     * 向服务端发消息 字符串
     * @param stringReqVO
     * @return
     */
    @ApiOperation("客户端发送消息，字符串")
    @RequestMapping(value = "sendStringMsg", method = RequestMethod.POST)
    @ResponseBody
    public BaseResponse<NULLBody> sendStringMsg(@RequestBody StringReqVO stringReqVO){
        BaseResponse<NULLBody> res = new BaseResponse();

        for (int i = 0; i < 100; i++) {
            heartbeatClient.sendStringMsg(stringReqVO.getMsg()) ;
        }

        // 利用 actuator 来自增
        counterService.increment(Constants.COUNTER_CLIENT_PUSH_COUNT);

        SendMsgResVO sendMsgResVO = new SendMsgResVO() ;
        sendMsgResVO.setMsg("OK") ;
        res.setCode(StatusEnum.SUCCESS.getCode()) ;
        res.setMessage(StatusEnum.SUCCESS.getMessage()) ;
        return res ;
    }

}
