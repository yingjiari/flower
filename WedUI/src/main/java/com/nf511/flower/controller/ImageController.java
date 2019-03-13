package com.nf511.flower.controller;

import com.nf511.flower.common.R;
import com.nf511.flower.entity.Cart;
import com.nf511.flower.entity.Image;
import com.nf511.flower.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(path = "/imageService")
public class ImageController {
    @Autowired
    ImageService imageService;
    /**
     * 查询全部
     * */
    @RequestMapping(path = "/selectAllImage",method = RequestMethod.POST)
    @ResponseBody
    public R selectAllImage(){
        return R.ok(imageService.selectAllImage());
    }

    /**
     * 根据ID查询
     * */
    @RequestMapping(path = "/selectAllFlowerId",method = RequestMethod.POST)
    @ResponseBody
    public R selectAllFlowerId(int flowerId){
        return R.ok(imageService.selectAllFlowerId(flowerId));
    }

    /**
     * 添加
     * */
    @RequestMapping(path = "/insertImage",method = RequestMethod.POST)
    @ResponseBody
    public R insertImage(Image image){
        return R.ok(imageService.insertImage(image));
    }

    /**
     * 修改
     * */
    @RequestMapping(path = "/updateImage",method = RequestMethod.POST)
    @ResponseBody
    public R updateImage(Image image){
        return R.ok(imageService.updateImage(image));
    }

    /**
     * 删除
     * */
    @RequestMapping(path = "/deleteImage",method = RequestMethod.POST)
    @ResponseBody
    public R deleteImage(int imageId){
        return R.ok(imageService.deleteImage(imageId));
    }

    /**
     * 多删除
     * */
    @RequestMapping(path = "/deleteAll",method = RequestMethod.POST)
    @ResponseBody
    public R deleteAll(@RequestBody List<Integer> items){
        return R.ok(imageService.deleteAll(items));
    }
}
