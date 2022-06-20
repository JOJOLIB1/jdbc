package connect_pack;

import java.sql.Driver;
import java.sql.DriverManager;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: asus
 * Date: 2022-06-19
 * Time: 21:27
 */
public class ConnectDemo_4 {
    public static void main(String[] args) {
        try {
            // 针对于MySQL可以省略,因为jar包下,META_INF有对应的完整类名加载到内存中,自动执行静态代码块
            // 为了解耦合,不要省略
            Class.forName("com.mysql.jdbc.Driver");
            //Class.forName("com.mysql.jdbc.Driver");
            DriverManager.getConnection("jdbc:mysql://43.142.25.180:3306/test?useUnicode=true&characterEncoding=utf8","root","Hello_world_123!!~~~");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
