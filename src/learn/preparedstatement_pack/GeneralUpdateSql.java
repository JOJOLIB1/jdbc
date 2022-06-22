package learn.preparedstatement_pack;

import util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: asus
 * Date: 2022-06-20
 * Time: 21:51
 */
public class GeneralUpdateSql {
    public int update(String sql,Object... args) {
        PreparedStatement ps = null;
        Connection connection = null;
        try {
            connection = JDBCUtil.getConnection();
            ps = connection.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1,args[i]);
            }
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeAll(ps,connection);
        }
        return 0;
    }
}
