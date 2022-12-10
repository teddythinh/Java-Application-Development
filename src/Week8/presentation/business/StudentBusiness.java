package presentation.business;

import dataAccess.StudentDA;
import pojo.StudentPOJO;
import java.util.*;

public class StudentBusiness {
    public List<StudentPOJO> getAll() {
        StudentDA da = new StudentDA();
        return da.getAll();
    }
}
