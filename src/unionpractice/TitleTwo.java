package unionpractice;

import bean.ExamStudent;
import preparedstatement_pack.GeneralQuery;
import preparedstatement_pack.GeneralUpdateSql;

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
        System.out.println("请输入您要输入的类型:");
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
        }/*        System.out.println("请输入学生的考证号");
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        GeneralUpdateSql gs = new GeneralUpdateSql();
        gs.update("delete from exam_student where ExamCard = ?",s);
        System.out.println("删除成功");*/


    }

}
