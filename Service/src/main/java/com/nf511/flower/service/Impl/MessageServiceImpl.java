package com.nf511.flower.service.Impl;

import com.nf511.flower.dao.MessageDao;
import com.nf511.flower.entity.Message;
import com.nf511.flower.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    MessageDao messageDao;

    public List<Message> selectAllMessage(Message message) {
        return messageDao.selectAllMessage(message);
    }

    public int MessageCount(Message message) {
        return messageDao.MessageCount(message);
    }

    public int insertMessage(Message message) {
        return messageDao.insertMessage(message);
    }

    public Message selectMessage(Message message) {
        return messageDao.selectMessage(message);
    }
}
