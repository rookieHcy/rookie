package factory.simple_factory;

/**
 * @ClassName BaiGuJing
 * @Description 白骨精
 * @Author hou
 * @Date 2020/4/19 10:08 下午
 * @Version 1.0
 **/
public class BaiGuJing implements IMonster{
    @Override
    public void eatTangSeng() {
        System.out.println("我是白骨精，我要吃唐僧肉");
    }
}