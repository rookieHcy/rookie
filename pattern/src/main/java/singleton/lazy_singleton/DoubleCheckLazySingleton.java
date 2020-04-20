package singleton.lazy_singleton;

/**
 * @ClassName DoubleCheckLazySingleton
 * @Description 双重校验锁懒汉式单例
 * @Author hou
 * @Date 2020/4/20 1:05 下午
 * @Version 1.0
 **/
public class DoubleCheckLazySingleton {

    private static DoubleCheckLazySingleton INSTANCE = null;

    //  构造方法私有
    private DoubleCheckLazySingleton() {
    }

    // 提供一个全局访问点
    public static DoubleCheckLazySingleton getInstance() {
        if (null == INSTANCE) {
            synchronized (DoubleCheckLazySingleton.class) {
                if (null == INSTANCE) {
                    INSTANCE = new DoubleCheckLazySingleton();
                }
            }
        }
        return INSTANCE;
    }
}