package com.example.mavenproject.service;

import com.example.mavenproject.mapper.MessageRecordDao;
import com.example.mavenproject.pojo.MessageRecord;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author :Aurora
 * @version:
 * @date : 2023/9/18 16:16
 * @desc:
 */
@SpringBootTest
class MessageRecordServiceTest {

    @Autowired
    private MessageRecordDao messageRecordDao;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void queryById() {
//        MessageRecord messageRecord = messageRecordService.queryById(1);
//        System.out.println("messageRecord = " + messageRecord);
        MessageRecord messageRecord = messageRecordDao.queryById(1);
        System.out.println("messageRecord = " + messageRecord);
    }
}