package singleton.lazy_singleton;

/**
 * @ClassName LockLazySingleton
 * @Description 同步方法懒汉式单例
 * @Author hou
 * @Date 2020/4/20 1:05 下午
 * @Version 1.0
 **/
public class LockMethodLazySingleton {

    private static LockMethodLazySingleton INSTANCE = null;

    //  构造方法私有
    private LockMethodLazySingleton() {
    }

    // 提供一个全局访问点
    public synchronized static LockMethodLazySingleton getInstance() {
        if (null == INSTANCE) {
            INSTANCE = new LockMethodLazySingleton();
        }
        return INSTANCE;
    }
}