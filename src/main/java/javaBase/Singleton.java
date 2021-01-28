package javaBase;

public class Singleton {
    static volatile Singleton SINGLETON = null;

    static Singleton get(){
        if(SINGLETON == null){
            synchronized (Singleton.class){
                if (SINGLETON == null){
                    SINGLETON = new Singleton();
                }
            }
        }
        return SINGLETON;
    }
}
