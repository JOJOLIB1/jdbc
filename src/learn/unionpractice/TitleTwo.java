package learn.unionpractice;

import bean.ExamStudent;
import org.junit.Test;
import learn.preparedstatement_pack.GeneralQuery;
import learn.preparedstatement_pack.GeneralUpdateSql;

import java.util.List;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: asus
 * Date: 2022-06-22
 * Time: 8:51
 */
public class TitleTwo {
    public static void main(String[] args) {
/*        System.out.println("请输入您要输入的类型:");
        System.out.println("a:准考证号");
        System.out.println("b:身份证号");
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        GeneralQuery gq = new GeneralQuery();
        String sql1 = "select FlowId flowId,Type type,IDCard idCard,ExamCard examCard,StudentName studentName,Location location,Grade grade from exam_student where IDCard = ?";
        String sql2 = "select FlowId flowId,Type type,IDCard idCard,ExamCard examCard,StudentName studentName,Location location,Grade grade from exam_student where ExamCard = ?";
        List<ExamStudent> query;
        if (s.equals("a")) {
            System.out.println("请输入准考证号");
            query = gq.query(ExamStudent.class, sql2, scanner.next());
        }else if (s.equals("b")) {
            System.out.println("请输入身份证号");
            query = gq.query(ExamStudent.class, sql1, scanner.next());
        }else {
            System.out.println("输入有误,请重新输入");
            return;
        }
        if (query.isEmpty()) {
            System.out.println("查无此人,请重新输入");
        }else {
            query.forEach(System.out::println);
        }*//*        System.out.println("请输入学生的考证号");
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        GeneralUpdateSql gs = new GeneralUpdateSql();
        gs.update("delete from exam_student where ExamCard = ?",s);
        System.out.println("删除成功");*/
        System.out.println("请输入考生名字");
        Scanner s = new Scanner(System.in);
        String name = s.next();
        GeneralQuery gn = new GeneralQuery();
        List<ExamStudent> query = gn.query(ExamStudent.class, "SELECT FlowId flowId FROM exam_student where StudentName = ?",name);
        if (query.isEmpty()) {
            System.out.println("没有这个人");
        }else {
            GeneralUpdateSql gs = new GeneralUpdateSql();
            String grade = s.next();
            gs.update("insert into exam_student(grade) values(?)",grade);
            System.out.println("插入成功");
        }
    }
    @Test
    public void test() {

    }

}
