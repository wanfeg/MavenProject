package com.example.mavenproject.common;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/**
 * @author :Aurora
 * @version:
 * @date : 2023/9/6 10:53
 * @desc:
 */
public class ByteString {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String gbkStr = "你好，世界！";
        byte[] utf8Bytes = gbkStr.getBytes(StandardCharsets.UTF_8);
        System.out.println(Arrays.toString(utf8Bytes));
        byte[] gbkBytes = gbkStr.getBytes("GBK");
        String s1 = bytesToBinary(gbkBytes);
        String s2 = bytesToHex(gbkBytes);
        String s3 = bytesToBinary(utf8Bytes);
        String s4 = bytesToHex(utf8Bytes);
        System.out.println("s1.length() = " + s1.length() + "，s1 = " + s1);
        System.out.println("s2.length() = " + s2.length() + "，s2 = " + s2);
        System.out.println("s3.length() = " + s3.length() + "，s3 = " + s3);
        System.out.println("s4.length() = " + s4.length() + "，s4 = " + s4);
        System.out.println("*****************************************************");
        byte[] bytes = binaryStringToBytes(s3);
        System.out.println("Arrays.toString(bytes) = " + Arrays.toString(bytes));
        String s = new String(bytes, "GBk");
        System.out.println("s = " + s);
    }

    // byte数组转换成2进制字符串
    public static String bytesToBinary(byte[] bytes) {
        StringBuilder binaryString = new StringBuilder();
        for (byte b : bytes) {
            for (int i = 7; i >= 0; i--) {
                binaryString.append((b >> i) & 1);
            }
        }
        return binaryString.toString();
    }

    // byte数组转换成16进制字符串
    public static String bytesToHex(byte[] bytes) {
        StringBuilder hexString = new StringBuilder();
        for (byte b : bytes) {
            String hex = Integer.toHexString(b & 0xFF);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }

    public static byte[] binaryStringToBytes(String binaryString) {
        int length = binaryString.length();
        if (length % 8 != 0) {
            throw new IllegalArgumentException("Invalid binary string length");
        }
        byte[] bytes = new byte[length / 8];
        for (int i = 0; i < length; i += 8) {
            String byteString = binaryString.substring(i, i + 8);
            byte b = (byte) Integer.parseInt(byteString, 2);
            bytes[i / 8] = b;
        }
        return bytes;
    }


}
