package com.dao.impl;

import com.dao.IUserDao;
import com.domain.User;
import com.mysql.cj.Session;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

/**
 * @author: c
 * @date: 2020/6/4
 *
 * mybatis dao实现类实例, 要配合 IUserDao.xml定义
 *
 */
public class IUserDaoImpl implements IUserDao {

    private SqlSessionFactory factory;

    public IUserDaoImpl(SqlSessionFactory factory) {
        this.factory = factory;
    }

    public List<User> findAll() {
        // 1.通过工厂，来获取 SqlSession 对象
        SqlSession sqlSession = factory.openSession();

        // 2.执行查询
        // 名称空间 + id 定位SQL语句
        List<User> objects = sqlSession.selectList("com.dao.IUserDao.findAll");

        // 3.关闭
        sqlSession.close();

        return objects;
    }
}
