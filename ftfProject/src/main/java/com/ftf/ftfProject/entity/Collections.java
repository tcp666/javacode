package com.ftf.ftfProject.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@ToString
public class Collections implements Serializable {

    private String CollectionsId;
    private String CollectionsTime;
    private String CollectionsStatus;
    private String userId;
}
