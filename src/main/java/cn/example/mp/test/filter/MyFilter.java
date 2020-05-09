package cn.example.mp.test.filter;

import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @author: xianpei.qin
 * @create: 2020-03-28 14:38
 **/
@Order(2)
@WebFilter(urlPatterns = "/user/*",filterName = "MyFilter")
public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {

        System.out.println("业务过滤开始");

        String localName = request.getLocalName();
        if(true){
            filterChain.doFilter(request,response);
        }
        System.out.println("业务过滤通过");
    }

    @Override
    public void destroy() {

    }
}