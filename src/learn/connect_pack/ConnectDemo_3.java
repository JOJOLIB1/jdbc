package learn.connect_pack;

import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: asus
 * Date: 2022-06-19
 * Time: 21:26
 */
public class ConnectDemo_3 {
    // 获取(注册)驱动 -> 获取连接
    public static void main(String[] args) throws SQLException {
        try {
            Class clazz = Class.forName("com.mysql.jdbc.Driver");
            Driver driver = (Driver) clazz.newInstance();
            DriverManager.registerDriver(driver);
            DriverManager.getConnection("jdbc:mysql://43.142.25.180:3306/test?useUnicode=true&characterEncoding=utf8","root","Hello_world_123!!~~~");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
