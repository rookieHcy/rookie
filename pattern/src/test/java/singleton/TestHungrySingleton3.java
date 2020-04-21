package singleton;

import org.junit.jupiter.api.Test;
import singleton.hungry_singleton.HungrySingleton2;
import singleton.hungry_singleton.HungrySingleton3;

import java.io.*;
import java.lang.reflect.Constructor;

/**
 * @ClassName TestHungrySingleton2
 * @Description TODO
 * @Author hou
 * @Date 2020/4/20 12:57 下午
 * @Version 1.0
 **/
public class TestHungrySingleton3 {

    @Test
    public void testSerializable() throws IOException, ClassNotFoundException {
        HungrySingleton3 hungrySingleton3 = HungrySingleton3.getInstance();
        System.out.println(hungrySingleton3);

        String path = "./hungrySingleton3.obj";
        // 序列化
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(new File(path)));
        objectOutputStream.writeObject(hungrySingleton3);

        // 反序列化
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(new File(path)));
        HungrySingleton3 o = (HungrySingleton3)objectInputStream.readObject();

        System.out.println(o);
    }

}