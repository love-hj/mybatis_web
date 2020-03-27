package com.hj.test;


import com.hj.dao.UserDao;
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
public class Mybatistest {

    private InputStream in;
    private SqlSession session;
    private UserDao userDao;

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
        userDao = session.getMapper(UserDao.class);
    }
    @After//用于在测试方法执行之后执行
    public void destory() throws Exception{

        //提交事务
        session.commit();
        //6.释放资源
        session.close();
        in.close();

    }
    @Test //用于查找所有用户方法的测试
    public void selectTest(){

        //5.使用代理对象执行查找方法
        List<User> users = userDao.findAll();
        for (User user : users){
            System.out.println("----------------------");
            System.out.println(user);
            System.out.println(user.getRoles());
        }
    }
    @Test //用于保存用户的方法测试
    public void insertTest(){
        User user = new User();
        user.setUsername("insert us");
        user.setPassword("123321");

        System.out.println("执行之前："+user);
        //5.使用代理对象执行保存方法
        userDao.saveUser(user);

        System.out.println("执行之后："+user);
    }
    @Test //用于更新用户的方法测试
    public void updateTest(){
        User user = new User();
        user.setId(1);
        user.setUsername("nihao");
        user.setPassword("123");

        //5.使用代理对象执行更新方法
        userDao.updateUser(user);
    }
    @Test //用于删除用户的方法测试
    public void deleteTest(){

        //5.使用代理对象执行更新方法
        userDao.deleteUser(3);
    }
    @Test //用于id查找单个用户方法的测试
    public void selectSingleTest(){

        //5.使用代理对象通过id执行查找方法
        User users = userDao.selectSingleUser(2);
        System.out.println(users);
    }
    @Test //通过name模糊查询用户方法的测试
    public void selectNameTest(){

        //5.使用代理对象通过name模糊执行查找方法
        List<User> users = userDao.selectNameUser("%田%");

        for (User user : users){
            System.out.println(user);
        }
    }
    @Test //查询用户个数方法的测试
    public void selectTotalTest(){

        //5.使用代理对象通过name模糊执行查找方法
        int count = userDao.selectTotalUser();
        System.out.println(count);
    }
    @Test //通过queryvo模糊查询用户方法的测试
    public void selectQueryVoTest(){

        //5.使用代理对象通过queryvo模糊执行查找方法
        QueryVo vo = new QueryVo();
        User user = new User();
        user.setUsername("%田%");
        vo.setUser(user);

        List<User> users = userDao.selectQueryVoUser(vo);

        for (User u : users){
            System.out.println(u);
        }
    }
    @Test //通过queryvo的id集合查询用户方法的测试
    public void selectQueryVoIdTest(){

        //5.使用代理对象通过queryvo模糊执行查找方法
        QueryVo vo = new QueryVo();
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(4);
        list.add(5);
        vo.setIds(list);

        List<User> users = userDao.selectQueryVoIdUser(vo);

        for (User u : users){
            System.out.println(u);
        }
    }

}
