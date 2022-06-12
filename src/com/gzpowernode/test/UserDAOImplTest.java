package com.gzpowernode.test;

import com.gzpowernode.dao.impl.UserDAOImpl;
import com.gzpowernode.pojo.User;
import org.junit.Test;

/**
 * @author tzsang
 * @create 2022-04-22 9:29
 */
public class UserDAOImplTest {
    UserDAOImpl userDAO = new UserDAOImpl();

    @Test
    public void testQueryUserByUsername(){
        User admin = userDAO.queryUserByUsername("admin");
        System.out.println(admin);
    }

    @Test
    public void testQueryUserByUsernameAndPwd(){
        User admin = userDAO.queryUserByUsernameAndPwd("admin4", "admin4");
        System.out.println(admin);
    }

    @Test
    public void testSaveUser(){
        int count = userDAO.saveUser(new User(0, "admin5", "管理员5号", "admin5", "保密"));
        System.out.println("影响行数: " + count);
    }
}
