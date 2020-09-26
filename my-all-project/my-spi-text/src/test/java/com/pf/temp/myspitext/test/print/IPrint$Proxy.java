package com.pf.temp.myspitext.test.print;


import com.pf.temp.myspitext.SpiLoader;
import com.pf.temp.myspitext.exception.NoSpiMatchException;

public class IPrint$Proxy implements IPrint {

    public void print(String arg0) {
        try {
            IPrint spiImpl = SpiLoader.load(IPrint.class).getService(arg0, "print");
            spiImpl.print(arg0);
        } catch (NoSpiMatchException e) {
            throw new RuntimeException(e);
        }
    }

    public void adaptivePrint(String arg0, String arg1) {
        try {
            IPrint spiImpl = SpiLoader.load(IPrint.class).getService(arg0, "adaptivePrint");
            spiImpl.adaptivePrint(arg0, arg1);
        } catch (NoSpiMatchException e) {
            throw new RuntimeException(e);
        }
    }
}
