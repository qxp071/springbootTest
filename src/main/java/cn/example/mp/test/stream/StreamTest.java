package cn.example.mp.test.stream;

import cn.example.mp.test.entity.User;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Stream流常用API的测试
 * @Description: TODO
 * @Author: xianpei.qin
 * @Date: 2020/7/6 10:03
 **/
@Test
public class StreamTest {

    /**
     * Stream流for循环
     */
    public void testForEach(){
        List<String> list = Arrays.asList("what","are","you", "talking", "about");

        list.stream().forEach(item-> System.out.println(item));

        list.stream().forEach(System.out::println);

    }

    public void testFilte(){
        List<User> userList = Arrays.asList(new User(1,"张三","123"),
                new User(1,"李四","123"),
                new User(2,"王五","123"),
                new User(3,"赵六","123"),
                new User(4,"徐小二","123"));
        //取集合中对象的某个字段，返回新的list
        List<String> collect = userList.stream().map(User::getUserName).collect(Collectors.toList());
        collect.stream().forEach(System.out::println);

    }

}
