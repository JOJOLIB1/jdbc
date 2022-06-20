package preparedstatement_pack;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: asus
 * Date: 2022-06-20
 * Time: 16:05
 */
public class PreparedStatement {
    public static void main(String[] args) {
        InputStream is = null;
        Connection connection = null;
        java.sql.PreparedStatement ps = null;
        try {
            is = ClassLoader.getSystemClassLoader().getResourceAsStream("jdbc.properties");
            Properties properties = new Properties();
            properties.load(is);
            Class.forName(properties.getProperty("mysqlClass"));
            connection = DriverManager.getConnection(properties.getProperty("url"), properties.getProperty("user"), properties.getProperty("password"));
            String sql = "INSERT INTO user(name,password) VALUES(?,?)";
            ps = connection.prepareStatement(sql);
            ps.setString(1,"张三");
            ps.setString(2,"123456");
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if (is != null)
                    is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (connection != null)
                    connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (ps != null)
                    ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
