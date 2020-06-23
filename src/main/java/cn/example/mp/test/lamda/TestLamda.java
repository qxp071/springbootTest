package cn.example.mp.test.lamda;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

@Test
public class TestLamda {


    /**
     * 无参lamda
     */
    public void test1(){

        //jdk8以前
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("你好！");
            }
        }).start();

        //jdk8以后
        new Thread(()-> System.out.println("你好")).start();

    }


    public void test2(){
        //jdk8以前
        List<String> list = Arrays.asList("a","add","adfew","ss");
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String s, String t1) {
                if(s==null){
                    return -1;
                }
                if(t1==null){
                    return 1;
                }
                return s.length()-t1.length();
            }
        });

        //jdk8
        Collections.sort(list,(String s,String t)->{
            if(s==null){
                return -1;
            }
            if(t==null){
                return 1;
            }
            return s.length()-t.length();
        });




    }


    /**
     * 测试Stream API
     */
    public void testStream(){

        List<String> list = Arrays.asList("a","add","adfew","ss","add");
        //集合去重
        Stream<String> distinct = list.stream().distinct();
        distinct.forEach(n-> System.out.println("集合去重："+n));

        //集合循环输出
        list.stream().forEach(n-> System.out.println(n));

        //集合统计元素个数
        long count = list.stream().count();
        System.out.println(count);


    }

    public static void main(String[] args) {


    }

}
