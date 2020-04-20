package factory.factory_method;

/**
 * @ClassName WildFactory
 * @Description 野生工厂
 * @Author hou
 * @Date 2020/4/20 12:45 上午
 * @Version 1.0
 **/
public class WildFactory extends MonsterFactory{
    @Override
    public IMonster create() {
        return new Wild();
    }
}