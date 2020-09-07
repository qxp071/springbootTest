package cn.example.mp.test.web.controller;


import cn.example.mp.test.annotation.MyInterceptAnno;
import cn.example.mp.test.common.ResultBody;
import cn.example.mp.test.web.entity.User;
import cn.example.mp.test.kafka.KafkaProducer;
import cn.example.mp.test.web.mapper.UserMapper;
import cn.example.mp.test.redis.JedisUtil;
import cn.example.mp.test.web.service.impl.UserServiceImpl;
import com.baomidou.mybatisplus.annotation.TableId;
import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import redis.clients.jedis.Jedis;

import javax.validation.Valid;
import java.lang.reflect.Field;
import java.util.List;

/**
 * @Description: TODO
 * @Author: xianpei.qin 
 * @Date: 2020/4/28 17:40
 */
@RestController
@RequestMapping("/user")
//@Transactional(propagation = Propagation.NOT_SUPPORTED,rollbackFor =Exception.class )
public class UserController {

    @Autowired(required = false)
    private KafkaProducer kafkaProducer;

    @Autowired
    private UserServiceImpl userService;

    private UserMapper userMapper;


    @Autowired
    private ApplicationContext applicationContext;

    @GetMapping("/getList")
    @ResponseBody
    @MyInterceptAnno
    public ResultBody getUserList(String a) throws IllegalAccessException {
        List<User> list = null;
        try {
            list = userService.list();
            int count = userService.count();

            User user = list.get(0);
            Class<? extends User> aClass = user.getClass();

            Field[] fields = aClass.getFields();

            Field[] declaredFields = aClass.getDeclaredFields();

            for (User user1 : list) {
                for (Field field : declaredFields) {
                    TableId annotation = field.getAnnotation(TableId.class);
                    field.setAccessible(true);
                    //暴力访问私有属性，默认为false，不可访问私有属性
                    field.setAccessible(true);
                    if(null!=annotation){
                        String name = field.getName();
                        System.out.println(name);
                        System.out.println(field.get(user1));
                        System.out.println("----------");
                    }
                }

            }
            System.out.println("目标方法count="+count);
        }catch (Exception e){
            System.out.println(e.toString());
        }
        return ResultBody.success(list);
    }

    @GetMapping("/getHolle")
    @ResponseBody
    public String getHolleKit( ){

        kafkaProducer.sendMsg("hellohellohellohe");

        return "hello";
    }

    @GetMapping("getUserTest")
    @ResponseBody
    private User getUserTest(){

        String userName = JedisUtil.get("userName");
        Jedis jedis = JedisUtil.getJedis();
        System.out.println(userName);

        User user = new User();
        user.setUserName(userName);

        return user;
    }

    @PostMapping("saveUser")
    @ResponseBody
    private void saveUser(@Valid User user){

        System.out.println("user="+user);
    }

    /**
     * 本例模拟：在C方法中调用AB方法，C方法若发生异常，A方法提交，B方法回滚。
     *
     * 知识重点：事务的传播属性。调用本类方法时，需要注意事务的自身调用问题，
     * 所谓自调用，就是一个类中的一个方法，调用本类的另外一个方法。
     *
     * 问题原因：事务自己调用问题产生的原因是事务的相关操作都在代理类上完成，调用本类方法不走代理类处理。走this。
     * 所以方法上的事务注解自然不起作用。
     *
     * 解决方法：解决思路是通过代理类来调用方法。
     * 方法一：通过自己注入自己，调用相应的方法，比如此例，可注入UserController,使用注入的实例调用方法。
     *
     * 方法二：通过注入ApplicationContext实例获取UserController实例,
     * ((UserController)applicationContext.getBean("UserController"))
     *
     * 方法三：即下面使用的方法，通过AopContext.currentProxy()获取当前类的代理类对象实例进行方法调用。使用这个方法要在启动类添加
     * @EnableAspectJAutoProxy(exposeProxy = true)注解
     * @param user
     */
    @PostMapping("TranUser")
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public void testTransaction(@Valid User user){

        //解决自身调用问题，通过AopContext获取当前类的代理类，才能为自己类内的方法打上事务注解，才能使事务生效
        /*((UserController)AopContext.currentProxy()).insertUser(user);
        ((UserController)AopContext.currentProxy()).deleteUser(user);
         int a = 1/0;
        */
        ((UserController)AopContext.currentProxy()).process(user);

    }

    /**
     * 发生异常时，insert提交，delete回滚
     * @param user
     */
    private void process(User user) {
        //插入提交
        ((UserController)AopContext.currentProxy()).insertUser(user);
        //删除回滚
        ((UserController)AopContext.currentProxy()).deleteUser(user);
        //模拟异常
        int a = 1/0;

    }

    //@Transactional(propagation = Propagation.SUPPORTS)
    public void deleteUser(User user) {
        userService.removeById(4);
    }

    /**
     * 不支持当前事务，如果当前存在事务，则把当前事务挂起。
     * @param user
     */
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void insertUser(User user) {
        userService.save(user);
    }




}

