package com.hj.implement;

import com.hj.dao.BookDao;

/**
 * @author Love-hj
 * @date 2020/3/26 - 22:20
 */
public class BookDaoImpl implements BookDao {

    @Override
    public void save(){
        System.out.println("save");
    }
}
