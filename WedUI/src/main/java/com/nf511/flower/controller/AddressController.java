package com.nf511.flower.controller;

import com.nf511.flower.common.R;
import com.nf511.flower.entity.Address;
import com.nf511.flower.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(path = "/address")
public class AddressController {
    @Autowired
    AddressService addressService;

    /**
     * 查询全部
     * */
    @RequestMapping(path = "/selectAllAddress",method = RequestMethod.POST)
    @ResponseBody
    public R selectAllAddress(int userId){
        return R.ok(addressService.selectAllAddress(userId));
    }

    /**
     * 根据用户名查询地址个数
     * */
    @RequestMapping(path = "/getAddressCount",method = RequestMethod.POST)
    @ResponseBody
    public R getAddressCount(int userId){
        return R.ok(addressService.getAddressCount(userId));
    }

    /**
     * 添加
     * */
    @RequestMapping(path = "/insertAddress",method = RequestMethod.POST)
    @ResponseBody
    public R insertAddress(Address address){
        return R.ok(addressService.insertAddress(address));
    }

    /**
     * 修改地址默认状态
     * */
    @RequestMapping(path = "/updateAddressStateId",method = RequestMethod.POST)
    @ResponseBody
    public R updateAddressStateId(int addressId,int stateId){
        return R.ok(addressService.updateAddressStateId(addressId,stateId));
    }

    /**
     * 查询添加的地址编号
     * */
    @RequestMapping(path = "/getAddressByMaxAddressId")
    @ResponseBody
    public R getAddressByMaxAddressId(int userId){
        return R.ok(addressService.getAddressByMaxAddressId(userId));
    }




    /**
     * 根据ID查询
     * */
    @RequestMapping(path = "/selectAddressId",method = RequestMethod.POST)
    @ResponseBody
    public R selectAddressId(int addressId){
        return R.ok(addressService.selectAddressId(addressId));
    }



    /**
     * 修改
     * */
    @RequestMapping(path = "/updateAddress",method = RequestMethod.POST)
    @ResponseBody
    public R updateAddress(Address address){
        return R.ok(addressService.updateAddress(address));
    }

    /**
     * 删除
     * */
    @RequestMapping(path = "/deleteAddress",method = RequestMethod.POST)
    @ResponseBody
    public R deleteAddress(int addressId){
        return R.ok(addressService.deleteAddress(addressId));
    }

    /**
     * 多删除
     * */
    @RequestMapping(path = "/deleteAll",method = RequestMethod.POST)
    @ResponseBody
    public R deleteAll(@RequestBody List<Integer> items){
        return R.ok(addressService.deleteAll(items));
    }



}
