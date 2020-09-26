package com.pf.excel.config;

import org.springframework.util.ResourceUtils;

import java.io.FileNotFoundException;

public class TestFileUtil {


    public static String getPath() throws FileNotFoundException {
        return ResourceUtils.getURL("classpath:").getPath();
    }


}
