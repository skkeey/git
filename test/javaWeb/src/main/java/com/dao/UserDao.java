package com.dao;

import com.entity.User;

import java.util.List;

public interface UserDao {

    /**
     * 登录
     */
    public boolean login (String name, String pwd);

    /**
     * 注册
     */
    public boolean register (User user);

    /**
     * 返回用户信息集合
     */
    public List<User> getUserAll ();

    /**
     * 根据id删除用户
     */
    public boolean delete (int id);

    /**
     * 更新用户信息
     */
    public boolean update (int id, String name, String pwd, String sex, String home, String info);
}
