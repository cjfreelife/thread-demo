package org.cj;

/* todo
 * 先输出X=1000，然后输出Main x= 2000
 * synchronized 修饰在普通方法上，并且是同一个对象对方法进行访问，
 * 首先第一个线程获取对象的锁，执行M1方法，然后执行完成，此时x为1000，打印x=1000,
 * 然后第二个线程获取对象的锁，执行M2方法，执行完成后，X=2000，
 * 最后主线程获取对象的锁，执行M2方法，执行完成后，X=2000，然后打印MainX=2000
 *
 * */
public class SynchronizedDemo implements Runnable {
    int x = 100;

    public synchronized void m1() {
        System.out.println(Thread.currentThread());
        x = 1000;
        try {
            Thread.sleep(1000);
            System.out.println(Thread.currentThread());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("x=" + x);
    }

    public synchronized void m2() {
        System.out.println(Thread.currentThread());
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread());
        x = 2000;
    }

    public static void main(String[] args) throws InterruptedException {
        SynchronizedDemo sd = new SynchronizedDemo();
        new Thread(() -> sd.m1()).start();
        new Thread(() -> sd.m2()).start();
        sd.m2();
        System.out.println("Main x=" + sd.x);
    }

    @Override
    public void run() {
        m1();
    }
}