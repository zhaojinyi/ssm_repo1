package com.zjy.pojo;

import java.util.Date;

/**
 * @Auther: 无聊的人
 * @Date: 2019/3/9
 * @Description: com.zjy.pojo
 */
public class User {
    private Long id;
    private Date date;

    public User() {
    }

    public User(Long id) {
        this.id = id;
        this.date = new Date();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
