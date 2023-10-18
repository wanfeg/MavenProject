package com.example.mavenproject.common.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author :Aurora
 * @version:
 * @date : 2023/9/13 10:29
 * @desc:
 */
public class StreamTest {
    static List<String> list = new ArrayList<>();

    static {
        for (int i = 0; i < 100; i++) {
            list.add("a" + i);
        }
    }

    public static void main(String[] args) {

        System.out.println("list.size() = " + list.size());
        for (String arg : list) {
            System.out.println("arg = " + arg);
        }
        Stream<String> stream = list.stream().filter(s -> s.startsWith("a"));
        System.out.println("stream = " + stream.collect(Collectors.toList()));
    }
}
