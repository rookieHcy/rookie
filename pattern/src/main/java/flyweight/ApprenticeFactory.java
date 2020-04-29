package flyweight;

/**
 * @ClassName ApprenticeFactory
 * @Description TODO
 * @Author hou
 * @Date 2020/4/22 12:25 上午
 * @Version 1.0
 **/
public class ApprenticeFactory {
    public static IApprentice apprentice(String name){
        if("孙悟空".equals(name)){
            return new SunWuKong();
        } else if("猪悟能".equals(name)){
            return new ZhuBaJie();
        } else if("沙悟净".equals(name)){
            return new ShaWuJing();
        }
        return null;
    }
}