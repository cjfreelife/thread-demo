package org.cj3.old;

public class DataServer {

    public boolean getData(String filePath) {
        new Thread(() -> {
            System.out.println("开始处理数据" + filePath);
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("数据处理完成" + filePath);
        }).start();
        return true;
    }
}
