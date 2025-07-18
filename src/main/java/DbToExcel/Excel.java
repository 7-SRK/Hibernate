package DbToExcel;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class Excel {
    public void excel(List<Student> students, String filePath) throws IOException {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("students");

        Row header = sheet.createRow(0);
        String[] columns = {"SID","Name","Marks"};
        for (int i = 0; i < columns.length; i++) {
            Cell cell = header.createCell(i);
            cell.setCellValue(columns[i]);
        }

        int rowNum = 1;
        for(Student student: students){
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(student.getSid());
            row.createCell(1).setCellValue(student.getSname());
            row.createCell(2).setCellValue(student.getMarks());
        }

        for (int i = 0; i < columns.length; i++) {
            sheet.autoSizeColumn(i);
        }

        try(FileOutputStream fos = new FileOutputStream(filePath)){
            workbook.write(fos);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        workbook.close();
    }
}