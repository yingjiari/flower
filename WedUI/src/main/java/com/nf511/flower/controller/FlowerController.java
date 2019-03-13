package com.nf511.flower.controller;

import com.nf511.flower.common.R;
import com.nf511.flower.entity.Flower;
import com.nf511.flower.service.FlowerService;
import com.nf511.flower.service.FlowertypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/Flower")
public class FlowerController {

    @Autowired
    FlowerService flowerService;

    @RequestMapping("/getFlower")
    @ResponseBody
    public R getFlower(Flower flower){
        return R.ok(flowerService.getFlower(flower));
    }

    @RequestMapping("/getFlowerCount")
    @ResponseBody
    public R getFlowerCount(Flower flower){
        return R.ok(flowerService.getFlowerCount(flower));
    }

    @RequestMapping("/insertFlower")
    @ResponseBody
    public R insertFlower(Flower flower){
        return R.ok(flowerService.insertFlower(flower));
    }

    @RequestMapping("/UpdateFlowerStateId")
    @ResponseBody
    public R UpdateFlowerStateId(int flowerId, int stateId){
        return R.ok(flowerService.UpdateFlowerStateId(flowerId,stateId));
    }

    @RequestMapping("/UpdateFlowerCollectVolume")
    @ResponseBody
    public R UpdateFlowerCollectVolume(int flowerId, int flowerCollectVolume){
        return R.ok(flowerService.UpdateFlowerCollectVolume(flowerId,flowerCollectVolume));
    }

    @RequestMapping("/UpdateFlowerSalesVolume")
    @ResponseBody
    public R UpdateFlowerSalesVolume(int flowerId, int flowerSalesVolume){
        return R.ok(flowerService.UpdateFlowerSalesVolume(flowerId,flowerSalesVolume));
    }

    @RequestMapping("/UpdateFlowerTotalSales")
    @ResponseBody
    public R UpdateFlowerTotalSales(int flowerId, int flowerTotalSales){
        return R.ok(flowerService.UpdateFlowerTotalSales(flowerId,flowerTotalSales));
    }

    @RequestMapping("/MoreUpdateFlowerStateIdStop")
    @ResponseBody
    public R MoreUpdateFlowerStateIdStop(@RequestBody List<Integer> flowerIds){
        return R.ok(flowerService.MoreUpdateFlowerStateId(flowerIds,1));
    }

    @RequestMapping("/MoreUpdateFlowerStateIdStart")
    @ResponseBody
    public R MoreUpdateFlowerStateIdStart(@RequestBody List<Integer> flowerIds){
        return R.ok(flowerService.MoreUpdateFlowerStateId(flowerIds,2));
    }

    @RequestMapping("/UpdateFlowerInventory")
    @ResponseBody
    public R UpdateFlowerInventory(int flowerId, int flowerInventory){
        return R.ok(flowerService.UpdateFlowerInventory(flowerId,flowerInventory));
    }

    @RequestMapping("/updateFlower")
    @ResponseBody
    public R updateFlower(Flower flower){
        return R.ok(flowerService.updateFlower(flower));
    }

    @RequestMapping("/MoreDeleteFlower")
    @ResponseBody
    public R MoreDeleteFlower(@RequestBody List<Integer> flowerIds){
        return R.ok(flowerService.MoreDeleteFlower(flowerIds));
    }

    @RequestMapping("/DeleteFlower")
    @ResponseBody
    public R DeleteFlower(int flowerId){
        return R.ok(flowerService.DeleteFlower(flowerId));
    }


    //上传图片
    @RequestMapping(value="/put",method= RequestMethod.POST)
    @ResponseBody
    public String upload(@RequestParam("file") MultipartFile file, HttpServletRequest req)
            throws IllegalStateException, IOException {
        //文件存放的位置
        String path="C:\\Users\\liuqi\\Documents\\HBuilderProject\\flower-background\\img\\flower";
        String path2="C:\\Users\\liuqi\\Documents\\HBuilderProject\\flower\\img\\flower";
        //文件名
        String fileName = file.getOriginalFilename();
        File tarFile = new File(path, fileName);
        File tarFile2 = new File(path2, fileName);
        if (!tarFile.getParentFile().exists()) {//判断路径是否存在，不存在就创建
            tarFile.getParentFile().mkdirs();
        }
        if (!tarFile2.getParentFile().exists()) {//判断路径是否存在，不存在就创建
            tarFile2.getParentFile().mkdirs();
        }
        file.transferTo(tarFile);//将文件添加到路径中
        file.transferTo(tarFile2);//将文件添加到路径中
        return "{\"data\":\"封面上传成功！\"}";//返回json
    }

}
