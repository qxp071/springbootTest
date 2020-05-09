package cn.example.mp.test.filter;

import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @author: xianpei.qin
 * @create: 2020-03-28 15:12
 **/
@Order(1)
@WebFilter(urlPatterns = "/*",filterName = "ZLoginFilter")
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        long l = System.currentTimeMillis();
        System.out.println("登录过滤开始");

        filterChain.doFilter(servletRequest,servletResponse);

        System.out.println("登录过滤通过");


    }

    @Override
    public void destroy() {

    }
}