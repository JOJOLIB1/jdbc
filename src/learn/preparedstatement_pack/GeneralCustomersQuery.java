package learn.preparedstatement_pack;

import bean.Customers;
import util.JDBCUtil;

import java.lang.reflect.Field;
import java.sql.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: asus
 * Date: 2022-06-20
 * Time: 22:14
 */
public class GeneralCustomersQuery {
    public Customers query (String sql,Object... args) {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            connection = JDBCUtil.getConnection();
            ps = connection.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1,args[i]);
            }
            resultSet = ps.executeQuery();
            ResultSetMetaData md = resultSet.getMetaData();
            if (resultSet.next()) {
                Customers row = new Customers();
                int count = md.getColumnCount();
                for (int i = 0; i < count; i++) {
                    Object value = resultSet.getObject(i + 1);
                    String cn = md.getColumnName(i + 1);
                    Field field = Customers.class.getDeclaredField(cn);
                    field.setAccessible(true);
                    field.set(row,value);
                }
                return row;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeAll(ps,connection,resultSet);
        }
        return null;
    }
}
