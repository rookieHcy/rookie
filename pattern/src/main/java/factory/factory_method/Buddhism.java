package factory.factory_method;

import factory.abstract_factory.IBuddhism;

/**
 * @ClassName Buddhism
 * @Description TODO
 * @Author hou
 * @Date 2020/4/20 12:31 上午
 * @Version 1.0
 **/
public class Buddhism implements IMonster {
    @Override
    public void eatTangSeng() {
        System.out.println("我的后台是佛教中人，我是佛祖的亲戚金翅大鹏鸟。");
        System.out.println("我的后台是佛教中人，我是文殊菩萨的坐骑青毛狮子。");
        System.out.println("我的后台是佛教中人，我是普贤菩萨的坐骑六牙白象。");
        System.out.println("我们要吃唐僧肉。");
    }
}