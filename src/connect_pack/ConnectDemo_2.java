package connect_pack;

import java.sql.Driver;
import java.util.Properties;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: asus
 * Date: 2022-06-19
 * Time: 21:26
 */

// 具有更好的可移植性
public class ConnectDemo_2 {
    public static void main(String[] args) {
        try {
            Class clazz = Class.forName("com.mysql.jdbc.Driver");
            Driver driver = (Driver) clazz.newInstance();
            Properties properties = new Properties();
            properties.setProperty("user","root");
            properties.setProperty("password","Hello_world_123!!~~~");
            driver.connect("jdbc:mysql://43.142.25.180:3306/test?useUnicode=true&characterEncoding=utf8",properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
