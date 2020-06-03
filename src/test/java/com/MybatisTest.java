package com;


import com.dao.IUserDao;
import com.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author: c
 * @date: 2019/12/21
 */
public class MybatisTest {

    /*
     *  mybatis 入门案例，测试
     * */

    @Test
    public void test() throws IOException {
        //1.读取xml配置文件
        InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.创建 SqlSessionFactory 工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(is); // SqlSessionFactory是接口不能直接使用
        //3.使用工厂生产SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //4.使用 sqlSession 创建 Dao 接口的代理对象
        IUserDao mapper = sqlSession.getMapper(IUserDao.class);
        //5.使用代理对象执行方法
        List<User> all = mapper.findAll();
        for (User user : all)
            System.out.println(user.toString());
        sqlSession.close();
        is.close();

    }

}
