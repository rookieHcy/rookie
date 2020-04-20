package singleton.lazy_singleton;

/**
 * @ClassName LazySingleton
 * @Description 懒汉式单例
 * @Author hou
 * @Date 2020/4/20 1:05 下午
 * @Version 1.0
 **/
public class LazySingleton {

    private static LazySingleton INSTANCE = null;

    //  构造方法私有
    private LazySingleton() {
    }

    // 提供一个全局访问点
    public static LazySingleton getInstance() {
        if (null == INSTANCE) {
            INSTANCE = new LazySingleton();
        }
        return INSTANCE;
    }
}