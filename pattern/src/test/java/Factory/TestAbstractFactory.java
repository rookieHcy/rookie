package Factory;

import factory.abstract_factory.MonsterFactory;
import org.junit.jupiter.api.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName TestAbstractFactory
 * @Description 测试抽象工厂模式
 * @Author hou
 * @Date 2020/4/20 1:11 上午
 * @Version 1.0
 **/
public class TestAbstractFactory {

    /**
     * 测试抽象工厂模式
     */
    @Test
    public void testMonsterFactory() {
        MonsterFactory factory = new MonsterFactory();
        factory.createBuddhism().eatTangSeng();
        factory.createTaoist().eatTangSeng();
        factory.createWild().eatTangSeng();
    }

}