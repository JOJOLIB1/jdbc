package learn.transaction;

import bean.Order;
import org.junit.Test;
import util.JDBCUtil;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: asus
 * Date: 2022-06-23
 * Time: 10:34
 */
public class TxQuery {
    @Test
    public void queryDemo() throws Exception {
        Connection connection = JDBCUtil.getConnection();
        connection.setAutoCommit(false);
        connection.setTransactionIsolation(Connection.TRANSACTION_READ_UNCOMMITTED);
        List<Order> orders = txQuery(Order.class, connection, "SELECT order_name orderName FROM `order` where order_id = ?", 4);
        orders.forEach(System.out::println);
//      JDBCUtil.closeAll(null,connection,null);
    }

    public <T> List<T> txQuery(Class<T> clazz, Connection connection, String sql, Object... args) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = connection.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1,args[i]);
            }
            rs = ps.executeQuery();
            ResultSetMetaData md = rs.getMetaData();
            ArrayList<T> ts = new ArrayList<>();
            while (rs.next()) {
                T t = clazz.newInstance();
                for (int i = 0; i < md.getColumnCount(); i++) {
                    Object value = rs.getObject(i + 1);
                    String name = md.getColumnLabel(i + 1);
                    Field field = clazz.getDeclaredField(name);
                    field.setAccessible(true);
                    field.set(t,value);
                }
                ts.add(t);
            }
            return ts;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeAll(ps,null,rs);
        }
        return null;
    }
}
