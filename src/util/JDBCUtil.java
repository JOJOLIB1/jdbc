package util;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;

import javax.sql.DataSource;
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

    // 获取properties的两种方式 √
    // DBCP + Druid + C3P0 √
    // QueryRunner
    // 源码版DAO与QueryRunner版DAO
    // DbUtils

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

    public static DataSource dataSource = null;
    public static DataSource dataSource1 = null;
    public static Connection getConnectionC3P0() throws SQLException {
        dataSource = new ComboPooledDataSource("myConnect");
        return dataSource.getConnection();
    }

    static {
        InputStream is = null;
        try {
            Properties pros = new Properties();
            is = ClassLoader.getSystemClassLoader().getResourceAsStream("dbcp.properties");
            pros.load(is);
            dataSource = BasicDataSourceFactory.createDataSource(pros);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (is != null) {
                    is.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public static Connection getConnectionDBCP() throws SQLException {
        return dataSource.getConnection();
    }

    static {
        InputStream is = null;
        try {
            Properties pros = new Properties();
            is = ClassLoader.getSystemClassLoader().getResourceAsStream("druid.properties");
            pros.load(is);
            dataSource1 = DruidDataSourceFactory.createDataSource(pros);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (is != null) {
                    is.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static Connection getConnectionDruid() throws SQLException {
        return dataSource1.getConnection();
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
