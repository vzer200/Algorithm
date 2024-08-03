package DemoTest;

public class SingletonLazy {
     private SingletonLazy(){

     }
    private static SingletonLazy instance ;

     //懒汉式，加上synchronized实现线程安全
     public static  SingletonLazy getInstance(){
         if (instance==null){
            instance = new SingletonLazy();
         }
         return instance;
     }

}
