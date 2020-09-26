package com.pf.temp.myspitext.test.print;


import com.pf.temp.myspitext.anno.Spi;

/**
 * Created by yihui on 2017/5/24.
 */
@Spi
public interface IPrint {

    void print(String str);


    void adaptivePrint(String conf, String str);

}
