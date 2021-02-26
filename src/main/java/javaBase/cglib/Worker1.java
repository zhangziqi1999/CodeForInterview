package javaBase.cglib;

import java.util.Random;

public class Worker1 {
    public void doing() {
        System.out.println("worker is working...");
        try {
            Thread.sleep(new Random().nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("work finish");
    }
}
