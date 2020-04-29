package prototype;

import lombok.Data;

import java.io.*;

/**
 * @ClassName SunWuKong
 * @Description 孙悟空
 * @Author hou
 * @Date 2020/4/21 5:24 下午
 * @Version 1.0
 **/
@Data
public class SunWuKong3 implements Cloneable, Serializable {

    private String type = "石猴";
    private String gender = "公";
    private Weapon jinGuBang = new Weapon();

    @Override
    public SunWuKong3 clone() throws CloneNotSupportedException {
        return (SunWuKong3) super.clone();
    }

    public SunWuKong3 deepClone() throws IOException, ClassNotFoundException {
        // 写出
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(this);

        // 读入
        ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(bos.toByteArray()));

        return (SunWuKong3)ois.readObject();
    }
}