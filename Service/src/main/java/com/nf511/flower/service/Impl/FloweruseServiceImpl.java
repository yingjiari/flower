package com.nf511.flower.service.Impl;

import com.nf511.flower.dao.FloweruseDAO;
import com.nf511.flower.entity.Floweruse;
import com.nf511.flower.service.FloweruseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FloweruseServiceImpl implements FloweruseService {

    @Autowired
    FloweruseDAO floweruseDAO;

    public List<Floweruse> getAllFloweruse() {
        return floweruseDAO.getAllFloweruse();
    }

    public Floweruse selectAllFloweruseId(int flowerUseId) {
        return floweruseDAO.selectAllFloweruseId(flowerUseId);
    }

    public int insertFloweruse(Floweruse floweruse) {
        return floweruseDAO.insertFloweruse(floweruse);
    }

    public int updateFloweruse(Floweruse floweruse) {
        return floweruseDAO.updateFloweruse(floweruse);
    }

    public int deleteFloweruse(int flowerUseId) {
        return floweruseDAO.deleteFloweruse(flowerUseId);
    }

    public int deleteAll(List<Integer> items) {
        return floweruseDAO.deleteAll(items);
    }
}
