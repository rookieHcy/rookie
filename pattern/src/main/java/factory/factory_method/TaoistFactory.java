package factory.factory_method;

/**
 * @ClassName TaoistFactory
 * @Description 后台为"道家"的工厂
 * @Author hou
 * @Date 2020/4/19 11:47 下午
 * @Version 1.0
 **/
public class TaoistFactory extends MonsterFactory{

    @Override
    public IMonster create() {
        return new Taoist();
    }
}