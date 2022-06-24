package dao;

import bean.Customers;
import org.junit.Test;
import util.JDBCUtil;

import java.sql.Connection;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: asus
 * Date: 2022-06-24
 * Time: 9:30
 */
public class CustomersDAOImplTest {

    private CustomersDAOImpl dao = new CustomersDAOImpl();

    @Test
    public void getAll() {
        Connection connection = null;
        try {
            CustomersDAOImpl dao = new CustomersDAOImpl();
            connection = JDBCUtil.getConnection();
            List<Customers> all = dao.getAll(connection);
            all.forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeAll(null,connection);
        }
    }

    @Test
    public void getById() {
        Connection connection = null;
        try {
            connection = JDBCUtil.getConnection();
            Customers byId = dao.getById(connection, 1);
            System.out.println(byId);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeAll(null,connection);
        }
    }

    @Test
    public void update() {
        Connection connection = null;
        try {
            connection = JDBCUtil.getConnection();
            int update = dao.update(connection, new Customers(1, "张三", "张三@134.com", new Date(10430984L)));
            System.out.println(update > 0 ? "修改成功" : "修改失败");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeAll(null,connection);
        }
    }

    @Test
    public void deleteById() {

    }

    @Test
    public void insert() {
    }

    @Test
    public void getMaxDate() {
    }

    @Test
    public void getSum() {
    }
}