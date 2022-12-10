package dataAccess;

import pojo.*;
import java.sql.*;
import java.util.*;
import java.util.logging.*;

public class StudentDA {
    public List<StudentPOJO> getAll() {
        List<StudentPOJO> ans;
        try {
            ans = new ArrayList<>();
            Connection connection = MyConnection.create();
            Statement statement;
            assert connection != null;
            statement = connection.createStatement();
            String query = "SELECT * FROM student";
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("hoten");
                int mssv = rs.getInt("mssv");
                double gpa = rs.getDouble("gpa");
                StudentPOJO student = new StudentPOJO(id, mssv, name, gpa);
                ans.add(student);
            }
            rs.close();
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(StudentDA.class.getName()).log(Level.SEVERE, null, ex);
            ans = null;
        }
        return ans;
    }
}
