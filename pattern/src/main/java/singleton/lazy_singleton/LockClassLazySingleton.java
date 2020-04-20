package singleton.lazy_singleton;

/**
 * @ClassName LockClassLazySingleton
 * @Description 同步代码块懒汉式单例
 * @Author hou
 * @Date 2020/4/20 1:05 下午
 * @Version 1.0
 **/
public class LockClassLazySingleton {

    private static LockClassLazySingleton INSTANCE = null;

    //  构造方法私有
    private LockClassLazySingleton() {
    }

    // 提供一个全局访问点
    public static LockClassLazySingleton getInstance() {
        if (null == INSTANCE) {
            synchronized (LockClassLazySingleton.class) {
                INSTANCE = new LockClassLazySingleton();
            }
        }
        return INSTANCE;
    }
}