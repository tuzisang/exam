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
 * @create 2022-04-22 15:48
 */
@WebServlet("/saveUser")
public class SaveUserServlet extends HttpServlet {
    UserServletImpl userServlet = new UserServletImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("进入了saveUser");

        String username = req.getParameter("username");
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        String gender = req.getParameter("gender");

        userServlet.register(new User(0, username, name, password, gender));

        Result result = new Result(1, "注册成功");

        //转换成 json
        ObjectMapper om = new ObjectMapper();
        String json = om.writeValueAsString(result);

        //发送到浏览器
        resp.setContentType("application/json;charset=utf-8");
        PrintWriter pw = resp.getWriter();
        pw.println(json);
        pw.flush();
        pw.close();

        // 跳转到登录页面 ，但是不能用，因为 PintWriter会把 resp 给清空
        // 所以，我在前端解决了这个问题
        resp.sendRedirect("http://localhost:8080/exam/login.html");
    }
}
