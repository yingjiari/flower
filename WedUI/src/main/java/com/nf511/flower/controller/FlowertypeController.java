package com.nf511.flower.controller;

import com.nf511.flower.common.R;
import com.nf511.flower.entity.Flowerbranchnumber;
import com.nf511.flower.entity.Flowertype;
import com.nf511.flower.service.FlowertypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/Flowertype")
public class FlowertypeController {

    @Autowired
    FlowertypeService flowertypeService;

    @RequestMapping("/getAllFlowertype")
    @ResponseBody
    public R getAllFlowertype(){
        return R.ok(flowertypeService.getAllFlowertype());
    }


    /**
     * 根据ID查询
     * */
    @RequestMapping(path = "/selectAllFlowertypeId",method = RequestMethod.POST)
    @ResponseBody
    public R selectAllFlowertypeId(int flowerTypeId){
        return R.ok(flowertypeService.selectAllFlowertypeId(flowerTypeId));
    }

    /**
     * 添加
     * */
    @RequestMapping(path = "/insertFlowertype",method = RequestMethod.POST)
    @ResponseBody
    public R insertFlowertype(Flowertype flowertype){
        return R.ok(flowertypeService.insertFlowertype(flowertype));
    }

    /**
     * 修改
     * */
    @RequestMapping(path = "/updateFlowerBranchNumber",method = RequestMethod.POST)
    @ResponseBody
    public R updateFlowertype(Flowertype flowertype){
        return R.ok(flowertypeService.updateFlowertype(flowertype));
    }

    /**
     * 删除
     * */
    @RequestMapping(path = "/deleteFlowertype",method = RequestMethod.POST)
    @ResponseBody
    public R deleteFlowertype(int flowerTypeId){
        return R.ok(flowertypeService.deleteFlowertype(flowerTypeId));
    }

    /**
     * 多删除
     * */
    @RequestMapping(path = "/deleteAll",method = RequestMethod.POST)
    @ResponseBody
    public R deleteAll(@RequestBody List<Integer> items){
        return R.ok(flowertypeService.deleteAll(items));
    }
}
