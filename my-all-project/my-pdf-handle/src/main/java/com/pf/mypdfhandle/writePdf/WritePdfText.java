package com.pf.mypdfhandle.writePdf;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;
import org.junit.Test;

import java.io.FileOutputStream;
import java.io.IOException;

public class WritePdfText {


    @Test
    public void text1() throws IOException, DocumentException {
        //创建文件
        Document document = new Document();
        //建立一个书写器
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("F:/ideaWork/gk_project/test6.pdf"));
        //打开文件
        document.open();

        //中文字体,解决中文不能显示问题
        BaseFont bfChinese = BaseFont.createFont("STSong-Light","UniGB-UCS2-H",BaseFont.NOT_EMBEDDED);

        //蓝色字体
        Font blueFont = new Font(bfChinese);
        blueFont.setColor(BaseColor.BLUE);
        //段落文本
        Paragraph paragraphBlue = new Paragraph("paragraphOne blue front", blueFont);
        document.add(paragraphBlue);

        //绿色字体
        Font greenFont = new Font(bfChinese);
        greenFont.setColor(BaseColor.GREEN);
        //创建章节
        Paragraph chapterTitle = new Paragraph("段落标题xxxx", greenFont);
        Chapter chapter1 = new Chapter(chapterTitle, 1);
        chapter1.setNumberDepth(0);

        Paragraph sectionTitle = new Paragraph("部分标题", greenFont);
        Section section1 = chapter1.addSection(sectionTitle);

        Paragraph sectionContent = new Paragraph("部分内容", blueFont);
        section1.add(sectionContent);

        //将章节添加到文章中
        document.add(chapter1);


        //绿色字体
        Font greenFont2 = new Font(bfChinese);
        greenFont2.setColor(BaseColor.GREEN);
        //创建章节
        Paragraph chapterTitle2 = new Paragraph("段落标题xxxx", greenFont2);
        Chapter chapter2 = new Chapter(chapterTitle2, 1);
        chapter2.setNumberDepth(0);

        Paragraph sectionTitle2 = new Paragraph("部分标题", greenFont2);
        Section section2 = chapter2.addSection(sectionTitle2);

        Paragraph sectionContent2 = new Paragraph("部分内容", blueFont);
        section2.add(sectionContent2);

        //将章节添加到文章中
        document.add(chapter2);


        //关闭文档
        document.close();
        //关闭书写器
        writer.close();
    }
}
