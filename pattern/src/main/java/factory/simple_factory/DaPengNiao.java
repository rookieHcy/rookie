package factory.simple_factory;

/**
 * @ClassName DaPengNiao
 * @Description 大鹏鸟
 * @Author hou
 * @Date 2020/4/19 10:12 下午
 * @Version 1.0
 **/
public class DaPengNiao implements IMonster{
    @Override
    public void eatTangSeng() {
        System.out.println("我是大鹏鸟，我要吃唐僧肉");
    }
}