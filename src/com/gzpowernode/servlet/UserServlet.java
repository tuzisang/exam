package com.gzpowernode.servlet;

import com.gzpowernode.pojo.User;

/**
 * @author tzsang
 * @create 2022-04-22 11:42
 */
public interface UserServlet {

    /**
     * 注册用户
     */
    public void register(User user);

    /**
     * 用户登录
     * @return 返回 null,说明登录失败
     */
    public User login(String username, String password);

    /**
     * 判断用户名是否存在
     * @return 返回 false,说明用户不存在
     */
    public boolean existsUsername(String username);
}
