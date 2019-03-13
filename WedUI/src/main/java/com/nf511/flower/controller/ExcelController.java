package com.nf511.flower.controller;

import com.nf511.flower.entity.Address;
import com.nf511.flower.entity.Flower;
import com.nf511.flower.entity.Order;
import com.nf511.flower.entity.User;
import com.nf511.flower.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellStyle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
@Controller
@RequestMapping(path = "/excelController")
public class ExcelController {
    @Autowired
    AddressService addressService;
    @Autowired
    AdminService adminService;
    @Autowired
    CartService cartService;
    @Autowired
    CollectService collectService;
    @Autowired
    FlowerbranchnumberService flowerbranchnumberService;
    @Autowired
    FlowerService flowerService;
    @Autowired
    FlowertypeService flowertypeService;
    @Autowired
    FloweruseService floweruseService;
    @Autowired
    ImageService imageService;
    @Autowired
    OrderflowerService orderflowerService;
    @Autowired
    OrderService orderService;
    @Autowired
    StateService stateService;
    @Autowired
    UserService userService;

    /**
     * 导出csv表格 Address 地址表
     *
     * @param response
     * @throws IOException
     */@RequestMapping(value = "/exploreCsvAddress",method = RequestMethod.GET)
    @ResponseBody
    public void joinXml(HttpServletResponse response,int userId) throws IOException {

        //先获得所有数据
        List<Address> addressList=addressService.selectAllAddress(userId);
        response.setHeader("Content-Type","application/octet-stream;charset=utf-8");
        response.setHeader("Content-Disposition","attachment;filename="+new String("地址信息".getBytes(),"UTF-8")+".csv");
        PrintWriter out=response.getWriter();
        //加上bom头,解决excel打开乱码问题
        byte[] bomStrByteArr = new byte[] { (byte) 0xef, (byte) 0xbb, (byte) 0xbf };
        String bomStr = new String(bomStrByteArr, "UTF-8");
        out.write(bomStr);
        StringBuffer str=new StringBuffer("");
        str.append("编号,对应用户编号,收货人姓名,收货人手机,收货人地址,详细地址\r\n");
        for (Address item:addressList) {
            str.append(item.getAddressId()+","+item.getUserId()+","+","+item.getConsigneeName()+","+item.getConsigneePhone()+","+item.getAddress()+"," +item.getDetailedAddress()+"\r\n");
        }
        response.getWriter().write(str.toString());
    }

    /**
     * 导出Excel表格 Address 地址表
     *
     * @param response
     * @throws IOException
     */
    @RequestMapping(value = "/exploreExcel")
    @SuppressWarnings("resource")
    public void excel(HttpServletResponse response,int userId) throws IOException {
        //先获得所有数据
        List<Address> addressList=addressService.selectAllAddress(userId);

        //设置标题
        String head = "地址信息";
        //设置表头行
        String[] headrow = {"编号","对应用户编号","收货人姓名","收货人手机","收货人地址","详细地址"};

        if (null != addressList && addressList.size() > 0) {
            String fileName = "地址信息.xls";//定义导出头
            response.setHeader("Content-disposition", "attachment;filename=" + new String(fileName.getBytes("gb2312"), "ISO8859-1"));    //设置文件头编码格式
            response.setContentType("APPLICATION/OCTET-STREAM;charset=UTF-8");//设置类型
            response.setHeader("Cache-Control", "no-cache");//设置头
            response.setDateHeader("Expires", 0);//设置日期头

            //创建工作簿HSSFWorkbook 对象
            HSSFWorkbook book = new HSSFWorkbook();
            // 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet
            HSSFSheet sheet = book.createSheet();
            // 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short
            HSSFRow row = sheet.createRow(0);
            //由工作簿创建表HSSFSheet对象
            CellStyle cellStyle = book.createCellStyle();

            cellStyle.setDataFormat(book.createDataFormat().getFormat("yyyy-MM-dd"));

            //设置表头
            HSSFCell cell = row.createCell((short) 0);
            cell.setCellValue(head);
            row = sheet.createRow(1);
            for (int i = 0; i < headrow.length; i++) {
                cell = row.createCell((short) i);
                cell.setCellValue(headrow[i]);
            }

            for (int i = 0; i < addressList.size(); i++) {
                //实体类对象
                Address address = addressList.get(i);
                row = sheet.createRow((i + 2));
                row.createCell((short) 0).setCellValue(address.getAddressId());
                row.createCell((short) 1).setCellValue(address.getUserId());
                row.createCell((short) 2).setCellValue(address.getConsigneeName());
                row.createCell((short) 3).setCellValue(address.getConsigneePhone());
                row.createCell((short) 4).setCellValue(address.getAddress());
                row.createCell((short) 5).setCellValue(address.getDetailedAddress());
            }
            //写出流  刷新缓冲流  关闭流对象
            book.write(response.getOutputStream());
            response.getOutputStream().flush();
            response.getOutputStream().close();
        }
    }


