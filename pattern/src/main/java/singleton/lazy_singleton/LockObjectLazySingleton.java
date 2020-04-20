package singleton.lazy_singleton;

/**
 * @ClassName LockObjectLazySingleton
 * @Description 同步代码块懒汉式单例
 * @Author hou
 * @Date 2020/4/20 1:05 下午
 * @Version 1.0
 **/
public class LockObjectLazySingleton {

    private static LockObjectLazySingleton INSTANCE = null;
    private static final Object lock = new Object();

    //  构造方法私有
    private LockObjectLazySingleton() {
    }

    // 提供一个全局访问点
    public static LockObjectLazySingleton getInstance() {
        if (null == INSTANCE) {
            synchronized (lock) {
                INSTANCE = new LockObjectLazySingleton();
            }
        }
        return INSTANCE;
    }
}