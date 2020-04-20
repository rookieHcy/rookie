package factory.factory_method;


/**
 * @ClassName Taoist
 * @Description TODO
 * @Author hou
 * @Date 2020/4/20 12:34 上午
 * @Version 1.0
 **/
public class Taoist implements IMonster {
    @Override
    public void eatTangSeng() {
        System.out.println("我的后台是道家中人，我是金角大王，太上老君门下看守金炉的童子。");
        System.out.println("我的后台是道家中人，我是银角大王，太上老君门下看守银炉的童子。");
        System.out.println("我们要吃唐僧肉。");
    }
}
