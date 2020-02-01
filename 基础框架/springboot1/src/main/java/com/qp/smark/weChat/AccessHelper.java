package com.qp.smark.weChat;

import com.qp.smark.config.WeChatConfig;
import com.qp.smark.util.*;
import net.sf.json.JSONObject;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class AccessHelper {

    /*获取access_token*/
    private static AccessEntity GetAccess_token(){
        String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=" + AuthUtil.APPID + "&secret=" + AuthUtil.APPSECRET;
        //        AccessEntity accessEntity = new AccessEntity();
        //通过网络请求方法来请求上面这个接口
        JSONObject jsonObject = AuthUtil.doGetJson(url);
        System.out.println(jsonObject);
        AccessEntity accessEntity = (AccessEntity) JSONObject.toBean(jsonObject,AccessEntity.class);
        return accessEntity;
    }

    /*获取access_token*/
    private static AccessEntity GetTicket(){
        ////获得jsapi_ticket
        String url = "https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token="+ isExistAccess_Token() +"&type=jsapi";//这个url链接和参数不能变

        JSONObject demoJson = AuthUtil.doGetJson(url);
        String ticket = demoJson.getString("ticket");
        AccessEntity accessEntity = new AccessEntity();
        accessEntity.setTicket(ticket);
        accessEntity.setExpires_in(demoJson.getString("expires_in"));

        return accessEntity;
    }


    //获取ticket
    private static String getTicket(String access_token) {
        String ticket = null;
        String url = "https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token="+ access_token +"&type=jsapi";//这个url链接和参数不能变
        try {
            URL urlGet = new URL(url);
            HttpURLConnection http = (HttpURLConnection) urlGet.openConnection();
            http.setRequestMethod("GET"); // 必须是get方式请求
            http.setRequestProperty("Content-Type","application/x-www-form-urlencoded");
            http.setDoOutput(true);
            http.setDoInput(true);
            System.setProperty("sun.net.client.defaultConnectTimeout", "30000");// 连接超时30秒
            System.setProperty("sun.net.client.defaultReadTimeout", "30000"); // 读取超时30秒
            http.connect();
            InputStream is = http.getInputStream();
            int size = is.available();
            byte[] jsonBytes = new byte[size];
            is.read(jsonBytes);
            String message = new String(jsonBytes, "UTF-8");
            JSONObject demoJson = JSONObject.fromObject(message);
            ticket = demoJson.getString("ticket");
            is.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ticket;
    }



    /*验证是否过期*/
    public static String isExistAccess_Token(){
        AccessEntity accessEntity = AccessTokenXmlUtil.getAccessEntity("tree_token");
        String token = accessEntity.getAccess_token();
        try {
            Date tempDate = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").parse(accessEntity.getTime());
            long expiresTemp = Long.parseLong(accessEntity.getExpires_in());
//            System.out.println(TimeUtil.dateConvertStr((new Date()),"yyyy/MM/dd HH:mm:ss"));
//            System.out.println(TimeUtil.dateConvertStr(tempDate,"yyyy/MM/dd HH:mm:ss"));
//            System.out.println(((new Date()).getTime() - tempDate.getTime()));
            if(((new Date()).getTime() - tempDate.getTime())/1000 > expiresTemp){
                accessEntity = GetAccess_token();
                accessEntity.setTime(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date()));
                AccessTokenXmlUtil.setAccessEntity(accessEntity,"tree_token");
                token = accessEntity.getAccess_token();
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return token;
    }

    /*验证是否过期*/
    public static String isExistTicket(){
        AccessEntity accessEntity = TicketXmlUtil.getAccessEntity("tree_ticket");
        String ticket = accessEntity.getTicket();
        try{
            Date tempDate = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").parse(accessEntity.getTime());
            long expiresTemp = Long.parseLong(accessEntity.getExpires_in());
            if(((new Date()).getTime() - tempDate.getTime())/1000 > expiresTemp){
                accessEntity = GetTicket();
                accessEntity.setTime(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date()));
                AccessTokenXmlUtil.setAccessEntity(accessEntity,"tree_ticket");
                ticket = accessEntity.getTicket();
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return ticket;
    }


    /*
    *发送模板信息
    * */
    public static String sendTemplateMsg(String accessToken, String data){
        String url = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=" + accessToken;
//        String str = HttpClientUtil.doPostJson(url,data);
        String str = AuthUtil.sendPostJsonStr(url,data);
        System.out.println(str);
        return  null;
    }

    public static void  makeTemplateMsg(Map<String,Object> map){

        TemplateEntity templateEntity = new TemplateEntity();
        templateEntity.setTemplate_id(WeChatConfig.getValue("template_id"));
        templateEntity.setTouser((String) map.get("oppenid"));
        templateEntity.setUrl((String)map.get("url"));

        Map<String,TemplateData> template_Data = new HashMap<>();
        TemplateData first = new TemplateData();
        first.setColor("#173177");
        first.setValue((String) map.get("first"));
        template_Data.put("first", first);

        TemplateData keyword1 = new TemplateData();
        keyword1.setColor("#173177");
        keyword1.setValue((String) map.get("act"));
        template_Data.put("keyword1", keyword1);

        TemplateData keyword2 = new TemplateData();
        keyword2.setColor("#173177");
        keyword2.setValue((String) map.get("act_path"));
        template_Data.put("keyword2", keyword2);


        TemplateData keyword3 = new TemplateData();
        keyword3.setColor("#173177");
        keyword3.setValue((String) map.get("act_time"));
        template_Data.put("keyword3", keyword3);

        TemplateData keyword4 = new TemplateData();
        keyword4.setColor("#173177");
        keyword4.setValue((String) map.get("join_price"));
        template_Data.put("keyword4", keyword4);

        TemplateData keyword5 = new TemplateData();
        keyword5.setColor("#173177");
        keyword5.setValue((String) map.get("act_remind"));
        template_Data.put("keyword5", keyword5);

        TemplateData remark = new TemplateData();
        remark.setColor("#173177");
        remark.setValue("请时刻关注活动动态，避免错过，如有疑问请联系主办方。");
        template_Data.put("remark", remark);

        templateEntity.setData(template_Data);

        // 将菜单对象转换成json字符串
        String jsonMenu = com.alibaba.fastjson.JSONObject.toJSONString(templateEntity);
        System.out.println(jsonMenu);
        AccessHelper.sendTemplateMsg(AccessHelper.isExistAccess_Token(),jsonMenu);
    }


    public static Map<String, String> weixinjsIntefaceSign(Map<String, String> map){
        //查看缓存数据是否存在
        String cacheTicket = isExistTicket();


        Map<String,String> mapSign = Sign.convertSign(cacheTicket,map.get("url"));
        mapSign.put("appId",map.get("appid"));

        //生成签名
//        SortedMap<Object,Object> params = new TreeMap<Object,Object>();
//        params.put("timestamp", Long.toString(new Date().getTime()/1000));
//        params.put("noncestr", CreateNoncestr());
//        params.put("jsapi_ticket",cacheTicket);
//        params.put("url",map.get("url"));//url地址
//        StringBuffer sb = new StringBuffer();
//        Set es = params.entrySet();
//        Iterator it = es.iterator();
//        while(it.hasNext()) {
//            Map.Entry entry = (Map.Entry)it.next();
//            String k = (String)entry.getKey();
//            Object v = entry.getValue();
//            sb.append(k + "=" + v + "&");
//        }
//        String signStr = sb.toString().substring(0, sb.toString().length()-1);
//        String sign = Sha1.getSha1Sign(signStr);//签名
//        Map<String, String> result = new HashMap<String,String>();
//        result.put("timestamp",(String)params.get("timestamp"));
//        result.put("noncestr", (String)params.get("noncestr"));
//        result.put("signature", sign);
//        result.put("appId",map.get("appid"));
//
//        return result;

        return  mapSign;
    }

    private static String CreateNoncestr() {
        String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        String res = "";
        for (int i = 0; i < 16; i++) {
            Random rd = new Random();
            res += chars.charAt(rd.nextInt(chars.length() - 1));
        }
        return res;
    }



    public static void main(String[] args) throws ParseException {
        isExistAccess_Token();
        System.out.println(AccessTokenXmlUtil.getAccessEntity("tree_token"));
        isExistAccess_Token();
//        System.out.println(((new Date()).getTime() - (new SimpleDateFormat("yyyy/MM/dd hh:mm:ss").parse("2019/10/31 15:05:34")).getTime())/1000);
//        makeTemplateMsg("oFS4o57eEqrI74l6vOA-UdHG10Ng","彭凡");
    }
}
