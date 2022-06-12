package com.gzpowernode.test;

import com.gzpowernode.pojo.User;
import com.gzpowernode.servlet.impl.UserServletImpl;
import org.junit.Test;

/**
 * @author tzsang
 * @create 2022-04-22 11:51
 */
public class UserServletImplTest {
    UserServletImpl userServlet = new UserServletImpl();
    @Test
    public void testLogin(){
        User user = userServlet.login("admin", "admin");
        System.out.println(user);

    }

    @Test
    public void testRegister(){
        User user = new User(0, "admin3", "管理员3号", "admin3", "保密");
        if(!userServlet.existsUsername(user.getUsername())){
            userServlet.register(user);
        }
    }
}
