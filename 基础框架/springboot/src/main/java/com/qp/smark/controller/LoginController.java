/* 
 *
 * Copyright (C) 1999-2012 IFLYTEK Inc.All Rights Reserved. 
 * 
 * FileName：LoginController.java
 * 
 * Description：
 * 
 * History：
 * Version   Author      Date            Operation 
 * 1.0	  15895085799   2018-5-18下午3:40:45	       Create	
 */
package com.qp.smark.controller;

import com.qp.smark.dao.UsersMapper;
import com.qp.smark.entity.Users;
import com.qp.smark.util.CookieTool;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.apache.commons.codec.digest.DigestUtils;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 
 * @author 15895085799 
 * @create 2018-5-18 下午3:40:45
 * @version 1.0
 * @since 1.0
 */
@Controller
@RequestMapping("/login")
public class LoginController {

    private static final Logger log = Logger.getLogger(LoginController.class);
    @Autowired
    private UsersMapper usersMapper;

    @RequestMapping("/lg")
    public String login(){
        System.out.println("aa");
        return "login";
    }


    //登录验证
    @RequestMapping(value="/validate",produces="text/html;charset=UTF-8")//仅当request请求头中的(Accept)类型中包含该指定类型才返回
    @ResponseBody
    public String validate(Users user, String rememberPwd,
                           HttpSession session,
                           HttpServletResponse httpResponse,
                           HttpServletRequest request){
        String msg = null;
        try{
            if(user.getName()==null||user.getName()==""){
                return "用户名不能为空!";
            }
            if(user.getPassword()==null||user.getPassword()==""){
                return "密码不能为空!";
            }
            String password = user.getPassword();
            user.setPassword(DigestUtils.shaHex(password));
            System.out.println(user.getName()+" "+user.getPassword());
            List<Users> lists = usersMapper.allOfName(user.getName());//获取登录的用户信息
            Users us = null;
            if(lists.size() == 0){
                return "用户名不存在!";
            }
            for(int i = 0;i < lists.size();i++){
                if(user.getPassword().equals(lists.get(i).getPassword())){
                    us = lists.get(i);
                }
            }
            if(us != null){
                session.setAttribute("userId",us.getId());
                session.setAttribute("username",us.getName());
//                session.setAttribute("level",user.getLevel());
//                session.setAttribute("uname", us.getName());
                if("rememberPwd".equals(rememberPwd)){
                    int  loginMaxAge = 30*24*60*60;//秒为单位
                    CookieTool.addCookie(httpResponse , "loginName" ,user.getName(), loginMaxAge); //将姓名加入到cookie中
                    CookieTool.addCookie(httpResponse , "loginPwd" , password, loginMaxAge);   //将密码加入到cookie中
                }else{
                    CookieTool.delCookie(request,httpResponse,"loginName"); // 清除Cookie
                    CookieTool.delCookie(request,httpResponse,"loginPwd"); // 清除Cookie
                }
                msg = us.getId()+"";
            }else{
                msg =  "密码错误!";
            }
        }catch(Exception e){
            log.error(e.getMessage(),e);
        }
        return msg;
    }


    @RequestMapping("/visite")
    @ResponseBody
    public Users visite(@CookieValue(value="loginName",required=false) String userName,
                       @CookieValue(value="loginPwd",required=false) String password){
        Users user = new Users();
        user.setName(userName);
        user.setPassword(password);
        return user;
    }

    @RequestMapping("/go")
    public String index(){
        return "test";
    }

    //退出登录状态
    @RequestMapping("/logout")
    public String loggin(HttpSession session){
        try{
            session.removeAttribute("userId");
            session.removeAttribute("username");
            return "login";
        }catch(Exception e){
            return "error";
        }
    }

}
