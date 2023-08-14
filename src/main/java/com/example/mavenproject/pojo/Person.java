package com.example.mavenproject.pojo;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Person {

    public String name;
    public int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person(){
    }

    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();
        Person person = new Person("Alice", 30);

        try {
            String jsonString = objectMapper.writeValueAsString(person);
            System.out.println(jsonString); // 输出：{"name":"Alice","age":30}
        } catch (Exception e) {
            e.printStackTrace();
        }

        String jsonString = "{\"name\":\"Alice2\",\"age\":31}";
        try {
            Person person2 = objectMapper.readValue(jsonString, Person.class);
            System.out.println("Name: " + person2.name + ", Age: " + person2.age); // 输出：Name: Alice, Age: 30
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
