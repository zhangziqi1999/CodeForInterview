package javaBase;

public class Singleton {
    private static volatile Singleton SINGLETON = null;

    public static Singleton get(){
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
