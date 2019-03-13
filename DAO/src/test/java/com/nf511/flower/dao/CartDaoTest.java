package com.nf511.flower.dao;

import com.nf511.flower.entity.Cart;
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
public class CartDaoTest {

    @Autowired
    CartDao cartDao;

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void selectAllCart() {
        System.out.println(cartDao.selectAllCart(100000000));
    }

    @Test
    public void selectCartByUserIdAndFlowerId() {
        System.out.println(cartDao.selectCartByUserIdAndFlowerId(100000017,60));
    }

    @Test
    public void insertCart() {
        Cart cart=new Cart();
        cart.setFlowerId(3);
        cart.setUserId(100000000);
        cart.setCartAmount(1);
        Assert.assertEquals(1, cartDao.insertCart(cart));
        System.out.println(cart.getCartId());

    }

    @Test
    public void updateCartAmount(){

        System.out.println(cartDao.updateCartAmount(103,2));
    }
}