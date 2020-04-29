import com.houcy7.spring.demo.action.TestController;
import com.houcy7.spring.formework.context.GPApplicationContext;

/**
 * @ClassName Test01
 * @Description TODO
 * @Author hou
 * @Date 2020/4/28 12:58 上午
 * @Version 1.0
 **/
public class Test01 {
    public static void main(String[] args) throws Exception {
        GPApplicationContext gpApplicationContext = new GPApplicationContext("classpath:application.properties");
        System.out.println(gpApplicationContext);
        TestController testController = (TestController)gpApplicationContext.getBean("testController");
        System.out.println(testController.testService);
    }
}