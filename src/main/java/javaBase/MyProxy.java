package javaBase;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Random;

interface DoSomething {
    void doing();
}

class Worker implements DoSomething {
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

class WorkerInvocationHandler implements InvocationHandler{
    Worker worker;

    public WorkerInvocationHandler(Worker worker) {
        this.worker = worker;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        long start = System.currentTimeMillis();
        Object object = method.invoke(worker);
        long end = System.currentTimeMillis();
        System.out.println("work time = " + (end - start));
        return object;
    }
}

public class MyProxy {
    public static void main(String[] args) {
        Worker worker = new Worker();
        DoSomething doSomething = (DoSomething) Proxy.newProxyInstance(MyProxy.class.getClassLoader(), Worker.class.getInterfaces(), new WorkerInvocationHandler(worker));
        doSomething.doing();
    }
}