    //商品导出
    @RequestMapping("/FlowerPushCsv")
    @ResponseBody
    public void FlowerPushCsv(HttpServletResponse response,Flower flower) throws IOException {
        response.setHeader("Content-Type","application/octet-stream;charset=utf-8");
        response.setHeader("Content-Disposition","attachment;filename=product.csv");
        PrintWriter out = response.getWriter();
        //加上bom头,解决excel打开乱码问题
        byte[] bomStrByteArr = new byte[] { (byte) 0xef, (byte) 0xbb, (byte) 0xbf };
        String bomStr = new String(bomStrByteArr, "UTF-8");
        out.write(bomStr);
        System.out.println(bomStr);

        List<Flower> list=flowerService.getFlower(flower);
        StringBuffer str=new StringBuffer("");
        str.append("鲜花编号,鲜花名称\r\n");
        for (Flower commodity:list) {
            str.append(commodity.getFlowerId()+","+commodity.getFlowerName()+"\r\n");
        }
        response.getWriter().write(str.toString());
    }

    //用户导出
    @RequestMapping("/UserPushCsv")
    @ResponseBody
    public void UserPushCsv(HttpServletResponse response,User user) throws IOException {
        response.setHeader("Content-Type","application/octet-stream;charset=utf-8");
        response.setHeader("Content-Disposition","attachment;filename=product.csv");
        PrintWriter out = response.getWriter();
        //加上bom头,解决excel打开乱码问题
        byte[] bomStrByteArr = new byte[] { (byte) 0xef, (byte) 0xbb, (byte) 0xbf };
        String bomStr = new String(bomStrByteArr, "UTF-8");
        out.write(bomStr);
        System.out.println(bomStr);

        List<User> list=userService.selectAllUser(user);
        StringBuffer str=new StringBuffer("");
        str.append("用户编号,用户名称\r\n");
        for (User commodity:list) {
            str.append(commodity.getUserId()+","+commodity.getUserName()+"\r\n");
        }
        response.getWriter().write(str.toString());
    }

    //用户导出
    @RequestMapping("/OrderPushCsv")
    @ResponseBody
    public void OrderPushCsv(HttpServletResponse response,Order order) throws IOException {
        response.setHeader("Content-Type","application/octet-stream;charset=utf-8");
        response.setHeader("Content-Disposition","attachment;filename=product.csv");
        PrintWriter out = response.getWriter();
        //加上bom头,解决excel打开乱码问题
        byte[] bomStrByteArr = new byte[] { (byte) 0xef, (byte) 0xbb, (byte) 0xbf };
        String bomStr = new String(bomStrByteArr, "UTF-8");
        out.write(bomStr);
        System.out.println(bomStr);

        List<Order> list=orderService.selectAllOrderPage(order);
        StringBuffer str=new StringBuffer("");
        str.append("订单编号,订单价格\r\n");
        for (Order commodity:list) {
            str.append(commodity.getOrderId()+","+commodity.getOrderPrice()+"\r\n");
        }
        response.getWriter().write(str.toString());
    }

}
