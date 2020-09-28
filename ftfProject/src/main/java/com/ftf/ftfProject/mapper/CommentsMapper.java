package com.ftf.ftfProject.mapper;

import com.ftf.ftfProject.entity.Comments;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentsMapper {

    @Select("select * from comments")
    List<Comments> getAllComments();
}
