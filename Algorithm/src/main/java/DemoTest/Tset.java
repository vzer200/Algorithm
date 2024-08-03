package DemoTest;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Tset {

    public static void main(String[] args) throws Throwable {

        // 使⽤反射破坏单例
        // 获取空参构造⽅法
        Constructor<Singleton> declaredConstructor =
                Singleton.class.getDeclaredConstructor(null);
        // 设置强制访问
        declaredConstructor.setAccessible(true);
        // 创建实例
        Singleton singleton =
                declaredConstructor.newInstance();

        System.out.println("反射创建的实例" + singleton);
        System.out.println("正常创建的实例" +
                Singleton.getInstance());
        System.out.println("正常创建的实例" +
                Singleton.getInstance());


        for (int i = 0; i < 3; i++) {
            new Thread(()->{
                System.out.println("双重判定多线程创建："+SingletonDoubleLock.getInstance());
            }).start();

        }
        for (int i = 0; i < 3; i++) {
            new Thread(()->{
                System.out.println("懒加载多线程创建："+SingletonLazy.getInstance());
            }).start();

        }



    }


}
