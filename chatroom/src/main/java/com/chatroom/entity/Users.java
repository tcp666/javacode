package com.chatroom.entity;

import lombok.*;

/**
 * @Description TODO
 * @Author gyhdx
 * @Date 2020/4/6 12:33
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Users {
    private String id;
    private String username;
    private String password;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
