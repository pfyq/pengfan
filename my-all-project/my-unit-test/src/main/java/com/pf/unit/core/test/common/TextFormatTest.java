package com.pf.unit.core.test.common;

import org.junit.Test;

import java.text.MessageFormat;

/**
 * Created by yihui on 2018/3/27.
 */
public class TextFormatTest {

    @Test
    public void testTempate() {
        System.out.println(MessageFormat.format("hello {0}, just a protoServer {2}", "xiao", "what", 123));
    }

}
