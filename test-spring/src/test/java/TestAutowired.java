import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import test0505.Test050501;

import java.lang.reflect.Field;

/**
 * @ClassName TestAutowired
 * @Description TODO
 * @Author hou
 * @Date 2020/5/5 12:55 上午
 * @Version 1.0
 **/
public class TestAutowired {

    // 测试自动注入
    @Test
    public void testAutowried() throws Exception {
        ApplicationContext ac = new FileSystemXmlApplicationContext("classpath:applicationContext.xml");
        Test050501 bean = ac.getBean(Test050501.class);

        //获得类
        Class clazz = bean.getClass();
        // 获取实体类的所有属性信息，返回Field数组
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field);
        }

//        Field field = clazz.getDeclaredField("class1");
//        System.out.println(field.get(bean));
//
//        field = clazz.getDeclaredField("class2");
//        System.out.println(field.get(bean));

        Field field = clazz.getDeclaredField("class3");
        field.setAccessible(true);
        System.out.println(field.get(bean));
    }

}