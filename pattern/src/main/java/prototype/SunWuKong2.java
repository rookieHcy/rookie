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
public class SunWuKong2 implements Cloneable{

    private String type = "石猴";
    private String gender = "公";
    private Weapon jinGuBang = new Weapon();

    @Override
    public SunWuKong2 clone() throws CloneNotSupportedException {
        return (SunWuKong2) super.clone();
    }
}