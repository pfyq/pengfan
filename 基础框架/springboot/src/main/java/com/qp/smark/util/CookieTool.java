package com.qp.smark.util;

import org.apache.log4j.Logger;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

public class CookieTool {
	private final static Logger log=Logger.getLogger(CookieTool.class);
	/**
	 * 设置cookie（接口方法）
	 * @author 刘鹏
	 * @param response
	 * @param name  cookie名字
	 * @param value cookie值
	 * @param maxAge cookie生命周期  以秒为单位
	 */
	public static void addCookie(HttpServletResponse response,String name,String value,int maxAge){
		//URLDecoder.decode(cookies[i].getName(),"utf-8");
		Cookie cookie;
		try {
			cookie = new Cookie(name,URLEncoder.encode(value, "utf-8"));
			cookie.setPath("/");
			if(maxAge>0){
				cookie.setMaxAge(maxAge);
			}
			response.addCookie(cookie);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			log.error(e.getMessage(),e);
		}
	}

	/**
	 * 根据名字获取cookie（接口方法）
	 * @author 刘鹏
	 * @param request
	 * @param name cookie名字
	 * @return
	 */
	public static Cookie getCookieByName(HttpServletRequest request,String name){
		Map<String,Cookie> cookieMap = ReadCookieMap(request);
		if(cookieMap.containsKey(name)){
			Cookie cookie = (Cookie)cookieMap.get(name);
			return cookie;
		}else{
			return null;
		}
	}

	/**
	 * 将cookie封装到Map里面（非接口方法）
	 * @author 刘鹏
	 * @param request
	 * @return
	 */
	private static Map<String,Cookie> ReadCookieMap(HttpServletRequest request){
		Map<String,Cookie> cookieMap = new HashMap<String,Cookie>();
		Cookie[] cookies = request.getCookies();
		if(null!=cookies){
			for(Cookie cookie : cookies){
				cookieMap.put(cookie.getName(), cookie);
			}
		}
		return cookieMap;
	}
	//删除cookie
	public static void delCookie(HttpServletRequest request,HttpServletResponse response,String name){
		Cookie[] cookies = request.getCookies();
		if (null==cookies) {
			log.info("没有cookie==============");
		} else {
			for(Cookie cookie : cookies){
				if(cookie.getName().equals(name)){
					cookie.setValue(null);
					cookie.setMaxAge(0);// 立即销毁cookie
					cookie.setPath("/");
					response.addCookie(cookie);
					break;
				}
			}
		}
	}
}
