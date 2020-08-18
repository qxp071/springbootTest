package cn.example.mp.test.lock;

import org.openjdk.jol.info.ClassLayout;

import java.util.concurrent.locks.ReentrantLock;

public class TextClassLayout {
    public static void main(String[] args) {
        Student student = new Student();

        ReentrantLock lock = new ReentrantLock();

        try {
            lock.lock();
            System.out.println(ClassLayout.parseInstance(student).toPrintable());

        }catch (Exception e){

        }finally {
            lock.unlock();
        }

    }
}
