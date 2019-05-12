package org.cj3;

public class DataHandler implements Runnable {

    @Override
    public void run() {
        System.out.println("开始处理数据" + Thread.currentThread());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
