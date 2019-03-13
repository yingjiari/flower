package com.nf511.flower.dao;

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
public class AddressDaoTest {

    @Autowired
    AddressDao addressDao;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void selectAllAddress() {
        System.out.println(addressDao.selectAllAddress(100000000));
    }

    @Test
    public void getAddressCount() {
        System.out.println(addressDao.getAddressCount(100000000));
    }

    @Test
    public void updateAddressStateId() {
        System.out.println(addressDao.updateAddressStateId(3,11));
    }

    @Test
    public void getAddressByMaxAddressId() {
        System.out.println(addressDao.getAddressByMaxAddressId(100000000));
    }

}