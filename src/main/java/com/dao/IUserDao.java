package com.dao;

import com.domain.QueryVo;
import com.domain.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IUserDao {

    /*
     * 查询所有操作
     * */
   // @Select("select * from user")
    List<User> findAll();

    /*
    * 保存 USer
    * */
    void saveUser(User user);

    /*
    * 更新用户
    * */
    void updateUser(User user);

    /*
    * 删除用户
    * */
    void deleteUser(int userID);

    /*
    * 查询一个方法
    * */
    User findById(int id);

    /*
     * 模糊查询
     * */
    List<User> findByName(String name);


    /*
    * 查询总记录条数，  聚合函数
    * */
    int findTotal();

    /*
    * pojo 组合条件查询
    * */
    List<User> findNameByVo(QueryVo queryVo);


    /*
     * java实体类 和 数据库字段不一致处理
     * */
    List<User> findAll2();

}
