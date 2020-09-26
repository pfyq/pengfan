package com.pf.temp.myspitext.test.print;

/**
 * Created by yihui on 2017/5/24.
 */
public class ConsolePrint implements IPrint {

    @Override
    public void print(String str) {
        System.out.println("console print: " + str);
    }

    @Override
    public void adaptivePrint(String conf, String str) {
        System.out.println("console adaptivePrint: " + str);
    }
}
