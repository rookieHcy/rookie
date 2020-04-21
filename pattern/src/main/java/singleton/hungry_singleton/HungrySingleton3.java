package singleton.hungry_singleton;

import java.io.Serializable;

/**
 * @ClassName HungrySingleton3
 * @Description 饿汉式单例
 * @Author hou
 * @Date 2020/4/20 12:49 下午
 * @Version 1.0
 **/
public class HungrySingleton3 implements Serializable {

    private static HungrySingleton3 INSTANCE = new HungrySingleton3();

    // 构造方法私有化
    private HungrySingleton3() {
    }

    // 提供全局访问点
    public static HungrySingleton3 getInstance(){
        return INSTANCE;
    }

    private Object readResolve(){
        return INSTANCE;
    }
}


