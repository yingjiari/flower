package com.nf511.flower.service;

import com.nf511.flower.entity.Flowerbranchnumber;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FlowerbranchnumberService {

    List<Flowerbranchnumber> getAllFlowerbranchnumber();

    Flowerbranchnumber selectAllFlowerBranchNumberId(@Param("flowerBranchNumberId") int flowerBranchNumberId);
    int insertFlowerBranchNumber(Flowerbranchnumber flowerbranchnumber);
    int updateFlowerBranchNumber(Flowerbranchnumber flowerbranchnumber);
    int deleteFlowerBranchNumber(@Param("flowerBranchNumberId") int flowerBranchNumberId);
    int deleteAll(@Param("flowerBranchNumberIds") List<Integer>items);
}
