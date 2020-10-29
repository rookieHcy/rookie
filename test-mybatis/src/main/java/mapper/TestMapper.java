package mapper;

import pojo.TestResult;

import java.util.List;

/**
 * @ClassName TestMapper
 * @Description TODO
 * @Author hou
 * @Date 2020/5/6 5:01 下午
 * @Version 1.0
 **/
public interface TestMapper {
    List<TestResult> queryAll();

    TestResult selectById(Integer id);

    TestResult selectByIdFlushCache(Integer id);

    boolean updateCreateTimeById(Integer id);

}