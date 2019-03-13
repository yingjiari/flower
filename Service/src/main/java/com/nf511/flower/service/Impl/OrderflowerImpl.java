package com.nf511.flower.service.Impl;

import com.nf511.flower.dao.OrderflowerDao;
import com.nf511.flower.entity.Orderflower;
import com.nf511.flower.service.OrderflowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderflowerImpl implements OrderflowerService {

    @Autowired
    OrderflowerDao orderflowerDao;

    public List<Orderflower> selectAllOrderflower() {
        return orderflowerDao.selectAllOrderflower();
    }

    public Orderflower selectAllOrderflowerId(int orderflowerId) {
        return orderflowerDao.selectAllOrderflowerId(orderflowerId);
    }

    public List<Orderflower> selectAllOrderflowerByPage(int pagelimit, int size) {
        return orderflowerDao.selectAllOrderflowerByPage(pagelimit, size);
    }

    public int insertOrderflower(List<Integer> cartIds) {
        return orderflowerDao.insertOrderflower(cartIds);
    }

    public int updateOrderflowerBycartId(long orderId, List<Integer> cartIds) {
        return orderflowerDao.updateOrderflowerBycartId(orderId, cartIds);
    }

    public List<Orderflower> selectAllByOrderId(int orderId) {
        return orderflowerDao.selectAllByOrderId(orderId);
    }

    public int updateOrderflower(Orderflower orderflower) {
        return orderflowerDao.updateOrderflower(orderflower);
    }

    public int deleteOrderflower(int orderflowerId) {
        return orderflowerDao.deleteOrderflower(orderflowerId);
    }

    public int deleteAll(List<Integer> items) {
        return orderflowerDao.deleteAll(items);
    }
}
