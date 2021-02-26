package javaBase.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import java.lang.reflect.Method;

class ProxyFactory implements MethodInterceptor {
    private final Object target;//维护一个目标对象

    public ProxyFactory(Object target) {
        this.target = target;
    }

    //为目标对象生成代理对象
    public Object getProxyInstance() {
        //工具类
        Enhancer en = new Enhancer();
        //设置父类
        en.setSuperclass(target.getClass());
        //设置回调函数
        en.setCallback(this);
        //创建子类对象代理
        return en.create();
    }

    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        long start = System.currentTimeMillis();
        // 执行目标对象的方法
        Object returnValue = method.invoke(target, args);
        long end = System.currentTimeMillis();
        System.out.println("work time = " + (end - start));
        return returnValue;
    }
}

public class Cglib {
    public static void main(String[] args) {
        Worker1 worker1 = new Worker1();
        Worker1 proxy = (Worker1) new ProxyFactory(worker1).getProxyInstance();
        proxy.doing();
    }
}
