package com.nf511.flower.controller;

import com.nf511.flower.common.R;
import com.nf511.flower.entity.Flowertype;
import com.nf511.flower.entity.Floweruse;
import com.nf511.flower.service.FloweruseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/Floweruse")
public class FloweruseController {

    @Autowired
    FloweruseService floweruseService;

    @RequestMapping("/getAllFloweruse")
    @ResponseBody
    public R getAllFloweruse(){
        return R.ok(floweruseService.getAllFloweruse());
    }

    /**
     * 根据ID查询
     * */
    @RequestMapping(path = "/selectAllFloweruseId",method = RequestMethod.POST)
    @ResponseBody
    public R selectAllFloweruseId(int flowerUseId){
        return R.ok(floweruseService.selectAllFloweruseId(flowerUseId));
    }

    /**
     * 添加
     * */
    @RequestMapping(path = "/insertFloweruse",method = RequestMethod.POST)
    @ResponseBody
    public R insertFloweruse(Floweruse floweruse){
        return R.ok(floweruseService.insertFloweruse(floweruse));
    }

    /**
     * 修改
     * */
    @RequestMapping(path = "/updateFlowerBranchNumber",method = RequestMethod.POST)
    @ResponseBody
    public R updateFloweruse(Floweruse floweruse){
        return R.ok(floweruseService.updateFloweruse(floweruse));
    }

    /**
     * 删除
     * */
    @RequestMapping(path = "/deleteFloweruse",method = RequestMethod.POST)
    @ResponseBody
    public R deleteFloweruse(int flowerUseId){
        return R.ok(floweruseService.deleteFloweruse(flowerUseId));
    }

    /**
     * 多删除
     * */
    @RequestMapping(path = "/deleteAll",method = RequestMethod.POST)
    @ResponseBody
    public R deleteAll(@RequestBody List<Integer> items){
        return R.ok(floweruseService.deleteAll(items));
    }

}
