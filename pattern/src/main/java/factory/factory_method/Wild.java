package factory.factory_method;

/**
 * @ClassName Wild
 * @Description 野生实例
 * @Author hou
 * @Date 2020/4/20 12:45 上午
 * @Version 1.0
 **/
public class Wild implements IMonster {
    @Override
    public void eatTangSeng() {
        System.out.println("我是没有后台的白骨精，我想吃唐僧肉");
    }
}