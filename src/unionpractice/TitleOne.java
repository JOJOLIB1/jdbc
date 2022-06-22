package unionpractice;


import bean.Customers;
import preparedstatement_pack.GeneralQuery;
import util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.Scanner;


/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: asus
 * Date: 2022-06-21
 * Time: 22:20
 */
public class TitleOne {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String sql = "insert into customers(id) values(?)";
        update(sql,s.next());
        List<Customers> query = new GeneralQuery().query(Customers.class, "select id,name,email,birth from customers");
        query.forEach(System.out::println);
    }
    public static void update(String sql,Object... args) {
        PreparedStatement ps = null;
        Connection connection = null;
        try {
            connection = JDBCUtil.getConnection();
            ps = connection.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1,args[i]);
            }
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeAll(ps,connection);
        }
    }
}
