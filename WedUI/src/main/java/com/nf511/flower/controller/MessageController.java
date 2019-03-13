package com.nf511.flower.controller;

import com.nf511.flower.common.R;
import com.nf511.flower.entity.Message;
import com.nf511.flower.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/Message")
public class MessageController {

    @Autowired
    MessageService messageService;

    /**
     * 查询所有用户发给客服的未读信息
     * */
    @RequestMapping(path = "/selectAllMessage")
    @ResponseBody
    public R selectAllMessage(Message message){
        return R.ok(messageService.selectAllMessage(message));
    }
    /**
     * 查询所有用户发给客服的未读信息个数
     * */
    @RequestMapping(path = "/MessageCount")
    @ResponseBody
    public R MessageCount(Message message){
        return R.ok(messageService.MessageCount(message));
    }

    /**
     * 添加
     * */
    @RequestMapping(path = "/insertMessage")
    @ResponseBody
    public R insertMessage(Message message){
        return R.ok(messageService.insertMessage(message));
    }

    /**
     * 判断有没有改数据
     * */
    @RequestMapping(path = "/selectMessage")
    @ResponseBody
    public R selectMessage(Message message){
        return R.ok(messageService.selectMessage(message));
    }



}
