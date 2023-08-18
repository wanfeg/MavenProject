package com.example.mavenproject.common;

import lombok.Data;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Ref;

/**
 * @author :Aurora
 * @version:
 * @date : 2023/8/17 11:30
 * @desc:
 */
@Data
public class Reflect {

    private String name;
    public int age;
    private static long id;

    public Reflect(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void say(){
        System.out.println("saysay");
    }

    private void bye(){
        System.out.println("byebye");
    }

    private static void ha(){
        System.out.println("haha");
    }

    static void ha2(){
        System.out.println("haha");
    }


    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        Class<?> clazz = Class.forName("com.example.mavenproject.common.Reflect");
        Field[] fields = clazz.getFields();
        for (Field field : fields) {
            System.out.println("field = " + field);
        }
        Constructor<?> constructor = clazz.getConstructor(String.class,int.class);
        System.out.println("constructors = " + constructor);
        Method say = clazz.getMethod("say");
        Object o = constructor.newInstance("大王",125);
        System.out.println("o = " + o);
        say.invoke(o);

    }

}
