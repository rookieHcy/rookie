import com.alibaba.fastjson.JSONObject;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.jupiter.api.Test;

import java.sql.*;
import java.util.Map;
import java.util.TreeMap;

/**
 * @ClassName TestJdbc
 * @Description 手动获取jdbc链接
 * @Author hou
 * @Date 2020/5/4 11:36 下午
 * @Version 1.0
 **/
public class GenArea2 {



    String getProvinceSql = "select code, name from area where parent_id = ? order by code asc";

    @Test
    public void testJdbc() throws Exception {

        String getCitySql = "select distinct code, city from area where district is not null and province like ? order by code asc";
        String getDistrictSql = "select distinct code, district from area where district is not null and province like ? and city like ? order by code asc";


        // 加载类驱动
        Class.forName("com.mysql.jdbc.Driver");
        // 获取链接
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?characterEncoding=utf8", "root", "root");

        Map<Integer, Map<Integer, String>> base = new TreeMap<>();
        getLeaf(connection, base, "0");
        connection.close();
        System.out.println(JSONObject.toJSONString(base));
    } // rowKey: rowKey1, month: 1, createTime: 2019-03-01

    private void getLeaf(Connection connection, Map<Integer, Map<Integer, String>> base, String parentId) throws SQLException {

        // 预编译sql
        PreparedStatement ps = connection.prepareStatement(getProvinceSql);
        ps.setString(1, parentId);
        // 执行语句
        ResultSet province = ps.executeQuery();

        Map<Integer, String> treeMap = new TreeMap<>();
        while (province.next()) {
            String code = province.getString(1);
            String name = province.getString(2);
//            inners.add(new Inner(provCode, provStr));
            treeMap.put(Integer.parseInt(code), name);
            getLeaf(connection, base, code);
        }
//        System.out.println(JSONObject.toJSONString(treeMap));
        if(!treeMap.isEmpty()) {
            base.put(Integer.parseInt(parentId), treeMap);
        }
    }

    @Data
    @AllArgsConstructor
    class Inner {
        private String code;
        private String name;
    }

}