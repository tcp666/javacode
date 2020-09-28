package com.ftf.ftfProject.mapper;

import com.ftf.ftfProject.entity.Users;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {

    @Select("select * from users")
    List<Users> selectAll();
}
