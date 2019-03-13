package com.nf511.flower.dao;


import com.nf511.flower.entity.Message;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MessageDao {

    List<Message> selectAllMessage(Message message);

    int MessageCount(Message message);

    int insertMessage(Message message);

    Message selectMessage(Message message);

}
