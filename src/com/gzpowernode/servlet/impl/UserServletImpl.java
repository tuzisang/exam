package com.gzpowernode.servlet.impl;

import com.gzpowernode.dao.impl.UserDAOImpl;
import com.gzpowernode.pojo.User;
import com.gzpowernode.servlet.UserServlet;

/**
 * @author tzsang
 * @create 2022-04-22 11:44
 */
public class UserServletImpl implements UserServlet {
    UserDAOImpl userDAO = new UserDAOImpl();

    @Override
    public void register(User user) {
        userDAO.saveUser(user);
    }

    @Override
    public User login(String username, String password) {
        return userDAO.queryUserByUsernameAndPwd(username, password);
    }

    @Override
    public boolean existsUsername(String username) {
        if (userDAO.queryUserByUsername(username) == null){
            return false;
        }else {
            return true;
        }
    }
}
