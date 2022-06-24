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
public interface CustomersDAO {

    List<Customers> getAll(Connection connection);

    Customers getById(Connection connection,int id);

    int update(Connection connection,Customers customers);

    int deleteById(Connection connection,int id);

    int insert(Connection connection,Customers customers);

    Date getMaxDate(Connection connection);

    int getSum(Connection connection);
}
