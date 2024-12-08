package com.feng.cloud.pojo;

import lombok.Data;

/**
 * @Description://TODO
 * @Author: fangx
 * @Data 2024年06月25日 21:54
 */
@Data
public class User {

    private String username;

    public User(String username) {
        this.username = username;
    }
}
