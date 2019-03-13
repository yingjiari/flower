package com.nf511.flower.controller;

import com.nf511.flower.common.R;
import com.nf511.flower.common.phoneVerCode.SendMessage;
import com.nf511.flower.common.token.JwtUtils;
import com.nf511.flower.entity.Cart;
import com.nf511.flower.entity.User;
import com.nf511.flower.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping(path = "/user")
public class UserController {
    @Autowired
    UserService userService;

    /**
     * 查询全部用户
     * */
    @RequestMapping(path = "/selectAllUser")
    @ResponseBody
    public R selectAllUser(User user) {
        return R.ok(userService.selectAllUser(user));
    }

    /**
     * 查询全部用户数量
     * */
    @RequestMapping(path = "/getUserCount")
    @ResponseBody
    public R getUserCount(User user) {
        return R.ok(userService.getUserCount(user));
    }

    /**
     * 根据手机号或邮箱查询
     * */
    @RequestMapping("/selectByUserPhoneAndMailbox")
    @ResponseBody
    public R selectByUserPhoneAndMailbox(String userPhoneAndMailbox){
        return R.ok(userService.selectByUserPhoneAndMailbox(userPhoneAndMailbox));
    }


    /**
     * app专用登录
     * */
    @RequestMapping("/appLogin")
    @ResponseBody
    public R appLogin(String userPhoneAndMailbox){
        String token=JwtUtils.encode(userPhoneAndMailbox,10000);
        Map map=new HashMap();
        map.put("token",token);
        map.put("userInfoList",userService.selectByUserPhoneAndMailbox(userPhoneAndMailbox));
        return R.ok(map);
    }
    /**
     * 批量启用
     * */
    @RequestMapping("/MoreUpdateUserStateIdStart")
    @ResponseBody
    public R MoreUpdateUserStateIdStart(@RequestBody List<Integer> userIds){
        return R.ok(userService.MoreUpdateUserStateId(userIds,9));
    }
    /**
     * 批量停用
     * */
    @RequestMapping("/MoreUpdateUserStateIdStop")
    @ResponseBody
    public R MoreUpdateUserStateIdStop(@RequestBody List<Integer> userIds){
        return R.ok(userService.MoreUpdateUserStateId(userIds,10));
    }

    /**
     * 修改状态
     * */
    @RequestMapping("/UpdateUserStateId")
    @ResponseBody
    public R UpdateUserStateId(int userId,int userStateId){
        return R.ok(userService.UpdateUserStateId(userId,userStateId));
    }

    /**
     * 修改密码
     * */
    @RequestMapping("/UpdateUserPassword")
    @ResponseBody
    public R UpdateUserPassword(int userId,String userPassword){
        return R.ok(userService.UpdateUserPassword(userId,userPassword));
    }

    /**
     * 修改邮箱
     * */
    @RequestMapping("/UpdateUserMailbox")
    @ResponseBody
    public R UpdateUserMailbox(int userId,String userMailbox){
        return R.ok(userService.UpdateUserMailbox(userId,userMailbox));
    }

    /**
     * 添加
     * */
    @RequestMapping(path = "/insertUser",method = RequestMethod.POST)
    @ResponseBody
    public R insertUser(User user){
        return R.ok(userService.insertUser(user));
    }

    /**
     * 修改
     * */
    @RequestMapping(path = "/updateUser",method = RequestMethod.POST)
    @ResponseBody
    public R updateUser(User user){
        return R.ok(userService.updateUser(user));
    }

    /**
     * 删除
     * */
    @RequestMapping(path = "/deleteUser",method = RequestMethod.POST)
    @ResponseBody
    public R deleteUser(int userId){
        return R.ok(userService.deleteUser(userId));
    }

    /**
     * 多删除
     * */
    @RequestMapping(path = "/deleteAll",method = RequestMethod.POST)
    @ResponseBody
    public R deleteAll(@RequestBody List<Integer> userIds){
        return R.ok(userService.deleteAll(userIds));
    }

    /**
     * 发送验证码
     * */
    @RequestMapping("/SendVerificationCode")
    @ResponseBody
    public void SendVerificationCode(String phone,String code){
        System.out.println(phone);
        System.out.println(code);
        SendMessage sendMessage=new SendMessage();
        sendMessage.EX(phone,code);
    }

}