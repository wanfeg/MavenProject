package com.example.mavenproject.common;

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

    public static void main(String[] args) {
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
    }

    public void ac(){
        C c = new A().new C();
        System.out.println(c);
    }

}
