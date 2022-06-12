package com.gzpowernode.dao.impl;

import com.gzpowernode.dao.UserDAO;
import com.gzpowernode.pojo.User;

/**
 * @author tzsang
 * @create 2022-04-22 9:22
 */
public class UserDAOImpl extends  BaseDAO implements UserDAO {
    @Override
    public User queryUserByUsername(String username) {
        String sql = "select * from file where username = ?";
        return queryForOne(User.class, sql, username);
    }

    @Override
    public User queryUserByUsernameAndPwd(String username, String password) {
        String sql = "select * from  file where username = ? and pwd = md5(?)";
        return queryForOne(User.class, sql, username, password);
    }

    @Override
    public int saveUser(User user) {
        String sql = "insert into file(username, name, pwd, gender) values(?,?,md5(?),?)";
        return update(sql, user.getUsername(), user.getName(), user.getPwd(), user.getGender());
    }
}
