package com.gzpowernode.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gzpowernode.pojo.Result;
import com.gzpowernode.pojo.User;
import com.gzpowernode.servlet.impl.UserServletImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author tzsang
 * @create 2022-04-22 16:09
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    UserServletImpl userServlet = new UserServletImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        System.out.println("进入了 LoginServlet");


        String username = req.getParameter("username");
        String password = req.getParameter("password");


        User user = null;
        user = userServlet.login(username, password);

        req.setAttribute("user", user);

        //复制 requ


        Result result = null;
        if (user == null){
            result = new Result(2, "用户登录失败，用户名或密码错误");
        } else {
            result = new Result(1, "用户名登录成功。");
        }

        //转换成 json
        ObjectMapper om = new ObjectMapper();
        String json = om.writeValueAsString(result);

        //发送到浏览器
        resp.setContentType("application/json;charset=utf-8");
        PrintWriter pw = resp.getWriter();
        pw.println(json);

        //给个登录成功的记录
        req.getSession().setAttribute("login", "ok");
        resp.setContentType("text/html;charset=utf-8");
        //转发到登录成功页面
        req.getRequestDispatcher("success.html").forward(req, resp);

        System.out.println("dispatcher is ok");
        pw.flush();
        pw.close();




    }
}
