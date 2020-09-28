package com.ftf.ftfProject.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@ToString
public class Relation implements Serializable {

    private String relationId;
    private Date relationTime;
    private String relationType;
    private String userId;
    private String userById;

}
