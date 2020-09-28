package com.ftf.ftfProject.mapper;

import com.ftf.ftfProject.entity.Relation;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RelationMapper {

    @Select("select * from relation")
    List<Relation> getAllRelation();
}
