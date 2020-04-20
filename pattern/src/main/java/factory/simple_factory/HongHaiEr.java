package factory.simple_factory;

/**
 * @ClassName HongHaiEr
 * @Description 红孩儿
 * @Author hou
 * @Date 2020/4/19 10:33 下午
 * @Version 1.0
 **/
public class HongHaiEr implements IMonster{

    @Override
    public void eatTangSeng() {
        System.out.println("我是红孩儿，我要吃唐僧肉");
    }
}