package factory;

import factory.simple_factory.IMonster;
import factory.simple_factory.MonsterFactory;
import org.junit.jupiter.api.Test;

/**
 * @ClassName TestSimpleFactory
 * @Description TODO
 * @Author hou
 * @Date 2020/4/19 10:21 下午
 * @Version 1.0
 **/
public class TestSimpleFactory {

    MonsterFactory factory = new MonsterFactory();

    /**
     * 测试白骨精
     */
    @Test
    public void testBaiGuJing(){
        IMonster baigujing = factory.create("baigujing");
        baigujing.eatTangSeng();
    }

    /**
     * 测试大鹏鸟
     */
    @Test
    public void testDaPengNiao(){
        IMonster dapengniao = factory.create("dapengniao");
        dapengniao.eatTangSeng();
    }

    /**
     * 测试红孩儿
     */
    @Test
    public void testHonhHaiEr(){
        IMonster honghaier = factory.create("honghaier");
        honghaier.eatTangSeng();
    }
}