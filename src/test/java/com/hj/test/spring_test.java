package com.hj.test;

import com.hj.dao.BookService;
import com.hj.dao.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * @author Love-hj
 * @date 2020/3/26 - 21:34
 */
public class spring_test {

    @Test
    public void UserServiceTest(){

        //1.获取容器
        String xmlpath = "ApplicationContent.xml";
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlpath);
        //2.获取内容 不需要自己去new对象，直接从spring容器拿
        UserService userService = (UserService) applicationContext.getBean("UserServiceId");
        userService.addUser();
    }

    @Test
    public void BookServiceTest(){

        //1.获取容器
        String xmlpath = "ApplicationContent.xml";
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlpath);
        //2.获取内容 不需要自己去new对象，直接从spring容器拿
        BookService bookService = (BookService) applicationContext.getBean("BookServiceId");
        bookService.addBook();
    }
}
