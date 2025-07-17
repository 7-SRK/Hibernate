package ExcelToDb;

import java.sql.*;
import java.util.*;

public class StudentDAOExcelDb {
    private static final String url = "jdbc:postgresql://localhost:5432/demo";
    private static final String user = "postgres";
    private static final String pass = "7059";


    private boolean studentExists(Connection con, int sid) throws SQLException {
        String query = "SELECT COUNT(*) FROM student WHERE sid = ?";
        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, sid);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1) > 0;
                }
            }
        }
        return false;
    }

    private void insertStudent(Connection con, Students student) throws SQLException {
        String insertSQL = "INSERT INTO student (sid, sname, marks) VALUES (?, ?, ?)";
        try (PreparedStatement ps = con.prepareStatement(insertSQL)) {
            ps.setInt(1, student.getSid());
            ps.setString(2, student.getSname());
            ps.setDouble(3, student.getMarks());
            ps.executeUpdate();
        }
    }

    private void updateStudent(Connection conn, Students student) throws SQLException {
        String updateSQL = "UPDATE student SET sname = ?, marks = ? WHERE sid = ?";
        try (PreparedStatement ps = conn.prepareStatement(updateSQL)) {
            ps.setString(1, student.getSname());
            ps.setDouble(2, student.getMarks());
            ps.setInt(3, student.getSid());
            ps.executeUpdate();
        }
    }

    public void upsertStudents(List<Students> students) throws SQLException {
        try (Connection con = DriverManager.getConnection(url, user, pass)) {
            for (Students student : students) {
                if (studentExists(con, student.getSid())) {
                    updateStudent(con, student);
                } else {
                    insertStudent(con, student);
                }
            }
        }
    }
}


