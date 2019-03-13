package com.nf511.flower.service.Impl;

import com.nf511.flower.dao.FlowerbranchnumberDAO;
import com.nf511.flower.entity.Flowerbranchnumber;
import com.nf511.flower.service.FlowerbranchnumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlowerbranchnumberServiceImpl implements FlowerbranchnumberService {

    @Autowired
    FlowerbranchnumberDAO flowerbranchnumberDAO;

    public List<Flowerbranchnumber> getAllFlowerbranchnumber() {
        return flowerbranchnumberDAO.getAllFlowerbranchnumber();
    }

    public Flowerbranchnumber selectAllFlowerBranchNumberId(int flowerBranchNumberId) {
        return flowerbranchnumberDAO.selectAllFlowerBranchNumberId(flowerBranchNumberId);
    }

    public int insertFlowerBranchNumber(Flowerbranchnumber flowerbranchnumber) {
        return flowerbranchnumberDAO.insertFlowerBranchNumber(flowerbranchnumber);
    }

    public int updateFlowerBranchNumber(Flowerbranchnumber flowerbranchnumber) {
        return flowerbranchnumberDAO.updateFlowerBranchNumber(flowerbranchnumber);
    }

    public int deleteFlowerBranchNumber(int flowerBranchNumberId) {
        return flowerbranchnumberDAO.deleteFlowerBranchNumber(flowerBranchNumberId);
    }

    public int deleteAll(List<Integer> items) {
        return flowerbranchnumberDAO.deleteAll(items);
    }
}
