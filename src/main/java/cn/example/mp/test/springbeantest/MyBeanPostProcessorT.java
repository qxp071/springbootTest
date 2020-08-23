package cn.example.mp.test.springbeantest;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * 实现 BeanPostProcessor 接口。所有被Spring管理的bean都可以进行前置后置处理。
 * 可根据入参的bean类型取得对应要操作的bean进行前置后置处理
 *
 * @Description 观察Bean的前置后置处理调用过程
 * @Author xianpei.qin
 * @date 2020/08/20 14:15
 */
@Component
public class MyBeanPostProcessorT implements BeanPostProcessor {

    public MyBeanPostProcessorT() {
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean.getClass()==MyBean.class){
            System.out.println("生命周期的一部分,Bean初始化前置处理方法执行-----"+beanName+"----bean==="+bean.toString());
        }
        return null;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if(bean.getClass()==MyBean.class){
            System.out.println("生命周期的一部分,Bean初始化后置处理方法执行----"+beanName+"----bean==="+bean.toString());
        }
        return null;
    }
}
