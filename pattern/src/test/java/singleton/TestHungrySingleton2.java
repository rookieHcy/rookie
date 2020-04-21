package singleton;

import org.junit.jupiter.api.Test;
import singleton.hungry_singleton.HungrySingleton;
import singleton.hungry_singleton.HungrySingleton2;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName TestHungrySingleton2
 * @Description TODO
 * @Author hou
 * @Date 2020/4/20 12:57 下午
 * @Version 1.0
 **/
public class TestHungrySingleton2 {

    /**
     * 暴力反射 破坏单例
     * @throws Exception
     */
    @Test
    public void testReflect() throws Exception {
        // 获取单例对象
        HungrySingleton2 instance = HungrySingleton2.getInstance();
        System.out.println(instance);

        // 通过反射 暴力创建一个对象
        Constructor<HungrySingleton2> constructor = HungrySingleton2.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        HungrySingleton2 hungrySingleton = constructor.newInstance();

        System.out.println(hungrySingleton);
    }

}