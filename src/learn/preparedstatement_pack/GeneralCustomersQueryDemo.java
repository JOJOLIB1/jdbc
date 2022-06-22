package learn.preparedstatement_pack;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: asus
 * Date: 2022-06-20
 * Time: 22:29
 */
public class GeneralCustomersQueryDemo {
    public static void main(String[] args) {
        GeneralCustomersQuery gcq = new GeneralCustomersQuery();
        System.out.println(gcq.query("select name from customers where id = ?", 1));
    }
}
