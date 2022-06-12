package com.gzpowernode.controller;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

@WebServlet("/validateCodeServlet")
public class ValidateCodeServlet extends HttpServlet {
    private int width = 100;

    private int height = 35;

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.创建一个内存映像，设置宽度和高度以及颜色模式
        BufferedImage image = new BufferedImage(this.width, this.height, BufferedImage.TYPE_INT_RGB);

        //2.获取画笔
        Graphics g = image.getGraphics();

        //3.设置画笔的颜色为随机颜色
        Random r = new Random();
        g.setColor(new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255)));

        //4.开始绘画背景
        g.fillRect(0, 0, this.width, this.height);

        //5.设置画笔颜色
        g.setColor(new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255)));

        //6.设置字体样式
        g.setFont(new Font(null,  Font.ITALIC,35));

        //7.获取一个随机的验证码
        String code = this.getCode(4);

        //将验证码放入session
        request.getSession().setAttribute("code",code);


        //8.绘画验证码
        g.drawString(code,5,30);
        response.setContentType("image/jpeg");

        ServletOutputStream os = response.getOutputStream();

        ImageIO.write(image, "jpeg", os);
    }


    private String getCode(int size) {
        String codePool = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

        StringBuilder code = new StringBuilder();

        Random r = new Random();

        for (int i = 0; i < size; i++) {
            code.append(codePool.charAt(r.nextInt(codePool.length())));
        }
        return code.toString();
    }
}
