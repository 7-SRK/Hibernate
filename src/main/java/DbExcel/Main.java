package DbExcel;

import jakarta.mail.MessagingException;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException, IOException, MessagingException {
        StudentDAO dao = new StudentDAO();
        List<Student> students = dao.getAllStudents();

        String excelFile= "students.xlsx";
        Excel excel1 = new Excel();
        excel1.excel(students,excelFile);

        EmailSender emailSender = new EmailSender();
        emailSender.sendEmailWithAttachment(
                "sreeramk387@gmail.com,ram07082003@gmail.com",
                "Student Data",
                "Please find attached the student data Excel file.",
                excelFile
        ); //kiruthiga@zakapps.com
    }
}
