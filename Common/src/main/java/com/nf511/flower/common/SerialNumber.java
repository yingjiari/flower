package com.nf511.flower.common;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class SerialNumber {

    /**
     * 获取现在时间
     * @return返回字符串格式yyyyMMddHHmmss
     */
    public static String getStringDate() {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("YYMMdd");
        String dateString = formatter.format(currentTime);
        // System.out.println("TIME:::"+dateString);
        return dateString;
    }

    public static String getStringDate1() {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("mmss");
        String dateString = formatter.format(currentTime);
        // System.out.println("TIME:::"+dateString);
        return dateString;
    }
    /**
     * 固定资产编号，由年月日时分秒+3位随机数
     * 生成流水号
     * @return
     */
    public static String assetNumber(){
        String t = getStringDate1();
        int x=(int)(Math.random()*90)+10;
        String serial = t + x;
        return serial;
    }

    /**
     * 由年月日时分秒+3位随机数
     * 生成流水号
     * @return
     */
    public static String Getnum(){
        String o="0000";
        String t = getStringDate();
        //int x=(int)(Math.random()*90)+10;
        // String serial = t + x;
        String serial = t+o ;
        return serial;
    }

    /**
     * 由年月日时分秒+3位随机数
     * 生成流水号
     * @return
     */
    public static String Getnum1(){
        String t = getStringDate();
        int x=(int)(Math.random()*9);
        String serial = t + x;
        return serial;
    }



    public static String getTwo() {
        Random rad = new Random();

        String result = rad.nextInt(100) + "";

        if (result.length() == 1) {
            result = "0" + result;
        }
        return result;
    }

    public  static String GetSystemserialnumber() {
        String date = new SimpleDateFormat("yyyyMMdd").format(new Date());
        String seconds = new SimpleDateFormat("HHmmss").format(new Date());
        return date + getTwo() + "00" + seconds + getTwo();
    }

    //主方法测试
    public static void main(String[] args) {
        String m= assetNumber();
        String g= Getnum();
        long gl = Long.valueOf(g);//转换为long
        String g1= Getnum1();
        String t= GetSystemserialnumber();
        System.out.println(m);
        System.out.println((gl+1));
        System.out.println(g1);
        System.out.println(t);
    }
}
