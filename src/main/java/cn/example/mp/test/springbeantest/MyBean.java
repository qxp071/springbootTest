package cn.example.mp.test.springbeantest;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import javax.annotation.PostConstruct;

/**
 * @Description 测试SpringBean创建过程用例
 * @Author xianpei.qin
 * @date 2020/08/20 10:44
 */
public class MyBean implements BeanNameAware , BeanFactoryAware,
        ApplicationContextAware,
        InitializingBean, DisposableBean {

    private String name;

    private String age;

    public MyBean( ) {
        System.out.println("无参构造方法");
    }

    public String getName() {
        System.out.println("Get方法");
        return name;
    }

    public void setName(String name) {
        System.out.println("Set方法");
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    /**
     * 实现BeanNameAware接口
     * @param s
     */
    @Override
    public void setBeanName(String s) {
        System.out.println("实现BeanNameAware接口，setBeanName方法执行----"+s);
    }

    /**
     * 实现BeanFactoryAware接口
     * @param beanFactory
     * @throws BeansException
     */
    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("实现BeanFactoryAware接口，setBeanFactory方法执行----");
    }

    /**
     * 实现ApplicationContextAware接口
     * @param applicationContext
     * @throws BeansException
     */
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("实现ApplicationContextAware接口，setApplicationContext方法执行----");
    }
    /**
     * 实现InitializingBean接口,可在此方法给bean一些初始化之前的操作。
     * 如下，name=张三。bean创建出来就存在name=张三的属性。
     * @throws Exception
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("实现InitializingBean接口,afterPropertiesSet方法执行");
        this.name = "张三";


    }

    public void  init(){
        System.out.println("调用init初始化方法执行。");
    }

    /**
     * 实现 DisposableBean 接口,
     * @throws Exception
     */
    @Override
    public void destroy() throws Exception {
        System.out.println("实现DisposableBean接口,容器关闭调用destroy方法");

    }

    @Override
    public String toString() {
        return "MyBean{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
