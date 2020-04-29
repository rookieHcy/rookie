package prototype;

/**
 * @InterfaceName IPrototype
 * @Description 原型模式接口
 * @Author hou
 * @Date 2020/4/21 10:16 下午
 * @Version 1.0
 **/
public interface IPrototype<T> {
     T clone();
}
