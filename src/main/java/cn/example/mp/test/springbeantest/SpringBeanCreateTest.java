package cn.example.mp.test.springbeantest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description TODO
 * @Author xianpei.qin
 * @date 2020/08/20 10:39
 */
@Configuration
public class SpringBeanCreateTest {

    /**
     * 使用@Bean 注解表明myBean需要交给Spring进行管理
     * 测试观察SpringBean的生命周期，创建过程
     * @return
     */
    @Bean(initMethod = "init")
    public MyBean myBean(){
        return new MyBean();
    }


}
