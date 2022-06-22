package learn.connect_pack;

import java.sql.Driver;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 江骏杰
 * Date: 2022-06-19
 * Time: 20:19
 */
public class ConnectDemo_1 {
    public static void main(String[] args) {
        try {
            Driver driver = new com.mysql.jdbc.Driver();
            Properties properties = new Properties();
            properties.setProperty("user","root");
            properties.setProperty("password","Hello_world_123!!~~~");
            // 协议       jdbc:mysql:
            // ip地址:端口号     //43.142.25.180:3306
            // 数据库名     /test
            // 客户端字符集改为UTF8mb3   ?useUnicode=true&characterEncoding=utf8
            driver.connect("jdbc:mysql://43.142.25.180:3306/test?useUnicode=true&characterEncoding=utf8",properties);
            System.out.println(driver);
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
