package flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName Journey2TheWest
 * @Description TODO
 * @Author hou
 * @Date 2020/4/22 12:22 上午
 * @Version 1.0
 **/
public class Journey2TheWest {

    // 保存对象
    private Map<String, IApprentice> cacheFactory = new HashMap<>();

    // 如果缓存没有对象，此处就存起来；如果缓存有对象，此处就不进行处理
    public void apprentice(String name){
        cacheFactory.putIfAbsent(name, ApprenticeFactory.apprentice(name));
    }

    public void print(){
        cacheFactory.forEach((k, v) -> System.out.println(String.format("name: %s, desc: %s", k, v)));
        System.out.println();
    }
}