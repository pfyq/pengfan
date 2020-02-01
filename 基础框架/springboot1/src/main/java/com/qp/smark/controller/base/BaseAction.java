package com.qp.smark.controller.base;

import com.qp.smark.entity.base.BaseEntity;
import com.qp.smark.entity.log.SysLogInfo;
import com.qp.smark.model.OperatorType;
import org.springframework.beans.propertyeditors.PropertiesEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import javax.servlet.http.HttpServletRequest;
import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class BaseAction<T> {

    public final static String SUCCESS = "success";

    public final static String MSG = "msg";

    public final static String DATA = "data";

    public final static String LOGOUT_FLAG = "logoutFlag";


    /**
     * 获取具体的模块描述
     *
     * @return
     */
    protected abstract String getClassDesc();

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Date.class, new MyDateEditor());
        binder.registerCustomEditor(Double.class, new DoubleEditor());
        binder.registerCustomEditor(Integer.class, new IntegerEditor());
    }

    private class MyDateEditor extends PropertyEditorSupport {
        @Override
        public void setAsText(String text) throws IllegalArgumentException {
            System.out.println("MyDateEditor");
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = null;
            try {
                date = format.parse(text);
            } catch (ParseException e) {
                format = new SimpleDateFormat("yyyy-MM-dd");
                try {
                    date = format.parse(text);
                } catch (ParseException e1) {
                }
            }
            setValue(date);
        }
    }

    public class DoubleEditor extends PropertiesEditor  {
        @Override
        public void setAsText(String text) throws IllegalArgumentException {
            System.out.println("DoubleEditor");
            if (text == null || text.equals("")) {
                text = "0";
            }
            setValue(Double.parseDouble(text));
        }

        @Override
        public String getAsText() {
            return getValue().toString();
        }
    }

    public class IntegerEditor extends PropertiesEditor {
        @Override
        public void setAsText(String text) throws IllegalArgumentException {
            System.out.println("IntegerEditor");
            if (text == null || text.equals("")) {
                text = "0";
            }
            setValue(Integer.parseInt(text));
        }

        @Override
        public String getAsText() {
            return getValue().toString();
        }
    }


    /**
     * 获取IP地址
     *
     * @param request
     * @return
     */
    public String getIpAddr(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }


    /**
     * 记录日志信息
     *
     * @param request
     * @throws Exception
     */
    public void writeLogInfo(HttpServletRequest request, BaseEntity entity, String entityId,
                             OperatorType type) throws Exception {
        // 记录日志信息
        SysLogInfo log = new SysLogInfo();
//        log.setModuleName(getClassDesc());
////        log.setOpType(type.getValue());
////        log.setOpId(entityId);
////        log.setCreator(SessionUtils.getUserId(request));
////        log.setIp(getIpAddr(request));
////        log.setOpEntity(entity.getClass().getName());
////        log.setLogContent(entity.toLogInfo());
////        log.setOperName(SessionUtils.getUserName(request));
////        sysLogInfoService.insert(log);
    }

}
