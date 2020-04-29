package prototype;

import org.junit.jupiter.api.Test;

import java.io.IOException;

/**
 * @ClassName TestPrototypr
 * @Description TODO
 * @Author hou
 * @Date 2020/4/21 5:40 下午
 * @Version 1.0
 **/
public class TestPrototype {

    /**
     * 测试浅克隆
     * @throws CloneNotSupportedException
     */
    @Test
    public void testPrototypre() throws CloneNotSupportedException {
        SunWuKong sunWuKong = new SunWuKong();
        SunWuKong clone = sunWuKong.clone();

        System.out.println("整体比较：");
        System.out.println(sunWuKong);
        System.out.println(clone);
        System.out.println(sunWuKong == clone);

        System.out.println("局部比较之种类：");
        System.out.println(sunWuKong.getType());
        System.out.println(clone.getType());
        System.out.println(sunWuKong.getType() == clone.getType());

        System.out.println("局部比较之性别：");
        System.out.println(sunWuKong.getGender());
        System.out.println(clone.getGender());
        System.out.println(sunWuKong.getGender() == clone.getGender());

        System.out.println("局部比较之武器：");
        System.out.println(sunWuKong.getJinGuBang());
        System.out.println(clone.getJinGuBang());
        System.out.println(sunWuKong.getJinGuBang() == clone.getJinGuBang());

    }

    /**
     * 测试Object的浅克隆
     * @throws CloneNotSupportedException
     */
    @Test
    public void testObjectClone() throws CloneNotSupportedException {
        SunWuKong2 sunWuKong = new SunWuKong2();
        SunWuKong2 clone = sunWuKong.clone();

        System.out.println("整体比较：");
        System.out.println(sunWuKong);
        System.out.println(clone);
        System.out.println(sunWuKong == clone);

        System.out.println("局部比较之种类：");
        System.out.println(sunWuKong.getType());
        System.out.println(clone.getType());
        System.out.println(sunWuKong.getType() == clone.getType());

        System.out.println("局部比较之性别：");
        System.out.println(sunWuKong.getGender());
        System.out.println(clone.getGender());
        System.out.println(sunWuKong.getGender() == clone.getGender());

        System.out.println("局部比较之武器：");
        System.out.println(sunWuKong.getJinGuBang());
        System.out.println(clone.getJinGuBang());
        System.out.println(sunWuKong.getJinGuBang() == clone.getJinGuBang());
    }

    /**
     * 测试深克隆
     * @throws CloneNotSupportedException
     */
    @Test
    public void testDeepClone() throws IOException, ClassNotFoundException {
        SunWuKong3 sunWuKong = new SunWuKong3();
        SunWuKong3 clone = sunWuKong.deepClone();

        System.out.println("整体比较：");
        System.out.println(sunWuKong);
        System.out.println(clone);
        System.out.println(sunWuKong == clone);

        System.out.println("局部比较之种类：");
        System.out.println(sunWuKong.getType());
        System.out.println(clone.getType());
        System.out.println(sunWuKong.getType() == clone.getType());

        System.out.println("局部比较之性别：");
        System.out.println(sunWuKong.getGender());
        System.out.println(clone.getGender());
        System.out.println(sunWuKong.getGender() == clone.getGender());

        System.out.println("局部比较之武器：");
        System.out.println(sunWuKong.getJinGuBang());
        System.out.println(clone.getJinGuBang());
        System.out.println(sunWuKong.getJinGuBang() == clone.getJinGuBang());
    }
}