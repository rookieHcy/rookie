import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import test0505.Test050501;

/**
 * @ClassName BaseTest
 * @Description TODO
 * @Author hou
 * @Date 2020/5/5 1:27 上午
 * @Version 1.0
 **/
public class BaseTest {
    ApplicationContext ac = new FileSystemXmlApplicationContext("classpath:applicationContext.xml");

}