package com.nf511.flower.controller;




import com.nf511.flower.common.R;
import com.nf511.flower.entity.Order;
import com.nf511.flower.entity.Orderflower;
import com.nf511.flower.service.OrderService;
import com.nf511.flower.service.OrderflowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(path = "/orderflowerService")
public class OrderflowerController {

    @Autowired
    OrderflowerService orderflowerService;

    @Autowired
    OrderService orderService;

    /**
     * 添加
     * */
    @RequestMapping(path = "/insertOrderflower",method = RequestMethod.POST)
    @ResponseBody
    public R insertOrderflower(@RequestBody List<Integer> cartIds){
        return R.ok(orderflowerService.insertOrderflower(cartIds));
    }

    /**
     * 修改订单商品编号
     * */
    @RequestMapping(path = "/updateOrderflowerBycartId",method = RequestMethod.POST)
    @ResponseBody
    public R updateOrderflowerBycartId(@RequestBody List<Integer> cartIds){
        Order order=new Order();
        order.setOrderState(8);
        order.setSkip(0);
        order.setSize(1);
        System.out.println(orderService.selectAllOrderPage(order).get(0).getOrderId());
        long orderId=orderService.selectAllOrderPage(order).get(0).getOrderId();
        return R.ok(orderflowerService.updateOrderflowerBycartId(orderId,cartIds));
    }

    /**
     * 根据订单编号查询订单商品
     * */
    @RequestMapping(path = "/selectAllByOrderId",method = RequestMethod.POST)
    @ResponseBody
    public R selectAllByOrderId(int orderId){
        return R.ok(orderflowerService.selectAllByOrderId(orderId));
    }






    /**
     * 查询全部
     * */
    @RequestMapping(path = "/selectAllOrderflower",method = RequestMethod.POST)
    @ResponseBody
    public R selectAllOrderflower(){
        return R.ok(orderflowerService.selectAllOrderflower());
    }

    /**
     * 根据ID查询
     * */
    @RequestMapping(path = "/selectAllOrderflowerId",method = RequestMethod.POST)
    @ResponseBody
    public R selectAllOrderflowerId(int orderflowerId){
        return R.ok(orderflowerService.selectAllOrderflowerId(orderflowerId));
    }



    /**
     * 修改
     * */
    @RequestMapping(path = "/updateOrderflower",method = RequestMethod.POST)
    @ResponseBody
    public R updateOrderflower(Orderflower orderflower){
        return R.ok(orderflowerService.updateOrderflower(orderflower));
    }

    /**
     * 删除
     * */
    @RequestMapping(path = "/deleteOrderflower",method = RequestMethod.POST)
    @ResponseBody
    public R deleteOrderflower(int orderflowerId){
        return R.ok(orderflowerService.deleteOrderflower(orderflowerId));
    }

    /**
     * 多删除
     * */
    @RequestMapping(path = "/deleteAll",method = RequestMethod.POST)
    @ResponseBody
    public R deleteAll(@RequestBody List<Integer> items){
        return R.ok(orderflowerService.deleteAll(items));
    }

    /*
     * 打印订单
     * */
//    @RequestMapping(value = "/printPdf", method = RequestMethod.POST)
//    @ResponseBody
//    public String printPdf(@RequestBody List<Orderflower> objlist,long orderId) {
//        Map<String, Object> objectMap = new HashMap<>();
//        objectMap.put("orderId", objlist.get(0).toString());
//        Orderflower ordersList = orderflowerService.selectAllByOrderId(orderId);
//
//        PrinterJob job = PrinterJob.getPrinterJob();
//        PageFormat pageFormat = job.defaultPage();//得到默认页格式
//        ArrayList<Orderflower> arrayList = new ArrayList<>();
//        for (int i = 0; i < ((List) ordersList).size(); i++) {
//            arrayList.add((ordersList).get(i));
//        }
//        job.setPrintable(new PrintPdf(arrayList));//设置打印类
//        try {
//            //可以用printDialog显示打印对话框，在用户确认后打印；也可以直接打印
//            boolean a = job.printDialog();
//            if (a) {
//                job.print();
//            } else {
//                job.cancel();
//            }
//        } catch (PrinterException e) {
//            e.printStackTrace();
//        }
//        return "";
//    }
}
