package util;

import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.Assert.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: asus
 * Date: 2022-06-25
 * Time: 9:24
 */
public class ConnectionTest {

    @Test
    public void getConnectionC3P0() throws SQLException {
        Connection connectionC3P0 = JDBCUtil.getConnectionC3P0();
        System.out.println(connectionC3P0);
    }

    @Test
    public void getConnectionDBCP() throws SQLException {
        System.out.println(JDBCUtil.getConnectionDBCP());
    }

    @Test
    public void getConnectionDruid() throws SQLException {
        System.out.println(JDBCUtil.getConnectionDruid());
    }
}