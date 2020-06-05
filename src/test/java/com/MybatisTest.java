package com;


import com.dao.IUserDao;
import com.domain.QueryVo;
import com.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

/**
 * @author: c
 * @date: 2019/12/21
 */
public class MybatisTest {

    /*
     *  mybatis 入门案例，测试
     * */

    private InputStream is;
    private SqlSession sqlSession;
    private IUserDao mapper;

    @Before
    public void init() throws IOException {
        //1.读取xml配置文件
        is = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.创建 SqlSessionFactory 工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(is); // SqlSessionFactory是接口不能直接使用
        //3.使用工厂生产SqlSession对象
        sqlSession = factory.openSession(true);
        //4.使用 sqlSession 创建 Dao 接口的代理对象
        mapper = sqlSession.getMapper(IUserDao.class);
    }

    @After
    public void destroy() throws IOException {

        // 要记得提交事务，否者会回滚
        //sqlSession.commit();
        // 或者 factory.openSession(true);  true：自动提交事务，false：不自动提交事务会回滚


        //6. 释放资源
        sqlSession.close();
        is.close();
    }


    @Test
    public void testFindAll() throws IOException {

        //5.使用代理对象执行方法
        List<User> all = mapper.findAll();
        for (User user : all)
            System.out.println(user.toString());
        sqlSession.close();
        is.close();

    }


    @Test
    public void testSaveUser() {
        User user = new User();

        user.setUsername("mybatis  LAST_INSERT_ID");
        user.setAddress("中国-北京");
        user.setSex("男");
        user.setBirthday(new Date());

        System.out.println("保存之前："+user);
        // 提交
        mapper.saveUser(user);
        System.out.println("保存之后："+user);
    }

    @Test
    public void testUpdateUser() {
        User user = new User();

        user.setId(7);
        user.setUsername("mybatis update_test");
        user.setAddress("中国-北京");
        user.setSex("男");
        user.setBirthday(new Date());

        // 更新操作
        mapper.updateUser(user);
    }


    @Test
    public void testDeleteUser() {
        // 删除操作
        mapper.deleteUser(3);
    }

    @Test
    public void testFindById() {
        // 查询一条操作
        User byId = mapper.findById(4);
        System.out.println(byId);
    }

    @Test
    public void testFindByName() {
        // 模糊查询
         List<User> byname = mapper.findByName("mybatis%");
       // List<User> byname = mapper.findByName("mybatis");
        for (User user : byname) {
            System.out.println(user);
        }
    }

    @Test
    public void testFindTotal() {
        // 统计条数， 使用聚族函数
        int count = mapper.findTotal();
        System.out.println(count);
    }


    @Test
    public void testFindNameByVo() {
        // 使用pojo 组合多个实体类间的查询条件，模糊查询

        User user1 = new User();
        user1.setUsername("mybatis%");

        QueryVo queryVo = new QueryVo();
        queryVo.setUser(user1);

        List<User> byname = mapper.findNameByVo(queryVo);
        // List<User> byname = mapper.findByName("mybatis");
        for (User user : byname) {
            System.out.println(user);
        }
    }



    @Test
    public void testFindAll2() throws IOException {

        //5.使用代理对象执行方法
        List<User> all = mapper.findAll2();
        for (User user : all)
            System.out.println(user.toString());
        sqlSession.close();
        is.close();

    }

}
