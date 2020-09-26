package com.pf.unit.core.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.*;
import java.util.Enumeration;
import java.util.Iterator;

/**
 * Created by @author yihui in 18:01 19/12/25.
 */
public class IpUtil {
    private static final Logger log = LoggerFactory.getLogger(IpUtil.class);
    public static final String DEFAULT_IP = "127.0.0.1";
    private static String ip = null;

    public static String getLocalIpByNetCard() {
        try {
            Enumeration e = NetworkInterface.getNetworkInterfaces();

            while (e.hasMoreElements()) {
                NetworkInterface item = (NetworkInterface) e.nextElement();
                Iterator var2 = item.getInterfaceAddresses().iterator();

                while (var2.hasNext()) {
                    InterfaceAddress address = (InterfaceAddress) var2.next();
                    if (!item.isLoopback() && item.isUp() && address.getAddress() instanceof Inet4Address) {
                        return ((Inet4Address) address.getAddress()).getHostAddress();
                    }
                }
            }

            return InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException | SocketException var4) {
            throw new RuntimeException(var4);
        }
    }

    public static String getLocalIp() {
        if (ip == null) {
            try {
                ip = getLocalIpByNetCard();
            } catch (Exception var1) {
                log.error("get local server ip error!");
                ip = DEFAULT_IP;
            }
        }

        return ip;
    }
}
