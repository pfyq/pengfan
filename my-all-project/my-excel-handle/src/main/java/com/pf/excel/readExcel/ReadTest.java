package com.pf.excel.readExcel;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.read.metadata.ReadSheet;
import com.pf.excel.ExcelApplication;
import com.pf.excel.config.TestFileUtil;
import com.pf.excel.readExcel.entity.ConverterData;
import com.pf.excel.readExcel.entity.DemoData;
import com.pf.excel.readExcel.entity.ExcelTemplate;
import com.pf.excel.readExcel.entity.IndexOrNameData;
import com.pf.excel.readExcel.listener.DemoDataListener;
import com.pf.excel.readExcel.listener.ExcelTemplateListener;
import com.pf.excel.readExcel.listener.IndexOrNameDataListener;
import org.junit.Ignore;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.FileNotFoundException;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ExcelApplication.class)
public class ReadTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(ReadTest.class);

    @Autowired
    private ExcelTemplateListener excelTemplateListener;

    @Test
    public void excelTemplateRead() throws FileNotFoundException {
        String fileName = "F:\\ideaWork\\gk_project\\行业代码查询表(1).xls";
        EasyExcel.read(fileName, ExcelTemplate.class,excelTemplateListener).sheet().headRowNumber(5).doRead();
    }



    /**
     * 最简单的读
     * <p>
     * 1. 创建excel对应的实体对象 参照{@link DemoData}
     * <p>
     * 2. 由于默认一行行的读取excel，所以需要创建excel一行一行的回调监听器，参照{@link DemoDataListener}
     * <p>
     * 3. 直接读即可
     */
    @Test
    public void simpleRead() throws FileNotFoundException {
        // 有个很重要的点 DemoDataListener 不能被spring管理，要每次读取excel都要new,然后里面用到spring可以构造方法传进去
        // 写法1：
        String fileName = TestFileUtil.getPath() + "demo" + File.separator + "demo.xlsx";
        // 这里 需要指定读用哪个class去读，然后读取第一个sheet 文件流会自动关闭
        EasyExcel.read(fileName, DemoData.class, new DemoDataListener()).sheet().doRead();

        // 写法2：
//        fileName = TestFileUtil.getPath() + "demo" + File.separator + "demo.xlsx";
//        ExcelReader excelReader = EasyExcel.read(fileName, DemoData.class, new DemoDataListener()).build();
//        ReadSheet readSheet = EasyExcel.readSheet(0).build();
//        excelReader.read(readSheet);
//        // 这里千万别忘记关闭，读的时候会创建临时文件，到时磁盘会崩的
//        excelReader.finish();
    }

    /**
     * 指定列的下标或者列名
     *
     * <p>1. 创建excel对应的实体对象,并使用{ ExcelProperty}注解. 参照{@link IndexOrNameData}
     * <p>2. 由于默认一行行的读取excel，所以需要创建excel一行一行的回调监听器，参照{@link IndexOrNameDataListener}
     * <p>3. 直接读即可
     */
    @Test
    public void indexOrNameRead() throws FileNotFoundException {
        String fileName = TestFileUtil.getPath() + "demo" + File.separator + "demo.xlsx";
        // 这里默认读取第一个sheet
        EasyExcel.read(fileName, IndexOrNameData.class, new IndexOrNameDataListener()).sheet().doRead();
    }

    /**
     * 读多个或者全部sheet,这里注意一个sheet不能读取多次，多次读取需要重新读取文件
     * <p>
     * 1. 创建excel对应的实体对象 参照{@link DemoData}
     * <p>
     * 2. 由于默认一行行的读取excel，所以需要创建excel一行一行的回调监听器，参照{@link DemoDataListener}
     * <p>
     * 3. 直接读即可
     */
    @Test
    public void repeatedRead() throws FileNotFoundException {
        String fileName = TestFileUtil.getPath() + "demo" + File.separator + "demo.xlsx";
        // 读取全部sheet
        // 这里需要注意 DemoDataListener的doAfterAllAnalysed 会在每个sheet读取完毕后调用一次。然后所有sheet都会往同一个DemoDataListener里面写
        EasyExcel.read(fileName, DemoData.class, new DemoDataListener()).doReadAll();

        // 读取部分sheet
        fileName = TestFileUtil.getPath() + "demo" + File.separator + "demo.xlsx";
        ExcelReader excelReader = EasyExcel.read(fileName).build();
        // 这里为了简单 所以注册了 同样的head 和Listener 自己使用功能必须不同的Listener
        ReadSheet readSheet1 =
                EasyExcel.readSheet(0).head(DemoData.class).registerReadListener(new DemoDataListener()).build();
        ReadSheet readSheet2 =
                EasyExcel.readSheet(1).head(DemoData.class).registerReadListener(new DemoDataListener()).build();
        // 这里注意 一定要把sheet1 sheet2 一起传进去，不然有个问题就是03版的excel 会读取多次，浪费性能
        excelReader.read(readSheet1, readSheet2);
        // 这里千万别忘记关闭，读的时候会创建临时文件，到时磁盘会崩的
        excelReader.finish();
    }


    /**
     * 日期、数字或者自定义格式转换
     * <p>
     * 默认读的转换器{DefaultConverterLoader#loadDefaultReadConverter()}
     * <p>1. 创建excel对应的实体对象 参照{@link ConverterData}.里面可以使用注解{ DateTimeFormat}、{ NumberFormat}或者自定义注解
     * <p>2. 由于默认一行行的读取excel，所以需要创建excel一行一行的回调监听器，参照{ ConverterDataListener}
     * <p>3. 直接读即可
     */
    @Test
    public void converterRead() {
//        String fileName = TestFileUtil.getPath() + "demo" + File.separator + "demo.xlsx";
//        // 这里 需要指定读用哪个class去读，然后读取第一个sheet
//        EasyExcel.read(fileName, ConverterData.class, new ConverterDataListener())
//                // 这里注意 我们也可以registerConverter来指定自定义转换器， 但是这个转换变成全局了， 所有java为string,excel为string的都会用这个转换器。
//                // 如果就想单个字段使用请使用@ExcelProperty 指定converter
//                // .registerConverter(new CustomStringStringConverter())
//                // 读取sheet
//                .sheet().doRead();
    }
}
