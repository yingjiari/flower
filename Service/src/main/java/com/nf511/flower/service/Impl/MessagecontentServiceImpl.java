package com.nf511.flower.service.Impl;

import com.nf511.flower.dao.MessagecontentDao;
import com.nf511.flower.entity.Messagecontent;
import com.nf511.flower.service.MessagecontentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessagecontentServiceImpl implements MessagecontentService {

    @Autowired
    MessagecontentDao messagecontentDao;

    public List<Messagecontent> selectAllMessageContentByUserId(int userId) {
        return messagecontentDao.selectAllMessageContentByUserId(userId);
    }

    public int insertMessagecontent(Messagecontent messagecontent) {
        return messagecontentDao.insertMessagecontent(messagecontent);
    }

    public int updateMessagecontent(Messagecontent messagecontent) {
        return messagecontentDao.updateMessagecontent(messagecontent);
    }
}
