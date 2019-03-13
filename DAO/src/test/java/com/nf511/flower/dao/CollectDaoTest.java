package com.nf511.flower.dao;

import com.nf511.flower.entity.Collect;
import org.junit.After;
import org.junit.Assert;
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
public class CollectDaoTest {

    @Autowired
    CollectDao collectDao;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void selectAllCollect() {
        System.out.println(collectDao.selectAllCollect(100000000));
    }

    @Test
    public void insertCollect() {
        Collect collect=new Collect();
        collect.setFlowerId(3);
        collect.setUserId(100000000);
        Assert.assertEquals(1, collectDao.insertCollect(collect));
    }

    @Test
    public void selectCollectOne() {
        System.out.println(collectDao.selectCollectOne(100000000,2));
    }

    @Test
    public void deleteCollect() {
        System.out.println(collectDao.deleteCollect(2));
    }

    @Test
    public void selectCollectId() {
        System.out.println(collectDao.selectCollectId(100000000,43));
    }

    @Test
    public void CollectCount() {

        for (int i=1;i<=12;i++){
            Collect collect=new Collect();
            if (i<10){
                collect.setCollectDateTime("2019-0"+i);
            }else {
                collect.setCollectDateTime("2019-"+i);
            }
            System.out.println("2019-"+i);
            System.out.println( collectDao.collectCount(collect));
        }

    }

}