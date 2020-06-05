package com.domain;

/**
 *
 * 通过 pojo 表达式，实现组装多个对象构成的查询条件
 *
 * @author: c
 * @date: 2020/6/4
 */
public class QueryVo {
    private User user;

    private String sex = "男";

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
