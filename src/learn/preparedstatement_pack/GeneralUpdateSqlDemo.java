package learn.preparedstatement_pack;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: asus
 * Date: 2022-06-20
 * Time: 21:56
 */
public class GeneralUpdateSqlDemo {
    public static void main(String[] args) {
        GeneralUpdateSql gu = new GeneralUpdateSql();
        gu.update("update customers set name = ? where id = ?","马儿扎哈",1);
    }
}
