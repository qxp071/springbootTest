package cn.example.mp.test.springbeantest;

import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

/**
 * bean工厂前置处理
 *
 * @Description TODO
 * @Author xianpei.qin
 * @date 2020/08/20 16:14
 */
@Component
public class MyBeanFactoryPostProcessorT implements BeanFactoryPostProcessor {
    public MyBeanFactoryPostProcessorT() {

    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        System.out.println("调用PersonFactoryPostProcessor的postProcessBeanFactory方法");
        //从工厂中取出bean
        BeanDefinition myBean = configurableListableBeanFactory.getBeanDefinition("myBean");
        String beanClassName = myBean.getBeanClassName();
        MutablePropertyValues propertyValues = myBean.getPropertyValues();
        if(propertyValues.contains("age")){
            propertyValues.addPropertyValue("age","99");
        }

    }
}
