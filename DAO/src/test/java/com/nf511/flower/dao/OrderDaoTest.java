package com.nf511.flower.dao;

import com.nf511.flower.entity.Order;
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
public class  OrderDaoTest {

    @Autowired
    OrderDao orderDao;

    @Test
    public void insertOrder() {
    }

    @Test
    public void selectAllOrderId() {

        System.out.println(orderDao.selectAllOrderId(1));
    }

    @Test
    public void selectAllOrder() {
        Order order=new Order();
//        order.setUserId(100000000);
        order.setOrderState(8);
        System.out.println(orderDao.selectAllOrder(order));

    }

    @Test
    public void getOrderCount() {
        Order order=new Order();
//        order.setUserId(100000000);
//        order.setOrderState(8);
        System.out.println(orderDao.getOrderCount(order));

    }

    @Test
    public void UpdateOrderState() {
        System.out.println(orderDao.UpdateOrderState(1902170001,4));

    }
}