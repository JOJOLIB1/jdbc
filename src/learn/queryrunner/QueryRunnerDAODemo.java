package learn.queryrunner;

import bean.Customers;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Test;
import util.JDBCUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: asus
 * Date: 2022-06-25
 * Time: 9:47
 */
public class QueryRunnerDAODemo {

    private QueryRunner queryRunner = new QueryRunner(JDBCUtil.dataSource1);

    @Test
    public void insertDemo() {
        Connection connectionDruid = null;
        try {
            connectionDruid = JDBCUtil.getConnectionDruid();
            queryRunner.update(connectionDruid,"insert into customers(name,email,birth) values(?,?,?)","张三","zhangsan@125.com",new Date(1000000L));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbUtils.closeQuietly(connectionDruid);
        }
    }

    @Test
    public void deleteDemo() throws SQLException {
        queryRunner.update("delete from customers where id = ?",5);
    }

    @Test
    public void updateDemo() throws SQLException {
        queryRunner.update("update customers set name = ?,email = ? where id = ?","李四","lisi@123.com",21);
    }

    @Test
    public void selectDemo() throws SQLException {
        BeanListHandler<Customers> rsh = new BeanListHandler<>(Customers.class);
        List<Customers> list = queryRunner.query("select id,name,email,birth from customers", rsh);
        list.forEach(System.out::println);
    }

}
