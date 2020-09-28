package com.ftf.ftfProject.service.impl;

import com.ftf.ftfProject.entity.Relation;
import com.ftf.ftfProject.mapper.RelationMapper;
import com.ftf.ftfProject.service.RelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RelationServiceImpl implements RelationService {

    @Autowired
    private RelationMapper relationMapper;

    @Override
    public List<Relation> getAllRelation() {
        return relationMapper.getAllRelation();
    }
}
