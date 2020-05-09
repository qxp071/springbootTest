/*

package cn.example.mp.test.config;

import cn.example.mp.test.filter.MyFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

*/
/**
 * 拦截器在以前的web项目，是通过在web.xml配置拦截。
 * 第一方法：springboot则通过以下构造完成拦截器的定义,
 * 第二方法：通过注解@WebFilter方式，同时启动类需要增加Servlet扫描注解@ServletComponentScan
 * 过滤器顺序通过@Order执行
 * @author: xianpei.qin
 * @create: 2020-03-28 14:45
 **//*


@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean registeFilter(){
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new MyFilter());
        registration.addUrlPatterns("/user/*");
        registration.setName("MyFilter");
        registration.setOrder(2);
        return registration;
    }


}
*/
