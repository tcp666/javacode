package com.ftf.ftfProject.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@ToString
public class Comments implements Serializable {

    private String commentsId;
    private String commentsInfo;
    private String commentsTime;
    private String messageId;
    private String userId;
}
