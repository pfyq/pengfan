package com.qp.smark.util;

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

public class TreeXmlUtil {

    private static final Logger log = Logger.getLogger(TreeXmlUtil.class);
    private static Document document;

    static{
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;
        try {
            builder = factory.newDocumentBuilder();
            Document document = builder.parse(TreeXmlUtil.class.getClassLoader().getResource("").getPath()+"tree.xml");
            TreeXmlUtil.document = document;
        } catch (ParserConfigurationException e) {
            log.error(e.getMessage(), e);
        } catch (SAXException e) {
            log.error(e.getMessage(), e);
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }

    }

    public static synchronized List<Tree> getUserList(String id){
        List<Tree> trees = new ArrayList<Tree>();

        NodeList nList = document.getElementsByTagName("tree");
        for(int i = 0;i < nList.getLength();i++){
            Element element = (Element) nList.item(i);
            if(element.getAttribute("id").equals(id)){
                NodeList html_lis = element.getChildNodes();
                for(int j = 0;j < html_lis.getLength();j++){
                    if(html_lis.item(j) instanceof Element){
                        Element ele_li =(Element) html_lis.item(j);
                        Tree tree = new Tree();
                        tree.setId(ele_li.getAttribute("id"));
                        tree.setText(ele_li.getAttribute("text"));
                        trees.add(tree);
                    }
                }
            }
        }
        return trees;
    }

    public static void main(String[] args) {
        getUserList("tree_user");
    }
}
