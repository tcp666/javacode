package com.ftf.ftfProject.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@Setter
@Getter
@ToString
public class Message implements Serializable {

    private String messagesId;
    private String messagesType;
    private String messagesInfo;
    private Date messagesTime;
    private Integer messagesCollectnum;
    private Integer messagesCommentnum;
    private Integer messagesTranspondnum;
    private Integer messagesAgreenum;
    private Integer messagesReadnum;
    private String messagesLabel;
    private String userId;
}
