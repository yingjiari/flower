package com.nf511.flower.controller;

import com.nf511.flower.common.R;
import com.nf511.flower.entity.Messagecontent;
import com.nf511.flower.service.MessagecontentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/MessageContent")
public class MessagecontentController {

    @Autowired
    MessagecontentService messagecontentService;

    /**
     * 根据用户编号查询用户和客服之间的消息信息
     * */
    @RequestMapping(path = "/selectAllMessageContentByUserId")
    @ResponseBody
    public R selectAllMessageContentByUserId(int userId){
        return R.ok(messagecontentService.selectAllMessageContentByUserId(userId));
    }

    /**
     * 添加
     * */
    @RequestMapping(path = "/insertMessagecontent")
    @ResponseBody
    public R insertMessagecontent(Messagecontent messagecontent){
        return R.ok(messagecontentService.insertMessagecontent(messagecontent));
    }

    /**
     * 修改
     * */
    @RequestMapping(path = "/updateMessagecontent")
    @ResponseBody
    public R updateMessagecontent(Messagecontent messagecontent){
        return R.ok(messagecontentService.updateMessagecontent(messagecontent));
    }

}
