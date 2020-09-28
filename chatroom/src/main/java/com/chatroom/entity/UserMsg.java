package com.chatroom.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description TODO
 * @Author gyhdx
 * @Date 2020/4/8 20:37
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserMsg {

    private String id;
    private String userId;
    private String message;
}
