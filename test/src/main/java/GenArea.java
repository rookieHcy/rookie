import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.mysql.jdbc.JDBC4PreparedStatement;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @ClassName TestJdbc
 * @Description 手动获取jdbc链接
 * @Author hou
 * @Date 2020/5/4 11:36 下午
 * @Version 1.0
 **/
public class GenArea {

    @Test
    public void testJdbc() throws Exception {

        String getProvinceSql = "select distinct province from area where district is not null ";
        String getCitySql = "select distinct city from area where district is not null and province like ? ";
        String getDistrictSql = "select distinct district from area where district is not null and province like ? and city like ?";


        // 加载类驱动
        Class.forName("com.mysql.jdbc.Driver");
        // 获取链接
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?characterEncoding=utf8", "root", "root");
        // 预编译sql
        PreparedStatement ps = connection.prepareStatement(getProvinceSql);

        // 执行语句
        ResultSet province = ps.executeQuery();
        JSONArray jsonArray = new JSONArray();
        while (province.next()) {
            String provinceStr = province.getString("province");
            ps = connection.prepareStatement(getCitySql);
            ps.setString(1, provinceStr);
            ResultSet city = ps.executeQuery();
//            String rsq = ((JDBC4PreparedStatement)ps).asSql();
//            System.out.println(rsq);
            JSONArray cityJsonArr = new JSONArray();
            while(city.next()){
                String cityStr = city.getString("city");
                System.out.println(cityStr);
                ps = connection.prepareStatement(getDistrictSql);
                ps.setString(1, provinceStr);
                ps.setString(2, cityStr);
                ResultSet district = ps.executeQuery();
                JSONArray districtAndCounty = new JSONArray();
                while(district.next()){
                    districtAndCounty.add(district.getString("district"));
                }
                JSONObject city2dist = new JSONObject();
                city2dist.put("name", cityStr);
                city2dist.put("districtAndCounty", districtAndCounty);
                cityJsonArr.add(city2dist);
            }
            JSONObject pro2city = new JSONObject();
            pro2city.put("name", provinceStr);
            pro2city.put("city", cityJsonArr);
            jsonArray.add(pro2city);
        }
        // 关闭链接
        province.close();
        ps.close();
        connection.close();

        System.out.println(jsonArray.toJSONString());
    } // rowKey: rowKey1, month: 1, createTime: 2019-03-01

    private Area getArea(ResultSet resultSet) {
        Area area = null;
        try {
            String id = resultSet.getString("id");
            String parentId = resultSet.getString("parent_id");
            String name = resultSet.getString("name");
            String code = resultSet.getString("code");
            String province = resultSet.getString("province");
            String city = resultSet.getString("city");
            String district = resultSet.getString("district");
            area = new Area(id, parentId, name, code, province, city, district);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return area;
    }

}