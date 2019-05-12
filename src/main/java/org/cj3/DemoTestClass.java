package org.cj3;

import org.cj3.old.DataServer;

public class DemoTestClass {
    public static void main(String[] args) throws InterruptedException {
        DataServer dataServer = new DataServer();
        boolean flag = false;
        for (int i = 0; i < 5; i++) {
            flag = dataServer.getData("f" + i);
            while (!flag) {
                Thread.sleep(100);
            }
            flag = false;
        }

    }
}
