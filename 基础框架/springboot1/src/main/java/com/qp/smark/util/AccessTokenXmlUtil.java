package com.qp.smark.util;

import com.qp.smark.weChat.AccessEntity;
import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AccessTokenXmlUtil {

    private static final Logger log = Logger.getLogger(AccessTokenXmlUtil.class);
    private static Document document;

    static{
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;
        try {
            builder = factory.newDocumentBuilder();
            Document document = builder.parse(AccessTokenXmlUtil.class.getClassLoader().getResource("").getPath()+"access_token.xml");
            AccessTokenXmlUtil.document = document;
        } catch (ParserConfigurationException e) {
            log.error(e.getMessage(), e);
        } catch (SAXException e) {
            log.error(e.getMessage(), e);
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }

    }

    public static synchronized AccessEntity getAccessEntity(String id){
        AccessEntity accessEntitie = new AccessEntity();

        NodeList nList = document.getElementsByTagName("tree");
        for(int i = 0;i < nList.getLength();i++){
            Element element = (Element) nList.item(i);
            if(element.getAttribute("id").equals(id)){
                NodeList html_lis = element.getChildNodes();
                for(int j = 0;j < html_lis.getLength();j++){
                    if(html_lis.item(j) instanceof Element){
                        Element ele_li =(Element) html_lis.item(j);
                        if(ele_li.getAttribute("id").equals("token")){
                            accessEntitie.setAccess_token(ele_li.getTextContent());
                        }

                        if(ele_li.getAttribute("id").equals("ticket")){
                            accessEntitie.setTicket(ele_li.getTextContent());
                        }

                        if(ele_li.getAttribute("id").equals("time")){
                            accessEntitie.setTime(ele_li.getTextContent());
                        }

                        if(ele_li.getAttribute("id").equals("expires")){
                            accessEntitie.setExpires_in(ele_li.getTextContent());
                        }

                    }
                }
            }
        }
        return accessEntitie;
    }

    public static synchronized void setAccessEntity(AccessEntity accessEntity,String id){
        NodeList nList = document.getElementsByTagName("tree");
        for(int i = 0;i < nList.getLength();i++){
            Element element = (Element) nList.item(i);
            if(element.getAttribute("id").equals(id)){
                NodeList html_lis = element.getChildNodes();
                for(int j = 0;j < html_lis.getLength();j++){
                    if(html_lis.item(j) instanceof Element){
                        Element ele_li =(Element) html_lis.item(j);
                        if(ele_li.getAttribute("id").equals("token")){
                            ele_li.setTextContent(accessEntity.getAccess_token());
                        }

                        if(ele_li.getAttribute("id").equals("time")){
                            ele_li.setTextContent(accessEntity.getTime());
                        }

                        if(ele_li.getAttribute("id").equals("expires")){
                            ele_li.setTextContent(accessEntity.getExpires_in());
                        }
                    }
                }
            }
        }
    }


    public static void main(String[] args) {
        AccessEntity accessEntity = new AccessEntity();
        accessEntity.setAccess_token("12");
        accessEntity.setExpires_in("2");
        setAccessEntity(accessEntity,"tree_token");
        System.out.println(getAccessEntity("tree_token"));
    }
}
