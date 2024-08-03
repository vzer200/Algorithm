package DemoTest;

public class SingletonDoubleLock {
    private SingletonDoubleLock(){
    }

    private static volatile SingletonDoubleLock instance = new SingletonDoubleLock();

    public static SingletonDoubleLock getInstance(){
        if (instance==null){
            synchronized (SingletonDoubleLock.class){
                if (instance==null){
                     instance = new SingletonDoubleLock();
                }
            }
        }
        return instance;
    }


}
