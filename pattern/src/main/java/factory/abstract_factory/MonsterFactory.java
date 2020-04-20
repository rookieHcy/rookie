package factory.abstract_factory;

/**
 * @ClassName MonsterFactory
 * @Description 妖怪工厂
 * @Author hou
 * @Date 2020/4/20 1:03 上午
 * @Version 1.0
 **/
public class MonsterFactory implements IMonsterFactory {
    @Override
    public IBuddhism createBuddhism() {
        return new Buddhism();
    }

    @Override
    public ITaoist createTaoist() {
        return new Taoist();
    }

    @Override
    public IWild createWild() {
        return new Wild();
    }
}