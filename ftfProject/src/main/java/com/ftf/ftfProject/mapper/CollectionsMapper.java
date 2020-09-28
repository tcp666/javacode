package com.ftf.ftfProject.mapper;

import com.ftf.ftfProject.entity.Collections;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CollectionsMapper {

    @Select("select * from collections")
    List<Collections> getCollections();
}
