import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import test0505.Test050501;
import test0505.Test050502;

import java.lang.reflect.Field;

/**
 * @ClassName TestAutowired
 * @Description TODO
 * @Author hou
 * @Date 2020/5/5 12:55 上午
 * @Version 1.0
 **/
public class TestDIConstructor extends BaseTest{

    // 测试自动注入
    @Test
    public void testConstructor() throws Exception {
        Test050502 bean = ac.getBean(Test050502.class);
    }/*
        有默认构造方法的时候会执行默认构造方法
        没有默认构造方法时会报错
        org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'test050502' defined in file [/Users/hou/rookie/test-spring/target/classes/test0505/Test050502.class]: Instantiation of bean failed; nested exception is org.springframework.beans.BeanInstantiationException: Failed to instantiate [test0505.Test050502]: No default constructor found; nested exception is java.lang.NoSuchMethodException: test0505.Test050502.<init>()
    */

}