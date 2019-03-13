package com.nf511.flower.dao;

import com.nf511.flower.entity.Message;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

//指定bean注入的配置文件
@ContextConfiguration(locations = { "classpath:applicationContext.xml"})
//使用标准的JUnit @RunWith注释来告诉JUnit使用Spring TestRunner
@RunWith(SpringJUnit4ClassRunner.class)
public class MessageDaoTest {

    @Autowired
    MessageDao messageDao;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void selectAllMessage() {
        Message message=new Message();
        System.out.println(messageDao.selectAllMessage(message));
    }

    @Test
    public void MessageCount() {
        Message message=new Message();
        System.out.println(messageDao.MessageCount(message));
    }

    @Test
    public void insertMessage() {
        Message message=new Message();
        message.setSenderId(100000006);
        message.setRecipientId(999999);
        System.out.println(messageDao.insertMessage(message));
    }

    @Test
    public void selectMessage() {
        Message message=new Message();
        message.setSenderId(999999);
        message.setRecipientId(100000031);
        System.out.println(messageDao.selectMessage(message));
    }

}