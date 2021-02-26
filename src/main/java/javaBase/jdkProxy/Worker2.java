package javaBase.jdkProxy;

import java.util.Random;

class Worker2 implements DoSomething {
    @Override
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
