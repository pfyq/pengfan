package com.qp.smark.util;

import com.github.wxpay.sdk.WXPayUtil;
import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class Base64Util {

    //base64字符串转byte[]
    public static byte[] base64String2ByteFun(String base64Str){
        return Base64.decodeBase64(base64Str);
    }
    //byte[]转base64
    public static String byte2Base64StringFun(byte[] b){
        return Base64.encodeBase64String(b);
    }

    private static SecretKeySpec key = null;

    public static void main(String[] args) throws Exception {
        String req_info = "Nr0A1353zORFCVx1OYYkQsUcfW61/Z0Z/U6dvsjUjMPlTFhZuUTIUuXBZ/kFKcqfJZuNANHCZIYZtXLweDOo+" +
                "IQZB/SFVI/893GRtZ3F10nvRNLdEtn+E094dJnyM6hZGd2L9Gi88P4qCyNEwu+" +
                "oGAfJEGLzGTVRBEZaXsHayMwCHhJOJvHW6YHeKnwyEHJwEdePAQK/TsL5qlVI9G/FEzV7vKWMdesGTfGbcjJSDgLlxeP4t5Rlb2PYzNqWmOg+" +
                "e9DnOrZjpwhQSq6oZ3ywvL4USIVk1DtBuV2k4HWfmN9DPMJ01qxgzhGlw4ggfgImwJomfY2L1IavYMo/yuMA8LE8qLSHxUSmYVQ469a3IPvrcg5b4GRY+" +
                "ku+vYn9tUjGmFqNObZJZum8RT1bgd1e3i/LNaKFZ9Yz7x02hu2tAOCJKG0aYfPhw5JfY0jBc76kAS62qeemVmyC/kJsZ9eN6QbSGH+" +
                "5bQ6ugqhNq9Q9DGw031cnQheUjo75I+Yl8X+iPyiPPz/zTibBgeUKnm6rVs9WZfgso7b+" +
                "Q9fgusfoefg11Q32avY4bPQurgnVSYwHuLjI21415fDu7HyaM8yOYZMDzM6XOEqWWcuiYOS2P89pfllyksz6H2JLzQVYmpwY43H6AoAOZhaC/RUdGrcQKBOgThY29XO/pASMrMBZ4sUP85NF4axTtIU19WWrwSdlB/LHg/enqpoPbg9f+" +
                "JSpULAxJ0gaSFJzWuD4bN+ZBJMZ0X2nIWoVOibu4vinwUzTELIHd0Zrf5NS0d28SmZ9M2DIyRSbFqGTkHV4Vg8OY15QcI+kwIWKCzUJCz2rzGQxbhkR/Q+Y9jEi+HcHbLbaYyhWgRSNL9gZJM3Qfhos9ULQw0WC6B9We6NtAWDvT81RqT4JTySs8qn+qHkZP/LdPy3+" +
                "f4wTvWhHduL6WYCNgCFYm2txSCaul4WHuySFLQy+ozEOnpsuGxxq1L9kIEHtiBKYfy7qFbo47fSDGMcCCd6XUCe3ro0ZyvU2lzZWs68bWZQCgbnmoCFPRFLb+wRY5M+XENpsvQpPGV0PAf20IdFX1DNwvXbMP8bVuuMgmmXe";
        byte[] b = Base64Util.base64String2ByteFun(req_info);

        key = new SecretKeySpec(WXPayUtil.MD5("hzyyyxgs330127197006161213186058").toLowerCase().getBytes(), "AES");

        System.out.println(decryptData(b));
    }

    public static String decryptData(byte[] b) throws Exception {
        Cipher cipher = null;
        cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE,key);
        return new String(cipher.doFinal(b),"utf-8");
    }

}
