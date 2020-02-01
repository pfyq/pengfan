package com.qp.smark.util;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Arrays;
import java.util.Formatter;

public class Aes128Util {

    // 加密秘钥 ，16个字节也就是128 bit
    public static final byte[] AES_KEY = {0x3A,0x60,0x43,0x2A,0x5C,0x01,0x21,0x1F,0x29,0x1E,0x0F,0x4E,0x0C,0x13,0x28,0x25};


    //06,01,01,01,2c,2c,62,58,26,67,42,66,01,33,31,41,
    public static final byte[] token_command = {0x06,0x01,0x01,0x01,0x2C,0x2C,0x62,0x58,0x26,0x67,0x42,0x66,0x01,0x33,0x31,0x41};

    /*加密*/
    public static byte[] encrypt(byte[] sSrc, byte[] sKey) {
        try{
//            SecretKeySpec key = new SecretKeySpec(AES_KEY.getBytes(), "AES");
            SecretKeySpec skeySpec = new SecretKeySpec(sKey, "AES");
            Cipher cipher = Cipher.getInstance("AES/ECB/NoPadding");
            cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
            byte[] encrypted = cipher.doFinal(sSrc);
            return encrypted;
        }catch(Exception ex){
            return null;
        }
    }

    public static byte[] encrypt2() {
        try{
//            SecretKeySpec key = new SecretKeySpec(AES_KEY.getBytes(), "AES");
            SecretKeySpec skeySpec = new SecretKeySpec(new byte[]{0x3A,0x60,0x43,0x2A,0x5C,0x01,0x21,0x1F,0x29,0x1E,0x0F,0x4E,0x0C,0x13,0x28,0x25}, "AES");
            Cipher cipher = Cipher.getInstance("AES/ECB/NoPadding");
            cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
            byte[] encrypted = cipher.doFinal(new byte[]{0x06,0x01,0x01,0x01,0x2C,0x2C,0x62,0x58,0x26,0x67,0x42,0x66,0x01,0x33,0x31,0x41});
            return encrypted;
        }catch(Exception ex){
            ex.printStackTrace();
            return null;
        }
    }
    /*解密*/
    public static byte[] decrypt(byte[] sSrc, byte[] sKey){
        try{
            SecretKeySpec skeySpec = new SecretKeySpec(sKey, "AES");
            Cipher cipher = Cipher.getInstance("AES/ECB/NoPadding");
            cipher.init(Cipher.DECRYPT_MODE, skeySpec);
            byte[] dncrypted = cipher.doFinal(sSrc);
            return dncrypted;
        }catch(Exception ex){
            return null;
        }
    }

    public static String decryptData(byte[] b,SecretKeySpec key) throws Exception {
        Cipher cipher = null;
        cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE,key);
        return new String(cipher.doFinal(b),"utf-8");
    }



    // Java测试工程入口方法，在这个方法中调用加解密方法并打印结果
    public static void main(String[] args) throws Exception {
//        String a = "0x06,0x01,0x01,0x01,0x2C,0x2C,0x62,0x58,0x26,0x67,0x42,0x66,0x01,0x33,0x31,0x41";
        //0x86 0x50 0x4c 0x15 0x25 0x16 0x59 0x2a 0x5a 0xfe 0x56 0x45 0x75 0x5a 0xf6 0x9e
//        String encryptA = encryptUtil(a);

//        byte[] b = {117, 80, 8, 70};
//        System.out.println(BytetohexString(b));

        String encryptA = "0x05,0x0C,0x01,0x01,,0x12,0x20,0x45,0x32,0x2c,0x55,0xf,0x60,0x35,0x2d,0x14";
        encryptA = encryptA.replace(" ",",");
//        System.out.println(encryptUtil(a));
        System.out.println(decryptUtil(encryptA));

        String decryptStr = "0x05,0x0C,0x01,0x01,0x9c,0x2a,0x9e,0xe9,0x21,0x10,0x2d,0x28,0x3c,0x54,0x63,0x42";
        decryptStr = decryptStr.replace(" ",",");
        System.out.println(encryptUtil(decryptStr));

//        byte[] b = encrypt2();
//        for(byte bb: b){
//            String s = Integer.toHexString(bb);
//            if(s.length()==8){
//                System.out.print("0x"+s.substring(6)+" ");
//            }else if(s.length()==2){
//                System.out.print("0x"+s+" ");
//            }else if(s.length()==1){
//                System.out.print("0x0"+s+" ");
//            }
//        }
    }

    public static String encryptUtil(String value){
        String[] s = value.replace("X", "x").split(",");
        byte[] b = new byte[s.length];
        for(int i = 0;i < s.length;i++){
            String str = s[i];
            b[i] = (byte)Integer.parseInt(str.substring(2),16);
        }
        byte[] encryB = encrypt(b,AES_KEY);
        String strEncryB = Bytetohex.bytetohexString(encryB).toLowerCase();
        return  strEncryB;
    }

    public static String decryptUtil(String value){
        String[] s = value.replace("X", "x").split(",");
        byte[] b = new byte[s.length];
        for(int i = 0;i < s.length;i++){
            b[i] = (byte)Integer.parseInt(s[i].substring(2),16);
        }
        byte[] decryptB = decrypt(b,AES_KEY);
        String strDecryptB = Bytetohex.bytetohexString(decryptB).toLowerCase();
        return  strDecryptB;
    }

    public static Object serializeObjUtil(String value){
        String[] s = value.replace("X", "x").split(" ");
        byte[] b = new byte[s.length];
        for(int i = 0;i < s.length;i++){
            b[i] = (byte)Integer.parseInt(s[i].substring(2),16);
        }
        Object serializeObj = Bytetohex.unSerializeObjOrString(b);
        return serializeObj;
    }

    public static String  getToken(String encrypt_token){
        String decrypt_token = Aes128Util.decryptUtil(encrypt_token);
//        String str = Bytetohex.bytetohexString(Aes128Util.encrypt(Aes128Util.token_command,Aes128Util.AES_KEY));
        String str = decrypt_token;
        String[] strs =  str.split(",");
        String tk = strs[3]+","+strs[4]+","+strs[5]+","+strs[6];
        System.out.println(str);
        return tk;
    }


}
