package com.gzpowernode.dao;

import com.gzpowernode.pojo.User;

/**
 * @author tzsang
 * @create 2022-04-22 9:17
 */
public interface UserDAO {

    /**
     * 根据用户名查询用户信息
     * @param username 用户名
     * @return 如果返回为 null, 说明用户不存在，反之亦然
     */
    public User queryUserByUsername(String username);

    /**
     * 根据用户名和密码查询用户信息
     * @param username 用户名
     * @param password 用户密码
     * @return 如果返回为 null, 说明用户不存在，反之亦然
     */
    public User queryUserByUsernameAndPwd(String username, String password);

    /**
     * 保存用户信息
     * @param user 用户信息
     * @return 返回 -1，说明数据库报错。 除了 -1，则是数据库影响的行数
     */
    public int saveUser(User user);
}
