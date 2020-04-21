package singleton;

import org.junit.jupiter.api.Test;
import singleton.hungry_singleton.HungrySingleton;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName TestHungrySingleton
 * @Description TODO
 * @Author hou
 * @Date 2020/4/20 12:57 下午
 * @Version 1.0
 **/
public class TestHungrySingleton {

    /**
     * 测试饿汉式单例
     */
    @Test
    public void testHungrySingleton(){
        Map<HungrySingleton, Integer> map = new HashMap<>();
        for (int i = 0; i < 100; i++) {
            HungrySingleton instance = HungrySingleton.getInstance();
            map.merge(instance, 1, (o, n) -> o + 1);
        }
        map.forEach((k, v) -> System.out.println(String.format("object: %s, count: %s", k, v)));
    }

    /**
     * 暴力反射 破坏单例
     * @throws Exception
     */
    @Test
    public void testReflect() throws Exception {
        // 获取单例对象
        HungrySingleton instance = HungrySingleton.getInstance();
        System.out.println(instance);

        // 通过反射 暴力创建一个对象
        Constructor<HungrySingleton> constructor = HungrySingleton.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        HungrySingleton hungrySingleton = constructor.newInstance();

        System.out.println(hungrySingleton);
    }

}