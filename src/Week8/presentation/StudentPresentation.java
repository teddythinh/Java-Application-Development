package presentation;

import presentation.business.StudentBusiness;
import pojo.StudentPOJO;
import java.util.*;

public class StudentPresentation {
    public static void main(String[] args) {
        StudentBusiness student = new StudentBusiness();
        List<StudentPOJO> students = student.getAll();
        for (StudentPOJO studentPOJO : students) {
            System.out.println(studentPOJO);
        }
    }
}
