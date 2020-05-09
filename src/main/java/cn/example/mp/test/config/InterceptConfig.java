package cn.example.mp.test.config;

import cn.example.mp.test.intercept.MyInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author: xianpei.qin
 * @create: 2020-03-28 15:55
 **/
@Configuration
public class InterceptConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(myInterceptor()).addPathPatterns("/**");
    }


    @Bean
    public MyInterceptor myInterceptor(){
        return new MyInterceptor();
    }


}