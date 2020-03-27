package com.hj.implement;

import com.hj.dao.BookDao;
import com.hj.dao.BookService;

/**
 * @author Love-hj
 * @date 2020/3/26 - 22:21
 */
public class BookServiceImpl implements BookService {

    private BookDao bookDao;

    public void setBookDao(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    @Override
    public void addBook(){
        this.bookDao.save();
    }
}
