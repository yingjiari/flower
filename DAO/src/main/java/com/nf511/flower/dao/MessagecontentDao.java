package com.nf511.flower.dao;

import com.nf511.flower.entity.Messagecontent;

import java.util.List;

public interface MessagecontentDao {
    List<Messagecontent> selectAllMessageContentByUserId(int userId);

    int insertMessagecontent(Messagecontent messagecontent);

    int updateMessagecontent(Messagecontent messagecontent);
}
