package com.pf.ssm.util;

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
	 * ����cookie���ӿڷ����� 
	 * @author ���� 
	 * @param response 
	 * @param name  cookie���� 
	 * @param value cookieֵ 
	 * @param maxAge cookie��������  ����Ϊ��λ 
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
	 * �������ֻ�ȡcookie���ӿڷ����� 
	 * @author ���� 
	 * @param request 
	 * @param name cookie���� 
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
	 * ��cookie��װ��Map���棨�ǽӿڷ����� 
	 * @author ���� 
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
	//ɾ��cookie
	public static void delCookie(HttpServletRequest request,HttpServletResponse response,String name){
		Cookie[] cookies = request.getCookies();
        if (null==cookies) {
        	log.info("û��cookie==============");
        } else {
            for(Cookie cookie : cookies){
                if(cookie.getName().equals(name)){
                    cookie.setValue(null);
                    cookie.setMaxAge(0);// ��������cookie
                    cookie.setPath("/");
                    response.addCookie(cookie);
                    break;
                }
            }
        }
	}
}
