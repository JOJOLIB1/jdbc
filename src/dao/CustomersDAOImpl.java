package dao;

import bean.Customers;

import java.sql.Connection;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: asus
 * Date: 2022-06-23
 * Time: 17:17
 */
public class CustomersDAOImpl extends BaseDAO <Customers> implements CustomersDAO {
    @Override
    public List<Customers> getAll(Connection connection) {
        String sql = "SELECT id,name,email,birth FROM customers";
        return gQuery(connection, sql);
    }

    @Override
    public Customers getById(Connection connection, int id) {
        String sql = "SELECT id,name,email,birth FROM customers WHERE id = ?";
        return (Customers) gQuery(connection, sql,id).get(0);
    }

    @Override
    public int update(Connection connection,Customers customers) {
        String sql = "UPDATE customers SET name = ?,email = ?,birth = ? WHERE id = ?";
        return gUpdate(connection,sql,customers.getName(),customers.getEmail(),customers.getBirth(),customers.getId());
    }

    @Override
    public int deleteById(Connection connection, int id) {
        String sql = "DELETE FROM customers WHERE id = ?";
        return gUpdate(connection,sql,id);
    }

    @Override
    public int insert(Connection connection, Customers customers) {
        String sql = "INSERT INTO customers (name,email,birth) VALUES(?,?,?)";
        return gUpdate(connection,sql,customers.getName(),customers.getEmail(),customers.getBirth());
    }

    @Override
    public Date getMaxDate(Connection connection) {
        String sql = "SELECT MAX(birth) FROM customers";
        return getValue(connection,sql);
    }

    @Override
    public int getSum(Connection connection) {
        String sql = "SELECT COUNT(1) FROM customers";
        return getValue(connection,sql);
    }
}
