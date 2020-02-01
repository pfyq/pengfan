/*
 *
 * Copyright (C) 1999-2012 IFLYTEK Inc.All Rights Reserved.
 *
 * FileName：AuthUtil.java
 *
 * Description：
 *
 * History：
 * Version   Author      Date            Operation
 * 1.0	  15895085799   2018-8-21下午5:34:57	       Create
 */
package com.qp.smark.util;

import com.qp.smark.config.WeChatConfig;
import net.sf.json.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

import java.io.IOException;



import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;


/**
 *
 * @author 15895085799
 * @create 2018-8-21 下午5:34:57
 * @version 1.0
 * @since 1.0
 */
public class AuthUtil {

    private static final Logger log = Logger.getLogger(AuthUtil.class);

    public static final String APPID = WeChatConfig.getValue("APPID");//"wx7782ef1783cb3bbb";
    public static final String APPSECRET = WeChatConfig.getValue("APPSECRET");//"d366c6a1e8423898430c31647a31948f";

    public static JSONObject doGetJson(String url){
        JSONObject jsonObject = null;
        //首先初始化HttpClient对象
        HttpClient httpClient = new DefaultHttpClient();
//        CloseableHttpClient httpClient = HttpClients.createDefault();
        log.error("url  "+url);
        //通过get方式进行提交
        HttpGet httpGet = new HttpGet(url);
        //通过HTTPclient的execute方法进行发送请求
        HttpResponse response = null;
        try {
            response = httpClient.execute(httpGet);
            //从response里面拿自己想要的结果
            HttpEntity entity = response.getEntity();
            if(entity != null){
                String result = EntityUtils.toString(entity,"UTF-8");
                jsonObject = jsonObject.fromObject(result);
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        //把链接释放掉
        httpGet.releaseConnection();
        return jsonObject;
    }

    /**
     * 以jsonString形式发送HttpPost的Json请求，String形式返回响应结果
     *
     * @param url
     * @param jsonString
     * @return
     */
    public static String sendPostJsonStr(String url, String jsonString){
        String resp = "";
        try {
            if (jsonString == null || jsonString.isEmpty()) {
                return sendPost(url);
            }
            StringEntity entityStr = new StringEntity(jsonString,
                    ContentType.create("text/plain", "UTF-8"));
            CloseableHttpClient httpClient = HttpClients.createDefault();
            HttpPost httpPost = new HttpPost(url);
            httpPost.setEntity(entityStr);
            CloseableHttpResponse response = null;
            try {
                response = httpClient.execute(httpPost);
                HttpEntity entity = response.getEntity();
                resp = EntityUtils.toString(entity, "UTF-8");
                EntityUtils.consume(entity);
            } catch (ClientProtocolException e) {
                log.error(e.getMessage());
            } catch (IOException e) {
                log.error(e.getMessage());
            } finally {
                if (response != null) {
                    try {
                        response.close();
                    } catch (IOException e) {
                        log.error(e.getMessage());
                    }
                }
            }
            if (resp == null || resp.equals("")) {
                return "";
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return resp;
    }

    /**
     * 发送不带参数的HttpPost请求
     *
     * @param url
     * @return
     */
    public static String sendPost(String url) throws IOException {
        // 1.获得一个httpclient对象
        CloseableHttpClient httpclient = HttpClients.createDefault();
        // 2.生成一个post请求
        HttpPost httppost = new HttpPost(url);
        CloseableHttpResponse response = null;
        try {
            // 3.执行get请求并返回结果
            response = httpclient.execute(httppost);
        } catch (IOException e) {
            log.error(e.getMessage());
        }
        // 4.处理结果，这里将结果返回为字符串
        HttpEntity entity = response.getEntity();
        String result = null;
        try {
            result = EntityUtils.toString(entity);
        } catch (ParseException | IOException e) {
            log.error(e.getMessage());
        }
        return result;
    }
}
