package com.nf511.flower.controller;

import com.nf511.flower.common.R;
import com.nf511.flower.entity.Admin;
import com.nf511.flower.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(path = "/admin")
public class AdminController {

    @Autowired
    AdminService adminService;


    /**
     * 根据ID查询
     * */
    @RequestMapping(path = "/selectAdmin")
    @ResponseBody
    public R selectAdmin(String adminAccount){
        return R.ok(adminService.selectAdmin(adminAccount));
    }




    /**
     * 查询全部
     * */
    @RequestMapping(path = "/selectAllAdmin",method = RequestMethod.POST)
    @ResponseBody
    public R selectAllAdmin(){
        return R.ok(adminService.selectAllAdmin());
    }

    /**
     * 根据ID查询
     * */
    @RequestMapping(path = "/selectAllAdminId",method = RequestMethod.POST)
    @ResponseBody
    public R selectAllAdminId(int adminId){
        return R.ok(adminService.selectAllAdminId(adminId));
    }

    /**
     * 添加
     * */
    @RequestMapping(path = "/insertAdmin",method = RequestMethod.POST)
    @ResponseBody
    public R insertAdmin(Admin admin){
        return R.ok(adminService.insertAdmin(admin));
    }

    /**
     * 修改
     * */
    @RequestMapping(path = "/updateAdmin",method = RequestMethod.POST)
    @ResponseBody
    public R updateAdmin(Admin admin){
        return R.ok(adminService.updateAdmin(admin));
    }

    /**
     * 删除
     * */
    @RequestMapping(path = "/deleteAdmin",method = RequestMethod.POST)
    @ResponseBody
    public R deleteAdmin(int adminId){
        return R.ok(adminService.deleteAdmin(adminId));
    }

    /**
     * 多删除
     * */
    @RequestMapping(path = "/deleteAll",method = RequestMethod.POST)
    @ResponseBody
    public R deleteAll(@RequestBody List<Integer> items){
        return R.ok(adminService.deleteAll(items));
    }

}
