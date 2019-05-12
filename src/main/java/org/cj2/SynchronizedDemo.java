package org.cj2;

import java.io.IOException;

/*
 *  结果应该是小于1000的一个数字
 *  synchronized锁定的是Integer对象，但是在java中对基础数据类型自动装拆箱的操作，在++操作后，count指向的位置已经是不是原来的对象了
 *  synchronized 锁住的是一个对象才能实现线程安全，当锁定不同对象时，各个对象的锁并没有互斥，所以加上synchronize并没有什么用
 *
 * */
public class SynchronizedDemo {
    static Integer count = 2000;

    public static void incr() {
        synchronized (count) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            count++;
            System.out.println(count++);
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        for (int i = 0; i < 1000; i++) {
            new Thread(() -> SynchronizedDemo.incr()).start();
        }
        Thread.sleep(5000);
        System.out.println("result:" + count);
    }
}
