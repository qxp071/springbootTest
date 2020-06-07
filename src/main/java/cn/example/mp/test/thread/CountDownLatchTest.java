package cn.example.mp.test.thread;

import java.util.concurrent.CountDownLatch;

/**
 * 测试CountDownLatch
 * @Description: TODO
 * @Author: xianpei.qin
 * @Date: 2020/5/27 10:18
 **/
public class CountDownLatchTest {

    public static void main(String[] args) throws InterruptedException {

        CountDownLatch latch = new CountDownLatch(2);

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程1启动");
                latch.countDown();
                System.out.println("线程1结束");

            }
        });
        t1.start();

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程2启动");
                latch.countDown();
                System.out.println("线程2结束");
            }
        });
        t2.start();
        latch.await();
        System.out.println("全部子线程完成,主线程启动");

    }

}
