package com.ftf.ftfProject.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@ToString
public class Role implements Serializable {

    private String roleId;
    private String roleName;
    private String roleDes;
}
