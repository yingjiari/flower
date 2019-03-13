package com.nf511.flower.service.Impl;

import com.nf511.flower.dao.FlowertypeDAO;
import com.nf511.flower.entity.Flowertype;
import com.nf511.flower.service.FlowertypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlowertypeServiceImpl implements FlowertypeService {

    @Autowired
    FlowertypeDAO flowertypeDAO;

    public List<Flowertype> getAllFlowertype() {
        return flowertypeDAO.getAllFlowertype();
    }

    public Flowertype selectAllFlowertypeId(int flowerTypeId) {
        return flowertypeDAO.selectAllFlowertypeId(flowerTypeId);
    }

    public int insertFlowertype(Flowertype flowertype) {
        return flowertypeDAO.insertFlowertype(flowertype);
    }

    public int updateFlowertype(Flowertype flowertype) {
        return flowertypeDAO.updateFlowertype(flowertype);
    }

    public int deleteFlowertype(int flowerTypeId) {
        return flowertypeDAO.deleteFlowertype(flowerTypeId);
    }

    public int deleteAll(List<Integer> items) {
        return flowertypeDAO.deleteAll(items);
    }
}
