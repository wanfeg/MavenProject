package com.example.mavenproject.common.dataNotSensitive;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
public class TestController2 {

    @RequestMapping("/test")
    public TestPojo testDesensitization(){
        TestPojo testPojo = new TestPojo();
        testPojo.setUserName("我是用户名");
        testPojo.setAddress("地球中国-北京市通州区京东总部2号楼");
        testPojo.setPhone("13782946666");
        testPojo.setPassword("sunyangwei123123123.");
        System.out.println(testPojo);
        return testPojo;
    }

}
