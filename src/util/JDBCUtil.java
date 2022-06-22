package util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: asus
 * Date: 2022-06-20
 * Time: 20:05
 */
public class JDBCUtil {
    // 获取连接对象 √
    // 通用修改方法 √
    // 释放流(两个) √
    // ORM对应的类 √
    // 表的通用查询 √

    public static Connection getConnection() throws Exception{
        Connection connection = null;
            // .properties 必须要写,否则找不到
            InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("jdbc.properties");
            Properties properties = new Properties();
            properties.load(is);
            Class.forName(properties.getProperty("mysqlClass"));
            connection = DriverManager.getConnection(properties.getProperty("url"), properties.getProperty("user"), properties.getProperty("password"));
        return connection;
    }

    public static void closeAll(Statement statement,Connection connection) {
        try {
            if (statement != null)
                statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (connection != null)
                connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void closeAll(Statement statement, Connection connection, ResultSet resultSet) {
        try {
            if (statement != null)
                statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (connection != null)
                connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (resultSet != null)
                resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
