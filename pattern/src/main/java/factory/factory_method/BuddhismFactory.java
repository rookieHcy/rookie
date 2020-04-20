package factory.factory_method;


/**
 * @ClassName BuddhismFactory
 * @Description 后台为"佛教"的工厂
 * @Author hou
 * @Date 2020/4/19 11:47 下午
 * @Version 1.0
 **/
public class BuddhismFactory extends MonsterFactory{

    @Override
    public IMonster create() {
        return new Buddhism();
    }
}