package com.qp.smark.util;

import java.util.Formatter;

public class Bytetohex {

    //字节数组按照一定格式转换拼装成字符串用于打印显示
    public static String bytetohexString(byte[] b) {
        int len = b.length;
        StringBuilder sb = new StringBuilder(b.length * (2 + 1));
        Formatter formatter = new Formatter(sb);

        for (int i = 0; i < len; i++) {
            if (i < len - 1)
                formatter.format("0x%02X,", b[i]);
            else
                formatter.format("0x%02X", b[i]);

        }
        formatter.close();

        return sb.toString();
    }

    public static byte[] toByteArray(String hexString) {
        if (hexString == null || "".equals(hexString.trim()))
            return null;
        hexString = hexString.toLowerCase();
        final byte[] byteArray = new byte[hexString.length() >> 1];
        int index = 0;
        for (int i = 0; i < hexString.length(); i++) {
            if (index  > hexString.length() - 1)
                return byteArray;
            byte highDit = (byte) (Character.digit(hexString.charAt(index), 16) & 0xFF);
            byte lowDit = (byte) (Character.digit(hexString.charAt(index + 1), 16) & 0xFF);
            byteArray[i] = (byte) (highDit << 4 | lowDit);
            index += 2;
        }
        return byteArray;
    }

    public static String toHexString(byte[] byteArray) {
        final StringBuilder hexString = new StringBuilder("");
        if (byteArray == null || byteArray.length <= 0)
            return null;
        for (int i = 0; i < byteArray.length; i++) {
            int v = byteArray[i] & 0xFF;
            String hv = Integer.toHexString(v);
            if (hv.length() < 2) {
                hexString.append(0);
            }
            hexString.append(hv);
        }
        return hexString.toString().toLowerCase();
    }

    public static String toHexString1(byte[] byteArray) {
        final StringBuilder hexString = new StringBuilder("");
        if (byteArray == null || byteArray.length <= 0)
            return null;
        for (int i = 0; i < byteArray.length; i++) {
            int v = byteArray[i] & 0xFF;
            String hv = Integer.toHexString(v);
            if (i  < byteArray.length - 1){
                if (hv.length() < 2) {
                    hexString.append(0);
                }
                hexString.append(hv + ",");
            }else{
                if (hv.length() < 2) {
                    hexString.append(0);
                }
                hexString.append(hv);
            }
        }
        return hexString.toString().toLowerCase();
    }


    /**
     * * 反序列化byte[]为object或者String。</br>
     * * 注意：如果是Object序列化后的byte[],仅适用jdk自带的序列化</br>
     * * 使用本方法能避免直接反序列化，通过异常判断是String还是Object（只有巧合的走异常流程）。
     */
    public static Object unSerializeObjOrString(byte[] bytes)
    {
        // 不足6位，直接认为是字符串，,经测试单个字符序列化后的byte[]也有8位
        if (bytes.length < 6)
        {
            return SerializeUtil.Byte2String(bytes);
        }

        String protocol = Integer.toHexString(bytes[0] & 0x000000ff) + Integer.toHexString(bytes[1] & 0x000000ff);

        // 如果是jdk序列化后的
        if ("ACED".equals(protocol.toUpperCase()))
        {
            Object obj = SerializeUtil.unserializeObj(bytes);

            if (obj != null)
            {
                return obj;
            }

            // 如果是巧合，则返回的是null
            else
            {
                return SerializeUtil.Byte2String(bytes);
            }
        }

        // 如果是字符串的byte[]字节形式
        return SerializeUtil.Byte2String(bytes);
    }

    public static String toHex(int num){
        char[] chs = new char[8];//定义容器，存储的是字符，长度为8.一个整数最多8个16进制数
        int index = chs.length-1;
        for(int i = 0;i<8;i++) {
            int temp = num & 15;

            if(temp > 9){
                chs[index] = ((char)(temp-10+'A'));
            }else {
                chs[index] = ((char)(temp+'0'));
            }

            index--;
            num = num >>> 4;
        }
        return toString(chs);
    }
    //将数组转为字符串
    public static String toString(char[] arr){
        String temp = "";
        for(int i = 0;i<arr.length;i++){
            temp = temp + arr[i];
        }
        return temp;
    }

}
