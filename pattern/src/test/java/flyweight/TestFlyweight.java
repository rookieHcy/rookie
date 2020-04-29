package flyweight;

import org.junit.jupiter.api.Test;

/**
 * @ClassName TestFlyweight
 * @Description TODO
 * @Author hou
 * @Date 2020/4/22 12:19 上午
 * @Version 1.0
 **/
public class TestFlyweight {

    /**
     * 测试享元模式
     */
    @Test
    public void testFlyweight(){
        Journey2TheWest xiyouji = new Journey2TheWest();
        System.out.println("心猿归正　六贼无踪");
        xiyouji.apprentice("孙悟空");
        xiyouji.print();
        System.out.println("云栈洞悟空收八戒　浮屠山玄奘受心经");
        xiyouji.apprentice("猪悟能");
        xiyouji.print();
        System.out.println("八戒大战流沙河　木叉奉法收悟净");
        xiyouji.apprentice("沙悟净");
        xiyouji.print();
        System.out.println("尸魔三戏唐三藏　圣僧恨逐美猴王");
        System.out.println("猪八戒义激猴王　孙行者智降妖怪");
        xiyouji.apprentice("孙悟空");
        xiyouji.print();
    }
}