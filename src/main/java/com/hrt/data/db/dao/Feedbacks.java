package com.hrt.data.db.dao;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.GetGeneratedKeys;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;
import org.skife.jdbi.v2.sqlobject.mixins.Transactional;

import com.hrt.data.db.mappers.FeedbackMapper;



 

@RegisterMapper(FeedbackMapper.class)
public interface Feedbacks extends Transactional<Feedbacks> {

    @SqlUpdate("insert into Feedback (userId, comment)  values (:userId, :feedback)")
    @GetGeneratedKeys
    long insert(@Bind("userId") long userId, @Bind("feedback") String feedback);
}
