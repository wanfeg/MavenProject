package com.example.mavenproject.common;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

/**
 * @author :Aurora
 * @version:
 * @date : 2023/8/22 10:18
 * @desc:
 */
public class A {

    private String aa = "master";
    private int ab = 11;

    private static class B{
        private String ba = "slaver";
        private int bb = 12;

        @Override
        public String toString() {
            return "B{" +
                    "ba='" + ba + '\'' +
                    ", bb=" + bb +
                    '}';
        }

    }


    public class C{
        private String ca = "slaver2";
        private int cb = 13;
    }

    public static void main(String[] args) throws UnsupportedEncodingException {
        B b1 = new A.B();
        B b = new B();
        System.out.println(b);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("i like you ");
        System.out.println(stringBuffer);
        stringBuffer.append("no i hate you !");
        System.out.println(stringBuffer);
        System.out.println(stringBuffer.length());
        System.out.println(System.currentTimeMillis());
        String s1 = "中文黑";
        byte[] bytes = s1.getBytes(StandardCharsets.UTF_8);
        String gb2312 = new String(bytes, "gb2312");
        //String s2 = new String(gb2312.getBytes("GB2312"), "gbk");
        System.out.println("gb2312 = " + gb2312);
        //System.out.println("s2 = " + s2);
    }

    public void ac(){
        C c = new A().new C();
        System.out.println(c);
    }

}
