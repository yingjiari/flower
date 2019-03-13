package com.nf511.flower.dao;

import com.nf511.flower.entity.Collect;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CollectDao {
    List<Collect> selectAllCollect(long userId);
    int insertCollect(Collect collect);
    int selectCollectOne(@Param("userId") long userId,@Param("flowerId") long flowerId);
    int deleteCollect(@Param("collectId") int collectId);
    int deleteAll(@Param("collectIds") List<Integer> collectIds);
    int collectCount(Collect collect);



    Collect selectCollectId(@Param("userId") long userId,@Param("flowerId") long flowerId);
    Collect selectAllCollectId(@Param("collectId") int collectId);
    List<Collect>selectAllCollectByPage(@Param("pagelimit") int pagelimit, @Param("size") int size);
    int updateCollect(Collect collect);
}
