package com.nf511.flower.controller;

import com.nf511.flower.common.R;
import com.nf511.flower.entity.Flowerbranchnumber;
import com.nf511.flower.service.FlowerbranchnumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/Flowerbranchnumber")
public class FlowerbranchnumberController {

    @Autowired
    FlowerbranchnumberService flowerbranchnumberService;

    @RequestMapping("/getAllFlowerbranchnumber")
    @ResponseBody
    public R getAllFlowerbranchnumber(){
        return R.ok(flowerbranchnumberService.getAllFlowerbranchnumber());
    }

    /**
     * 根据ID查询
     * */
    @RequestMapping(path = "/selectAllFlowerBranchNumberId",method = RequestMethod.POST)
    @ResponseBody
    public R selectAllFlowerBranchNumberId(int flowerBranchNumberId){
        return R.ok(flowerbranchnumberService.selectAllFlowerBranchNumberId(flowerBranchNumberId));
    }

    /**
     * 添加
     * */
    @RequestMapping(path = "/insertFlowerBranchNumber",method = RequestMethod.POST)
    @ResponseBody
    public R insertFlowerBranchNumber(Flowerbranchnumber flowerbranchnumber){
        return R.ok(flowerbranchnumberService.insertFlowerBranchNumber(flowerbranchnumber));
    }

    /**
     * 修改
     * */
    @RequestMapping(path = "/updateFlowerBranchNumber",method = RequestMethod.POST)
    @ResponseBody
    public R updateFlowerBranchNumber(Flowerbranchnumber flowerbranchnumber){
        return R.ok(flowerbranchnumberService.updateFlowerBranchNumber(flowerbranchnumber));
    }

    /**
     * 删除
     * */
    @RequestMapping(path = "/deleteFlowerBranchNumber",method = RequestMethod.POST)
    @ResponseBody
    public R deleteFlowerBranchNumber(int flowerBranchNumberId){
        return R.ok(flowerbranchnumberService.deleteFlowerBranchNumber(flowerBranchNumberId));
    }

    /**
     * 多删除
     * */
    @RequestMapping(path = "/deleteAll",method = RequestMethod.POST)
    @ResponseBody
    public R deleteAll(@RequestBody List<Integer> items){
        return R.ok(flowerbranchnumberService.deleteAll(items));
    }





}
