package com.nf511.flower.dao;

import com.nf511.flower.entity.State;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StateDao {
    List<State> selectAllState();
    State selectAllStateId(@Param("stateId") int stateId);
    List<State>selectAlStateByPage(@Param("pagelimit") int pagelimit, @Param("size") int size);
    int insertState(State state);
    int updateState(State state);
    int deleteState(@Param("stateId") int stateId);
    int deleteAll(@Param("stateIds") List<Integer> items);
}
