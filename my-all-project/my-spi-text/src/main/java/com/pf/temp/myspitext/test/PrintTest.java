package com.pf.temp.myspitext.test;

import com.pf.temp.myspitext.SpiLoader;
import com.pf.temp.myspitext.exception.NoSpiMatchException;
import com.pf.temp.myspitext.exception.SpiProxyCompileException;
import com.pf.temp.myspitext.service.HelloInterface;
import com.pf.temp.myspitext.test.print.IPrint;
import org.junit.Assert;
import org.junit.Test;

import java.util.ServiceLoader;

public class PrintTest {

    @Test
    public void testSPI() {
        ServiceLoader<HelloInterface> serviceLoader = ServiceLoader.load(HelloInterface.class);
        for (HelloInterface hello: serviceLoader) {
            hello.sayHello();
        }
    }


    //静态获取SPI实现  根据传入的条件，选择一个满足条件的实现返回
    @Test
    public void testPrint() throws NoSpiMatchException {
        //触发的action 主要是初始化所有的选择器
        SpiLoader<IPrint> spiLoader = SpiLoader.load(IPrint.class);

        //根据name获取实现类
        IPrint print = spiLoader.getService("ConsolePrint");
        print.print("console---->");


        print = spiLoader.getService("FilePrint");
        print.print("file---->");


        try {
            print = spiLoader.getService("undefine");
            print.print("undefine----");
            Assert.assertTrue(false);
        } catch (Exception e) {
            System.out.println("type error-->" + e);
        }


        try {
            print = spiLoader.getService(123);
            print.print("type error----");
            Assert.assertTrue(false);
        } catch (Exception e){
            System.out.println("type error-->" + e);
        }
    }

    //动态获取SPI实现
    @Test
    public void testAdaptivePrint() throws SpiProxyCompileException {
        IPrint print = SpiLoader.load(IPrint.class).getAdaptive();

        print.adaptivePrint("FilePrint", "[file print]");
        print.adaptivePrint("ConsolePrint", "[console print]");
    }
}
