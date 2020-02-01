package com.qp.smark.util;

import org.apache.log4j.Logger;

import java.io.*;

public class LinuxUtil {

    private static final Logger log = Logger.getLogger(LinuxUtil.class);

    public static String exec(String command) throws InterruptedException {
        String returnString = "";
        Process pro = null;
        Runtime runTime = Runtime.getRuntime();
        if (runTime == null) {
            System.err.println("Create runtime false!");
        }
        try {
            pro = runTime.exec(command);
            BufferedReader input = new BufferedReader(new InputStreamReader(pro.getInputStream()));
            PrintWriter output = new PrintWriter(new OutputStreamWriter(pro.getOutputStream()));
            String line;
            while ((line = input.readLine()) != null) {
                returnString = returnString + line + "\n";
            }
            input.close();
            output.close();
            pro.destroy();
        } catch (IOException ex) {
            log.error("LinuxUtil shell命令执行出错了", ex);
        }
        return returnString;
    }

    public static void callShell(String shellString) {
        try {
            Process process = Runtime.getRuntime().exec(shellString);
            int exitValue = process.waitFor();
            if (0 != exitValue) {
                log.error("call shell failed. error code is :" + exitValue);
            }
        } catch (Throwable e) {
            log.error("call shell failed. " + e);
        }
    }

    /*
    * 判断是否是linux系统  大于0就是
    * */
    public static int linuxJudge(){
        return System.getProperty("os.name").toLowerCase().indexOf("linux");
    }
}
