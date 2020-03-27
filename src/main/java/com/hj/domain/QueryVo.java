package com.hj.domain;

import java.util.List;

/**
 * @author Love-hj
 * @date 2020/3/25 - 19:59
 */
public class QueryVo {

    private User user;
    private List<Integer> ids;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }
}
