package com.ftf.ftfProject.mapper;

import com.ftf.ftfProject.entity.Message;
import jdk.nashorn.internal.objects.annotations.Setter;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageMapper {

    @Select("select * from message")
    List<Message> getAllMessage();
}
