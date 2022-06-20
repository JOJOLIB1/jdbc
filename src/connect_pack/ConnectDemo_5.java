package connect_pack;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Driver;
import java.sql.DriverManager;
import java.util.Properties;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: asus
 * Date: 2022-06-19
 * Time: 21:27
 */
public class ConnectDemo_5 {
    // 一次编译,多次执行
    // 数据代码分离,实现了解耦
    public static void main(String[] args) {
        InputStream is;
        try {
            is = Thread.currentThread().getContextClassLoader().getResourceAsStream("jdbc.properties");
            Properties properties = new Properties();
            properties.load(is);
            Class.forName(properties.getProperty("mysqlClass"));
            DriverManager.getConnection(properties.getProperty("url"),properties.getProperty("user"), properties.getProperty("password"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
