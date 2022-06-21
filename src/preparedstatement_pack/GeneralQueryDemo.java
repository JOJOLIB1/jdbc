package preparedstatement_pack;

import bean.Order;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: asus
 * Date: 2022-06-21
 * Time: 22:08
 */
public class GeneralQueryDemo {
    public static void main(String[] args) {
        GeneralQuery gq = new GeneralQuery();
        String sql = "SELECT order_id orderId,order_name orderName,order_date orderDate FROM `order` where order_id < ?";
        List<Order> orders = gq.query(Order.class, sql, 20);
        orders.forEach(System.out::println);
    }
}
