package Factory;

import factory.factory_method.*;
import org.junit.jupiter.api.Test;

/**
 * @ClassName TestFactoryMethod
 * @Description 工厂方法测试类
 * @Author hou
 * @Date 2020/4/20 12:37 上午
 * @Version 1.0
 **/
public class TestFactoryMethod {

    /**
     * 测试后台为佛教的工厂
     */
    @Test
    public void testBuddhismFactory(){
        MonsterFactory factory = new BuddhismFactory();
        IMonster monster = factory.create();
        monster.eatTangSeng();
    }

    /**
     * 测试后台为道家的工厂
     */
    @Test
    public void testTaoistFactory(){
        MonsterFactory factory = new TaoistFactory();
        IMonster monster = factory.create();
        monster.eatTangSeng();
    }

    /**
     * 测试野生工厂
     */
    @Test
    public void testWildFactory(){
        MonsterFactory factory = new WildFactory();
        IMonster monster = factory.create();
        monster.eatTangSeng();
    }

}