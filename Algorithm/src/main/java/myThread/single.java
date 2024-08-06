package myThread;

public class single {

   //懒汉式，双重判定检查
   public static class singleton1{
      private volatile static singleton1 instance;
      private singleton1() {}
      public static singleton1 getInstance(){
         if(instance==null) {
            synchronized (singleton1.class) {
               if (instance == null) {
                  instance = new singleton1();
               }
            }
         }
         return instance;
      }
   }


   //饿汉式
   public static class singleton2{
      private singleton2() {};
      private  static final singleton2 instance = new singleton2();

      public static singleton2 getInstance(){
         return instance;
      }

   }

   //静态内部类式（实现懒加载）
   public static class singleton3{
      private singleton3(){};

      public static singleton3 getInstance(){
         return singleton.instance;
      }

      private static class singleton{
         private static final singleton3 instance = new singleton3();
      }

   }


}
