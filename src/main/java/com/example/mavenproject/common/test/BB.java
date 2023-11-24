package com.example.mavenproject.common.test;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author :Aurora
 * @version:
 * @date : 2023/10/24 15:23
 * @desc:
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class BB extends AA{
    private String address = "BB Address!";

    public BB(String address) {
        this.address = address;
    }

    public BB() {
        super();
    }

    public BB(String name, String address) {
        super(name);
        this.address = address;
    }

    public static void main(String[] args) {
        BB bb = new BB("haha");
        BB bb1 = new BB("BB name!", "");
        System.out.println("bb = " + bb);
        System.out.println("bb1 = " + bb1);
        System.out.println("bb.getName() = " + bb.getName());
        System.out.println("bb1.getName() = " + bb1.getName());
        ArrayList<String> list = new ArrayList<>();
        list.add("bb");
        list.add("aa");
        list.add("a2");
        list.add("a3");
        list.add("a4");
        list.add("a12");
        List<String> collect = list.stream().sorted().collect(Collectors.toList());
        for (String s : collect) {
            System.out.println("s = " + s);
        }

    }

}
