package singleton.hungry_singleton;

/**
 * @ClassName HungrySingleton
 * @Description 饿汉式单例
 * @Author hou
 * @Date 2020/4/20 12:49 下午
 * @Version 1.0
 **/
public class HungrySingleton {

    private static HungrySingleton INSTANCE = new HungrySingleton();

    // 构造方法私有化
    private HungrySingleton() {
    }

    // 提供全局访问点
    public static HungrySingleton getInstance(){
        return INSTANCE;
    }
}


