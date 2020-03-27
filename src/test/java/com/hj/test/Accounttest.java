package com.hj.test;


import com.hj.dao.AccountDao;
import com.hj.dao.UserDao;
import com.hj.domain.Account;
import com.hj.domain.QueryVo;
import com.hj.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Love-hj
 * @date 2020/3/24 - 10:49
 */
public class Accounttest {

    private InputStream in;
    private SqlSession session;
    private AccountDao accountDao;

    @Before//用于在测试方法执行之前执行
    public void init () throws Exception{
        //1.读取配置文件
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.创建SqlSessionFactory工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        //3.使用工厂生产SqlSession对象
        session = factory.openSession();
        //4.使用SqlSession创建Dao接口的代理对象
        accountDao = session.getMapper(AccountDao.class);
    }
    @After//用于在测试方法执行之后执行
    public void destory() throws Exception{

        //提交事务
        session.commit();
        //6.释放资源
        session.close();
        in.close();

    }
    @Test //用于查找所有账户方法的测试
    public void selectTest(){

        //5.使用代理对象执行查找方法
        List<Account> accounts = accountDao.findAll();
        for (Account account : accounts){
            System.out.println("--------------------");
            System.out.println(account);
            System.out.println(account.getUser());
        }
    }
}
