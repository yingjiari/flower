package com.nf511.flower.common;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MakeOrderNum {
    /**
     * 锁对象，可以为任意对象
     */
    private static Object lockObj = "lockerOrder";
    /**
     * 订单号生成计数器
     */
    private static long orderNumCount = 0L;
    /**
     * 每毫秒生成订单号数量最大值
     */
    private static int maxPerMSECSize = 1000;

    /**
     * 生成非重复订单号，理论上限1毫秒1000个，可扩展
     *
     * @param obj 测试用
     */
    public void  makeOrderNum(Object obj) {
        long count=1;
        try {
            // 最终生成的订单号
            String finOrderNum = "";
            synchronized (lockObj) {
                // 取系统当前时间作为订单号变量前半部分
                long nowLong = Long.parseLong(new SimpleDateFormat("YYMMdd").format(new Date()));
                // 计数器到最大值归零，可扩展更大，目前1毫秒处理峰值1000个，1秒100万
                if (orderNumCount >= maxPerMSECSize) {
                    orderNumCount = 0L;
                }
                //组装订单号
                String countStr = maxPerMSECSize + orderNumCount + "";
                finOrderNum = nowLong + countStr.substring(1);
                orderNumCount++;
                System.out.println(finOrderNum+count*1);
                // Thread.sleep(1000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        // 测试多线程调用订单号生成工具
        try {
            //for (int i = 0; i < 1001; i++) {
                Thread t1 = new Thread(new Runnable() {
                    public void run() {
                        MakeOrderNum makeOrder = new MakeOrderNum();
                        makeOrder.makeOrderNum("a");
                    }
                });
                t1.start();

                Thread t2 = new Thread(new Runnable() {
                    public void run() {
                        MakeOrderNum makeOrder = new MakeOrderNum();
                        makeOrder.makeOrderNum("b");
                    }
                });
                t2.start();
           //}
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
