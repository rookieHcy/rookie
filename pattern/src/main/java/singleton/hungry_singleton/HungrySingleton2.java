package singleton.hungry_singleton;

/**
 * @ClassName HungrySingleton
 * @Description 饿汉式单例
 * @Author hou
 * @Date 2020/4/20 12:49 下午
 * @Version 1.0
 **/
public class HungrySingleton2 {

    private static HungrySingleton2 INSTANCE = new HungrySingleton2();

    // 构造方法私有化
    private HungrySingleton2() {
        if(null != INSTANCE){
            throw new RuntimeException("单例对象已经存在，不允许再次调用构造方法");
        }
    }

    // 提供全局访问点
    public static HungrySingleton2 getInstance(){
        return INSTANCE;
    }
}


