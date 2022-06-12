package com.gzpowernode.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gzpowernode.pojo.Result;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/checkCode")
public class CheckCodeServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取用户输入的验证码
        String checkcode = request.getParameter("checkcode");

        //2.获取服务器生成验证码
        String code = (String) request.getSession().getAttribute("code");

        Result result = null;
        if(checkcode.equalsIgnoreCase(code)){
            result = new Result(1, "验证码正确");
        }else{
            result = new Result(2, "验证码错误");
        }

        //转换成 json
        ObjectMapper om = new ObjectMapper();
        String json = om.writeValueAsString(result);

        //发送到浏览器
        response.setContentType("application/json;charset=utf-8");
        PrintWriter pw = response.getWriter();
        pw.println(json);
        pw.flush();
        pw.close();
    }
}
