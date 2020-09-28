package com.tcp.tcpchat.mapper;

import com.tcp.tcpchat.entity.User;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
    @Select("select * from user")
    List<User> findAllUsers();
}
