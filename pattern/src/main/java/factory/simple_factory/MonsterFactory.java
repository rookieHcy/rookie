package factory.simple_factory;

/**
 * @ClassName MonsterFactory
 * @Description 妖怪工厂
 * @Author hou
 * @Date 2020/4/19 10:01 下午
 * @Version 1.0
 **/
public class MonsterFactory {

    public IMonster create(String monsterName) {
        if("baigujing".equals(monsterName)){
            return new BaiGuJing();
        } else if("dapengniao".equals(monsterName)){
            return new DaPengNiao();
        } else if("honghaier".equals(monsterName)){
            return new HongHaiEr();
        }
        return null;
    }

}