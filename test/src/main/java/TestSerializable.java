import lombok.Data;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName TestSerializable
 * @Description TODO
 * @Author hou
 * @Date 2020/5/5 12:10 上午
 * @Version 1.0
 **/
public class TestSerializable implements Serializable {

    // 测试未实现接口的序列化，内部类和外部类均需要实现序列化接口
    @Test
    public void testNotSerializableException() throws Exception {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("classpath:testDemo.txt"));
        objectOutputStream.writeObject(new TestDemo("houcy7", 26, new String[]{"吃", "喝", "玩", "乐"}));
    } /*
    java.io.NotSerializableException: TestSerializable$TestDemo

	at java.io.ObjectOutputStream.writeObject0(ObjectOutputStream.java:1184)
	at java.io.ObjectOutputStream.writeObject(ObjectOutputStream.java:348)
	at TestSerializable.testSerializable(TestSerializable.java:23)
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:498)...
    */


    // 测试序列化
    @Test
    public void testSerializable() throws Exception {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("testDemo.txt"));
        objectOutputStream.writeObject(new TestDemo("houcy7", 26, new String[]{"吃", "喝", "玩", "乐"}));
    } // 序列化成功


    // 测试序列化和反序列化 此时在构造方法中添加一句输出 反序列化中构造方法只会执行一次
    @Test
    public void testSerializable2() throws Exception {
        String path = "testDemo2.txt";
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(path));
        objectOutputStream.writeObject(new TestDemo("houcy7", 26, new String[]{"吃", "喝", "玩", "乐"}));
        System.out.println("序列化成功");

        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(path));
        // 强制类型转换
        TestDemo testDemo = (TestDemo) objectInputStream.readObject();
        System.out.println(testDemo);
    } /*
        Constructor is invoked
        序列化成功
        TestSerializable.TestDemo(name=houcy7, age=26, hobbies=[吃, 喝, 玩, 乐])
    */

    // 测试transient 复制所有的属性 并声明为transient
    // 使用transient修饰的属性，java序列化时，会忽略掉此字段，所以反序列化出的对象，被transient修饰的属性是默认值。对于引用类型，值是null；基本类型，值是0；boolean类型，值是false。
    @Test
    public void testTransient() throws Exception {
        String path = "testDemo3.txt";
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(path));
        TestDemo testDemo1 = new TestDemo("houcy7", 26, new String[]{"吃", "喝", "玩", "乐"});
        System.out.println("testDemo: " + testDemo1);
        objectOutputStream.writeObject(testDemo1);
        System.out.println("序列化成功");

        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(path));
        // 强制类型转换
        TestDemo testDemo2 = (TestDemo) objectInputStream.readObject();
        System.out.println(testDemo2);
    } /*
        Constructor is invoked
        testDemo: TestSerializable.TestDemo(name=houcy7, age=26, hobbies=[吃, 喝, 玩, 乐], transientName=houcy7, transientAge=26, transientHobbies=[吃, 喝, 玩, 乐])
        序列化成功
        TestSerializable.TestDemo(name=houcy7, age=26, hobbies=[吃, 喝, 玩, 乐], transientName=null, transientAge=0, transientHobbies=null)
    */

    // 添加一个版本号 当没有主动声明的时候 会分配一个默认的
    @Test
    public void testSerialVersionUID() throws Exception {
        // 将上一个测试方法中的序列化文件反序列化
        String path = "testDemo3.txt";
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(path));
        // 强制类型转换
        TestDemo testDemo2 = (TestDemo) objectInputStream.readObject();
        System.out.println(testDemo2);
    } /*
        java.io.InvalidClassException: TestSerializable$TestDemo; local class incompatible: stream classdesc serialVersionUID = -7878447699412256872, local class serialVersionUID = 1

            at java.io.ObjectStreamClass.initNonProxy(ObjectStreamClass.java:699)
            at java.io.ObjectInputStream.readNonProxyDesc(ObjectInputStream.java:1885)
            at java.io.ObjectInputStream.readClassDesc(ObjectInputStream.java:1751)
            at java.io.ObjectInputStream.readOrdinaryObject(ObjectInputStream.java:2042)
            at java.io.ObjectInputStream.readObject0(ObjectInputStream.java:1573)
            at java.io.ObjectInputStream.readObject(ObjectInputStream.java:431)
    */

    // 序列化对象
    @Data
    private class TestDemo implements Serializable {

        private final static long serialVersionUID = 1L;

        public String name;
        private int age;
        private List<String> hobbies;
        transient public String transientName;
        transient private int transientAge;
        transient private List<String> transientHobbies;

        public TestDemo(String name, int age, String[] hobbies) {
            this.name = name;
            this.age = age;
            this.hobbies = Arrays.asList(hobbies);
            this.transientName = name;
            this.transientAge = age;
            this.transientHobbies = this.hobbies;
            System.out.println("Constructor is invoked");
        }
    }
}