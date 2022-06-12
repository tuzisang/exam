package com.gzpowernode.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gzpowernode.pojo.Result;
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
 * @create 2022-04-22 12:00
 */
@WebServlet("/existUsername")
public class ExistsUsernameServlet extends HttpServlet {
    UserServletImpl userServlet = new UserServletImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("进入了existUsernameServlet");
        String username = req.getParameter("username");

        Result result = null;
        if( !userServlet.existsUsername(username)){
            result = new Result(1,"用户名可以使用");
        }else {
            result = new Result(2, "用户名已经存在，重新输入");
        }

        //转换成 json
        ObjectMapper om = new ObjectMapper();
        String json = om.writeValueAsString(result);

        //发送到浏览器
        resp.setContentType("application/json;charset=utf-8");
        PrintWriter pw = resp.getWriter();
        pw.println(json);
        pw.flush();
        pw.close();

    }
}
