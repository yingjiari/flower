package com.nf511.flower.controller;

import com.nf511.flower.common.R;
import com.nf511.flower.entity.Cart;
import com.nf511.flower.entity.State;
import com.nf511.flower.service.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(path = "/stateService")
public class StateController {
    @Autowired
    StateService stateService;
    /**
     * 查询全部
     * */
    @RequestMapping(path = "/selectAllState",method = RequestMethod.POST)
    @ResponseBody
    public R selectAllState(){
        return R.ok(stateService.selectAllState());
    }

    /**
     * 根据ID查询
     * */
    @RequestMapping(path = "/selectAllStateId",method = RequestMethod.POST)
    @ResponseBody
    public R selectAllStateId(int stateId){
        return R.ok(stateService.selectAllStateId(stateId));
    }

    /**
     * 添加
     * */
    @RequestMapping(path = "/insertState",method = RequestMethod.POST)
    @ResponseBody
    public R insertState(State state){
        return R.ok(stateService.insertState(state));
    }

    /**
     * 修改
     * */
    @RequestMapping(path = "/updateState",method = RequestMethod.POST)
    @ResponseBody
    public R updateState(State state){
        return R.ok(stateService.updateState(state));
    }

    /**
     * 删除
     * */
    @RequestMapping(path = "/deleteState",method = RequestMethod.POST)
    @ResponseBody
    public R deleteState(int stateId){
        return R.ok(stateService.deleteState(stateId));
    }

    /**
     * 多删除
     * */
    @RequestMapping(path = "/deleteAll",method = RequestMethod.POST)
    @ResponseBody
    public R deleteAll(@RequestBody List<Integer> items){
        return R.ok(stateService.deleteAll(items));
    }
}
