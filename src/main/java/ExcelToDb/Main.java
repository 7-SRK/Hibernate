package ExcelToDb;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException, IOException {
        System.out.println("Commons IO loaded from: " +
                org.apache.commons.io.input.BoundedInputStream.class.getProtectionDomain()
                        .getCodeSource().getLocation());

        String excelFile = "C:\\Users\\Admin\\IdeaProjects\\Hibernate\\students.xlsx";

            ExcelReader reader = new ExcelReader();
            List<Students> students = reader.readStudentsFromExcel(excelFile);

            StudentDAOExcelDb dao = new StudentDAOExcelDb();
            dao.upsertStudents(students);

            System.out.println("Database updated successfully from Excel file.");
    }
}

