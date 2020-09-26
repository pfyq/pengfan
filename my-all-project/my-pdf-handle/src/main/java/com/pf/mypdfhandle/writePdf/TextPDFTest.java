package com.pf.mypdfhandle.writePdf;


import com.pf.mypdfhandle.writePdf.util.TextPDF;
import com.pf.mypdfhandle.writePdf.util.entity.TextChunk;
import com.pf.mypdfhandle.writePdf.util.parser.MyTextDocHandler;
import com.pf.mypdfhandle.writePdf.util.parser.TextParser;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

public class TextPDFTest {

	@Test
	public void test() {
		try {
			File xmlfile = new File("tests/test.xml");
			System.out.println(xmlfile.exists());
			File jsonfile = new File("tests/test.json");
			File pdffile = new File("tests/test.pdf");
			TextPDF.gen(xmlfile, jsonfile, pdffile);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@Test
	public void myTest() throws Exception {
		File pdffile = new File("tests/test.pdf");
		TextParser parser = new TextParser(new FileOutputStream(pdffile));
		MyTextDocHandler myTextDocHandler = parser.getMyTextDocHandler();
		List<TextChunk> chunk_list = new ArrayList<>();
		TextChunk textChunk = new TextChunk();
		textChunk.setContents("aaaabbbbbb");
		textChunk.addAttr("font-style", "bold,underline");
		chunk_list.add(textChunk);
		myTextDocHandler.openDom();
		myTextDocHandler.genPdf("para",chunk_list);
		myTextDocHandler.newPage();
		myTextDocHandler.genPdf("para",chunk_list);
		myTextDocHandler.newPage();
		myTextDocHandler.genPdf("para",chunk_list);
		myTextDocHandler.closeDom();
	}



	@Test
	public void myStrTest() {
		try {
			File pdffile = new File("tests/test.pdf");
			String xmlStr = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
					"\n" +
					"<textpdf>\n" +
					"  <title>标题</title>\n" +
					"  <title>一个文档中可以有多个标题</title>\n" +
					"  <title font-size=\"32\" font-style=\"underline\">标题可以自定义属性</title>\n" +
					"\n" +
					"  <chapter>第一章</chapter>\n" +
					"  <chapter indent=\"30\">第二章、可以通过 indent 来缩进</chapter>\n" +
					"\n" +
					"  <section>第一节</section>\n" +
					"\n" +
					"  <para>这是一段<span font-style=\"underline\">简单的</span>文字。</para>\n" +
					"\n" +
					"  <para>可以通过 value 作为动态数据<value id=\"vid_01\"/>，其数据来自于 test.json 文件。</para>\n" +
					"\n" +
					"  <para>一段文字不能通过在模板中输入换行符\n" +
					"    来换行，因为解析器会忽略模板中的回车符。如果需要强行换行，应该使用<break/>break 标签</para>\n" +
					"\n" +
					"  <para>    一段文字中的前后空白字符会被删除掉，但是中间    的空白会保留下来。如果需要左边缩进，请使用 indent 属性。</para>\n" +
					"  <para>也可以通过 <span font-style=\"bold\">hspace</span> <hspace size=\"10\"/>来设定水平空白空间。</para>\n" +
					"\n" +
					"  <para align=\"center\">文字可以居中对齐</para>\n" +
					"  <para align=\"right\">也可以右对齐</para>\n" +
					"\n" +
					"  <para space-before=\"30\" space-after=\"50\">可以通过 space-before 和 space-after 来设定段前段后空间。</para>\n" +
					"\n" +
					"  <table columns=\"3,3,1\" width=\"90\">\n" +
					"    <cell>单元一</cell>\n" +
					"    <cell>单元二</cell>\n" +
					"    <cell>单元三</cell>\n" +
					"    <cell colspan=\"2\" align=\"center\">第二行单元</cell>\n" +
					"    <cell align=\"right\">单元</cell>\n" +
					"  </table>\n" +
					"\n" +
					"  <para>下面将会强行换页，虽然本页还没有填满。</para>\n" +
					"\n" +
					"  <pagebreak/> <!-- 强行换页 -->\n" +
					"\n" +
					"  <span>这种內联元素会被完全丢弃，就更没有写这段文字一样。</span>\n" +
					"\n" +
					"  <para space-after=\"50\">关于模板更详细的信息请参考 TextPDF 的 <span font-style=\"bold\">wiki</span> 页面。</para>\n" +
					"\n" +
					"  <img src=\"tests/logo-32.png\" />\n" +
					"\n" +
					"  <para font-style=\"italic\" indent=\"0\">本内容由  <span font-style=\"bold,underline,italic\">Lucky Byte, Inc.</span> 呈上</para>\n" +
					"\n" +
					"</textpdf>";
			String jsonStr = "{\"title\":\"<\",\"data\":{\"vid_01\" : \"peng\"}}";
			TextPDF.gen(xmlStr,jsonStr,pdffile);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
