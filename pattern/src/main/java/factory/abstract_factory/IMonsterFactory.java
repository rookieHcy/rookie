package factory.abstract_factory;

/**
 * @InterfaceName IMonsterFactory
 * @Description 妖怪工厂接口
 * @Author hou
 * @Date 2020/4/20 1:03 上午
 * @Version 1.0
 **/
public interface IMonsterFactory {
    public IBuddhism createBuddhism();
    public ITaoist createTaoist();
    public IWild createWild();
}
