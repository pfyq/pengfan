package com.pf.ssm.controller.later;

import com.pf.ssm.dao.UserDao;
import com.pf.ssm.entity.User;
import com.pf.ssm.util.CookieTool;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.apache.commons.codec.digest.DigestUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/login")
@CrossOrigin
public class LoginController {

    private static final Logger log = Logger.getLogger(LoginController.class);
    @Autowired
    private UserDao userDao;
    //登录验证
    @RequestMapping(value="/validate",produces="text/html;charset=UTF-8")//仅当request请求头中的(Accept)类型中包含该指定类型才返回
    @ResponseBody
    public String validate(User user, String rememberPwd,
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
            List<User> lists = userDao.allOfName(user.getName());//获取登录的用户信息
            User us = null;
            if(lists.size() == 0){
                return "用户名不存在!";
            }
            for(int i = 0;i < lists.size();i++){
                if(user.getPassword().equals(lists.get(i).getPassword())){
                    us = lists.get(i);
                }
            }
            if(us != null){
                request.getSession().setAttribute("userId",us.getId());
                request.getSession().setAttribute("username",us.getName());
                // session.setAttribute("userId",us.getId());
                //  session.setAttribute("username",user.getReal_name());
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

    @RequestMapping("/lg")
    public String login(){
        System.out.println("lg");
        return "login";
    }


    @RequestMapping("/visite")
    @ResponseBody
    public User visite(@CookieValue(value="loginName",required=false) String userName,
                       @CookieValue(value="loginPwd",required=false) String password){
        User user = new User();
        user.setName(userName);
        user.setPassword(password);
        return user;
    }

    @RequestMapping("/go")
    public String index(){
        return "welcome/index";
    }

    //进入登录页面
    @RequestMapping("/logout")
    public String loggin(HttpServletRequest request){
        try{
            request.getSession().removeAttribute("userId");
            request.getSession().removeAttribute("username");
            return "login";
        }catch(Exception e){
            return "error";
        }
    }

}
