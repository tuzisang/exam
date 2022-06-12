package com.gzpowernode.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author tzsang
 * @create 2022-04-22 11:23
 */
@WebFilter("/success.html")
public class LoginFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;

        Object login = servletRequest.getAttribute("login");

        System.out.println("login = " + login);

        if (login != null){
            System.out.println("login = " + login.toString());
            if (login.toString().equals("ok")){
                System.out.println("session is ok!!!!!");
                filterChain.doFilter(servletRequest, httpServletResponse);
            }else {
                System.out.println("no session");
                httpServletResponse.sendRedirect("http://localhost:8080/exam/login.html");
            }
        }else {
            System.out.println("no !!!!!!!! ");
            httpServletResponse.sendRedirect("http://localhost:8080/exam/login.html");
        }
    }
}
