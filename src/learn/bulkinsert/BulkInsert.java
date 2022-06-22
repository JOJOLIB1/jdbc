package learn.bulkinsert;

import org.junit.Test;
import util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: asus
 * Date: 2022-06-22
 * Time: 19:47
 */
public class BulkInsert {
    // 批量插入
    // 可以通过让事务只结束一次达到效率的提升
    // 事务的提交会导致bin_log与redo_log的刷盘操作,而且数据也会被刷盘,效率变低
    // 通过减少上述的IO操作,提高效率
    @Test
    public void test() {
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            connection = JDBCUtil.getConnection();
            connection.setAutoCommit(false);
            String sql = "insert into `order` (order_name) values(?)";
            ps = connection.prepareStatement(sql);
            for (int i = 1; i <= 100000; i++) {
                ps.setObject(1,i);
                ps.addBatch();
                if (i % 500 == 0){
                    ps.executeBatch();
                    ps.clearBatch();
                }
            }
            connection.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeAll(ps,connection);
        }
    }
}
