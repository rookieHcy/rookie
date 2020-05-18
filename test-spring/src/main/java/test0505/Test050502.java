package test0505;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import test0505.rely.Class1;
import test0505.rely.Class2;
import test0505.rely.Class3;

/**
 * @ClassName Test050501
 * @Description TODO
 * @Author hou
 * @Date 2020/5/5 12:56 上午
 * @Version 1.0
 **/
@Component
public class Test050502 {

    private int i;
    private String string;

//    public Test050502() {
//        System.out.println("默认构造方法");
//    }

    public Test050502(int i) {
        this.i = i;
        System.out.println("构造方法1");
    }

    public Test050502(String string) {
        this.string = string;
        System.out.println("构造方法2");
    }
}