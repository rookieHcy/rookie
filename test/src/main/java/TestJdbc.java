import org.junit.jupiter.api.Test;

import java.sql.*;

/**
 * @ClassName TestJdbc
 * @Description 手动获取jdbc链接
 * @Author hou
 * @Date 2020/5/4 11:36 下午
 * @Version 1.0
 **/
public class TestJdbc {

    @Test
    public void testJdbc() throws Exception {
        // 加载类驱动
        Class.forName("com.mysql.jdbc.Driver");
        // 获取链接
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
        // 预编译sql
        PreparedStatement ps = connection.prepareStatement("select * from test2 where month = ?");
        //设置参数 下标从0开始
        ps.setInt(1, 1);
        // 执行语句
        ResultSet resultSet = ps.executeQuery();
        // 遍历结果集
        /*
            row_key: rowKey1
            month: 1
            create_time: 2019-03-01 11:31:40
            seq_num: seqNum
            gid: gid
            prod_name: prodName
            bid: bid
            status: 1
            use_time: 10
        */
        while (resultSet.next()) {
            String rowKey = resultSet.getString("row_key");
            int month = resultSet.getInt("month");
            Date create_time = resultSet.getDate("create_time");
            System.out.println(String.format("rowKey: %s, month: %d, createTime: %s", rowKey, month, create_time));
        }
        // 关闭链接
        resultSet.close();
        ps.close();
        connection.close();
    } // rowKey: rowKey1, month: 1, createTime: 2019-03-01

}