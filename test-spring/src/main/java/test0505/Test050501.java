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
public class Test050501 {

    @Autowired
    private Class1 class1;

    @Autowired
    private Class2 class2;

    private Class3 class3;

    @Autowired
    private void setClass3(Class3 class3) {
        this.class3 = class3;
    }
}