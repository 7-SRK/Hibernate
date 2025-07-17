package DbExcel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
    String url = "jdbc:postgresql://localhost:5432/demo";
    String user = "postgres";
    String pass = "7059";

    public List<Student> getAllStudents() throws SQLException {
        List<Student> students = new ArrayList<>();
        Connection con = DriverManager.getConnection(url,user,pass);
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("Select * from student");

        while(rs.next()){
            Student student = new Student();
            student.setSid(rs.getInt(1));
            student.setSname(rs.getString(2));
            student.setMarks(rs.getInt(3));
            students.add(student);
        }
        return students;
    }

}
