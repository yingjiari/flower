package com.nf511.flower.service;

import com.nf511.flower.entity.Flowertype;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FlowertypeService {

    List<Flowertype> getAllFlowertype();

    Flowertype selectAllFlowertypeId(@Param("flowerTypeId") int flowerTypeId);
    int insertFlowertype(Flowertype flowertype);
    int updateFlowertype(Flowertype flowertype);
    int deleteFlowertype(@Param("flowerTypeId") int flowerTypeId);
    int deleteAll(@Param("flowerTypeIds") List<Integer>items);
}
