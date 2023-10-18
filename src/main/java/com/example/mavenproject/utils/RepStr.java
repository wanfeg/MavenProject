package com.example.mavenproject.utils;

/**
 * @author :Aurora
 * @version:
 * @date : 2023/9/18 15:27
 * @desc:
 */
public class RepStr {
    public static void main(String[] args) {
        ha("aaa","bbb","ccc");
        String[] arr = {"hello","你好","繁體"};
        String[] arr2 = new String[]{"dd","cc"} ;
        System.out.println("ha(arr) = " + ha(arr));
        System.out.println("ha(arr2) = " + ha(arr2));
        System.out.println("ha()666 = " + ha());
    }

    public static String ha(String... strings){
        for (int i = 0; i < strings.length; i++) {
            System.out.println("i = " + i);
        }
        return "success!";
    }
}
