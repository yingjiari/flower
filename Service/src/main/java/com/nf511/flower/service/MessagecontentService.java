package com.nf511.flower.service;

import com.nf511.flower.entity.Messagecontent;

import java.util.List;

public interface MessagecontentService {

    List<Messagecontent> selectAllMessageContentByUserId(int userId);

    int insertMessagecontent(Messagecontent messagecontent);

    int updateMessagecontent(Messagecontent messagecontent);

}
