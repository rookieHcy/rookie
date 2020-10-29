import mapper.TestMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;

import org.junit.Test;
import pojo.TestResult;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @ClassName TestFirstLevelCache
 * @Description 测试一级缓存
 * @Author hou
 * @Date 2020/5/18 11:50 上午
 * @Version 1.0
 **/
public class TestFirstLevelCache {

    private SqlSession sqlSession;

    @Before
    public void before() throws IOException {
        // 定义配置文件，相对路径，文件直接放在resources目录下
        String resource = "configuration.xml";
        // 读取文件字节流
        InputStream inputStream = Resources.getResourceAsStream(resource);

        // mybatis 读取字节流，利用XMLConfigBuilder类解析文件
        // 将xml文件解析成一个 org.apache.ibatis.session.Configuration 对象
        // 然后将 Configuration 对象交给 SqlSessionFactory 接口实现类 DefaultSqlSessionFactory 管理
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // openSession 有多个重载方法， 比较重要几个是
        // 1 是否默认提交 SqlSession openSession(boolean autoCommit)
        // 2 设置事务级别 SqlSession openSession(TransactionIsolationLevel level)
        // 3 执行器类型   SqlSession openSession(ExecutorType execType)
        sqlSession = sqlSessionFactory.openSession();
    }

    /**
     * 测试一级缓存，默认开启（同一个session）
     * <p>
     * 第一次查询后 第二次查询与第一次查询条件完全一致时 直接返回缓存的结果
     */
    @Test
    public void testFirstLevelCache() {
        TestMapper testMapper = sqlSession.getMapper(TestMapper.class);

        System.out.println("第一次查询");
        /* select 1*/
        List<TestResult> testResults1 = testMapper.queryAll();
        testResults1.forEach(System.out::println);

        System.out.println("第二次查询");
        /* select 2*/
        List<TestResult> testResults2 = testMapper.queryAll();
        testResults2.forEach(System.out::println);

        sqlSession.close();

    }

    /**
     * 测试一级缓存，默认开启（非同一个session）
     * <p>
     * 非同一个session查询了两次
     */
    @Test
    public void testFirstLevelCache2() throws IOException {
        TestMapper testMapper = sqlSession.getMapper(TestMapper.class);

        System.out.println("第一次查询");
        /* select 1*/
        List<TestResult> testResults1 = testMapper.queryAll();
        testResults1.forEach(System.out::println);
        sqlSession.close();

        System.out.println("第二次查询");
        before();
        testMapper = sqlSession.getMapper(TestMapper.class);
        /* select 2*/
        List<TestResult> testResults2 = testMapper.queryAll();
        testResults2.forEach(System.out::println);
        sqlSession.close();
    }

    /**
     * 测试一级缓存，默认开启（同一个session， 不同的查询条件）
     * <p>
     *同一个session， 不同的查询条件 发起了多次查询
     */
    @Test
    public void testFirstLevelCache3() throws IOException {
        TestMapper testMapper = sqlSession.getMapper(TestMapper.class);

        System.out.println("第一次查询");
        /* select 1*/
        TestResult testResults1 = testMapper.selectById(1);
        System.out.println(testResults1);

        System.out.println("第二次查询");
        /* select 2*/
        TestResult testResults2 = testMapper.selectById(2);
        System.out.println(testResults2);
        sqlSession.close();
    }

    /**
     * 测试一级缓存，默认开启（同一个session， 发生了写操作）
     * <p>
     * 在同一次会话中 发生了写操作 缓存失效
     */
    @Test
    public void testFirstLevelCache4() throws IOException {
        TestMapper testMapper = sqlSession.getMapper(TestMapper.class);

        System.out.println("第一次查询");
        /* select 1*/
        TestResult testResults1 = testMapper.selectById(1);
        System.out.println(testResults1);

        // 执行更新
        boolean b = testMapper.updateCreateTimeById(1);
        System.out.println(b ? "更新成功" : "更新失败");

        System.out.println("第二次查询");
        /* select 2*/
        TestResult testResults2 = testMapper.selectById(1);
        System.out.println(testResults2);
        sqlSession.close();
    }

    /**
     * 测试一级缓存，开启清空缓存
     * <p>
     * 在同一次会话中 调用了刷新缓存的方法 会清空会话中的所有缓存！
     * 第一次查询 查库；第二次查询 读缓存；执行刷新缓存方法；第三次查询 查库
     */
    @Test
    public void testFirstLevelCache5() throws IOException {
        TestMapper testMapper = sqlSession.getMapper(TestMapper.class);

        System.out.println("第一次查询");
        /* select 1*/
        TestResult testResults1 = testMapper.selectById(1);
        System.out.println(testResults1);
        TestResult testResults2 = testMapper.selectById(2);
        System.out.println(testResults2);


        System.out.println("第二次查询");
        testResults1 = testMapper.selectById(1);
        System.out.println(testResults1);
        testResults2 = testMapper.selectById(2);
        System.out.println(testResults2);

        System.out.println("调用刷新缓存的方法");
        TestResult testResult3 = testMapper.selectByIdFlushCache(3);
        System.out.println(testResult3);

        System.out.println("第三次查询");
        testResults1 = testMapper.selectById(1);
        System.out.println(testResults1);
        testResults2 = testMapper.selectById(2);
        System.out.println(testResults2);
        sqlSession.close();
    }
}