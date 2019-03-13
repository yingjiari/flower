package com.nf511.flower.dao;

import com.nf511.flower.entity.Flower;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FlowerDAO {

    List<Flower> getFlower( Flower flower);

    int getFlowerCount(Flower flower);

    int insertFlower(Flower flower);

    int UpdateFlowerStateId(@Param("flowerId") long flowerId, @Param("stateId") long stateId);

    int UpdateFlowerCollectVolume(@Param("flowerId") long flowerId, @Param("flowerCollectVolume") long flowerCollectVolume);

    int UpdateFlowerSalesVolume(@Param("flowerId") long flowerId, @Param("flowerSalesVolume") long flowerSalesVolume);

    int UpdateFlowerTotalSales(@Param("flowerId") long flowerId, @Param("flowerTotalSales") long flowerTotalSales);

    int MoreUpdateFlowerStateId(@Param("flowerIds") List<Integer> flowerIds,@Param("stateId") long stateId);

    int UpdateFlowerInventory(@Param("flowerId") long flowerId, @Param("flowerInventory") long flowerInventory);

    int updateFlower(Flower flower);

    int MoreDeleteFlower(@Param("flowerIds") List<Integer> flwerIds);

    int DeleteFlower(int flowerId);






}
