package prototype;

import lombok.Data;

/**
 * @ClassName SunWuKong
 * @Description 孙悟空
 * @Author hou
 * @Date 2020/4/21 5:24 下午
 * @Version 1.0
 **/
@Data
public class SunWuKong implements IPrototype<SunWuKong>{

    private String type = "石猴";
    private String gender = "公";
    private Weapon jinGuBang = new Weapon();

    @Override
    public SunWuKong clone() {
        SunWuKong sunWuKong = new SunWuKong();
        sunWuKong.setGender(this.gender);
        sunWuKong.setType(this.type);
        sunWuKong.setJinGuBang(this.jinGuBang);
        return sunWuKong;
    }
}