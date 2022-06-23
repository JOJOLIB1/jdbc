package learn.transaction;

import org.junit.Test;
import util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: asus
 * Date: 2022-06-23
 * Time: 10:35
 */
public class TxUpdate {
    @Test
    public void updateDemo() throws Exception {
        Connection connection = JDBCUtil.getConnection();
        connection.setAutoCommit(false);
        connection.setTransactionIsolation(Connection.TRANSACTION_READ_UNCOMMITTED);
        txUpdate(connection,"UPDATE `order` SET order_name = 'cc' where order_id = ?",4);
        Thread.sleep(15000);
//        JDBCUtil.closeAll(null,connection);
    }
    public int txUpdate(Connection connection,String sql,Object... args)  {
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1,args[i]);
            }
            return ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeAll(ps,null);
        }
        return 0;
    }
}
