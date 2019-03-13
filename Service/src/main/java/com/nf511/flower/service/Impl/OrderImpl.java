package com.nf511.flower.service.Impl;

import com.nf511.flower.dao.OrderDao;
import com.nf511.flower.entity.Order;
import com.nf511.flower.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderImpl  implements OrderService {

    @Autowired
    OrderDao orderDao;

    public List<Order> selectAllOrder(Order order) {
        return orderDao.selectAllOrder(order);
    }

    public int getOrderCount(Order order) {
        return orderDao.getOrderCount(order);
    }

    public List<Order> selectAllOrderPage(Order order) {
        return orderDao.selectAllOrderPage(order);
    }

    public int UpdateOrderState(long orderId, long orderState) {
        return orderDao.UpdateOrderState(orderId, orderState);
    }

    public Order selectAllOrderId(int orderId) {
        return orderDao.selectAllOrderId(orderId);
    }

    public List<Order> selectAllOrderByPage(int pagelimit, int size) {
        return orderDao.selectAllOrderByPage(pagelimit,size);
    }

    public int insertOrder(Order order) {
        return orderDao.insertOrder(order);
    }

    public int updateOrder(Order order) {
        return orderDao.updateOrder(order);
    }

    public int deleteOrder(int orderId) {
        return orderDao.deleteOrder(orderId);
    }

    public int deleteAll(List<Integer> items) {
        return orderDao.deleteAll(items);
    }
}
