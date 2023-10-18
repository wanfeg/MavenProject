package com.example.mavenproject.config;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;


/**
 * @author :Aurora
 * @version:
 * @date : 2023/8/11 14:27
 * @desc:
 */
public class MyFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        ServletContext servletContext = filterConfig.getServletContext();
        try {
            Class<?> clazz = Class.forName("com.example.mavenproject.config.MyFilter");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }

}
