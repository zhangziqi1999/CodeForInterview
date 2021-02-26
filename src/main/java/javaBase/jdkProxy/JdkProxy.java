package javaBase.jdkProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

interface DoSomething {
    void doing();
}

class WorkerInvocationHandler implements InvocationHandler{
    Worker2 worker;

    public WorkerInvocationHandler(Worker2 worker) {
        this.worker = worker;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        long start = System.currentTimeMillis();
        Object returnValue = method.invoke(worker);
        long end = System.currentTimeMillis();
        System.out.println("work time = " + (end - start));
        return returnValue;
    }
}

public class JdkProxy {
    public static void main(String[] args) {
        Worker2 worker = new Worker2();
        DoSomething doSomething = (DoSomething) Proxy.newProxyInstance(JdkProxy.class.getClassLoader(), Worker2.class.getInterfaces(), new WorkerInvocationHandler(worker));
        doSomething.doing();
    }
}
