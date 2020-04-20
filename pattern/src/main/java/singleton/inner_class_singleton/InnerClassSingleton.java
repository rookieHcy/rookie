package singleton.inner_class_singleton;

/**
 * @ClassName InnerClassSingleton
 * @Description 内部类式单例
 * @Author hou
 * @Date 2020/4/20 4:05 下午
 * @Version 1.0
 **/
public class InnerClassSingleton {

    private static class SingletonHolder {
        private final static InnerClassSingleton SUN_WU_KONG = new InnerClassSingleton();
    }

    // 构造方法私有化
    private InnerClassSingleton() { }

    // 提供全局访问点
    public static InnerClassSingleton getInstance(){
        return SingletonHolder.SUN_WU_KONG;
    }
}