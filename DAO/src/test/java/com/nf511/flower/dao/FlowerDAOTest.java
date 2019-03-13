package com.nf511.flower.dao;

import com.nf511.flower.entity.Flower;
import com.nf511.flower.entity.Flowerbranchnumber;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

//指定bean注入的配置文件
@ContextConfiguration(locations = { "classpath:applicationContext.xml"})
//使用标准的JUnit @RunWith注释来告诉JUnit使用Spring TestRunner
@RunWith(SpringJUnit4ClassRunner.class)
public class FlowerDAOTest {

    @Autowired
    FlowerDAO flowerDAO;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getFlower() {
        Flower flower=new Flower();
        flower.setSkip(0);
        flower.setSize(1);
        flower.setFlowerId(35);
//        flower.setFlowerUseName("爱情鲜花");
//        flower.setFlowerTypeName("花束");
//        flower.setFlowerBranchNumber("99");
//        flower.setFlowerMaterials("红");
        System.out.println(flowerDAO.getFlower(flower));
    }

    @Test
    public void getFlowerCount() {
        Flower flower=new Flower();
        System.out.println(flowerDAO.getFlowerCount(flower));
    }
//    '1', '1', '15', '599.00', '520.00','520', '9012177.jpg',
//   '不变的承诺--99枝红玫瑰', '99枝红玫瑰','黑色雪梨纸，黑色条纹纸，玻璃纸卷，酒红色缎带花结',
// '下雨的时候，给她撑一把雨伞；寒冷的时候，给她一个温暖的臂弯；天黑了，永远有一盏灯为她点亮；晨起时，给她一缕温暖的阳光。爱她，就送她一束99枝的玫瑰花！',
// '经典99枝，鼎力推荐！');

    @Test
    public void insertFlower() {
        Flower flower=new Flower();
        flower.setFlowerTypeId(1);
        flower.setFlowerUseId(1);
        flower.setFlowerBranchNumberId(15);
        flower.setFlowerMarketPrice(599);
        flower.setFlowerPrice(520);
        flower.setFlowerInventory(520);
        flower.setFlowerImageName("9012177.jpg");
        flower.setFlowerName("不变的承诺--99枝红玫瑰");
        flower.setFlowerMaterials("99枝红玫瑰");
        flower.setFlowerPackaging("黑色雪梨纸，黑色条纹纸，玻璃纸卷，酒红色缎带花结");
        flower.setFlowerLanguage("下雨的时候，给她撑一把雨伞；寒冷的时候，给她一个温暖的臂弯；天黑了，永远有一盏灯为她点亮；晨起时，给她一缕温暖的阳光。爱她，就送她一束99枝的玫瑰花！");
        flower.setFlowerIntroduce("经典99枝，鼎力推荐！");
        Assert.assertEquals(1, flowerDAO.insertFlower(flower));
        flower.getFlowerId();
    }

    @Test
    public void UpdateFlowerStateId() {
        System.out.println(flowerDAO.UpdateFlowerStateId(35,2));
    }

    @Test
    public void MoreUpdateFlowerStateId() {
        List list=new ArrayList();
        list.add(39);
        list.add(40);
        System.out.println(flowerDAO.MoreUpdateFlowerStateId(list,2));
    }

    @Test
    public void UpdateFlowerInventory() {
        System.out.println(flowerDAO.UpdateFlowerInventory(35,2));
    }

    @Test
    public void DeleteFlower() {
        System.out.println(flowerDAO.DeleteFlower(36));
    }

    @Test
    public void MoreDeleteFlower() {
        List list=new ArrayList();
        list.add(37);
        list.add(38);
        System.out.println(flowerDAO.MoreDeleteFlower(list));
    }



}