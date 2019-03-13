package com.nf511.flower.service;

import com.nf511.flower.entity.Floweruse;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FloweruseService {

    List<Floweruse> getAllFloweruse();

    Floweruse selectAllFloweruseId(@Param("flowerUseId") int flowerUseId);
    int insertFloweruse(Floweruse floweruse);
    int updateFloweruse(Floweruse floweruse);
    int deleteFloweruse(@Param("flowerUseId") int flowerUseId);
    int deleteAll(@Param("flowerUseIds") List<Integer>items);
}
