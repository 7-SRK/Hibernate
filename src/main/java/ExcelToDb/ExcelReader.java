package ExcelToDb;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExcelReader {

    public List<Students> readStudentsFromExcel(String filePath) throws IOException {
        List<Students> students = new ArrayList<>();

        try (FileInputStream fis = new FileInputStream(filePath);
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheetAt(0); // First sheet
            int rowCount = sheet.getPhysicalNumberOfRows();

            for (int i = 1; i < rowCount; i++) {  // Skip header row at 0
                Row row = sheet.getRow(i);
                if (row == null) continue;

                int sid = (int) getNumericCellValueSafe(row, 0);
                String sname = getStringCellValueSafe(row, 1);
                double marks = getNumericCellValueSafe(row, 2);
                students.add(new Students(sid, sname, marks));
            }
        }

        return students;
    }

    private double getNumericCellValueSafe(Row row, int cellIndex) {
        Cell cell = row.getCell(cellIndex);
        if (cell == null) {
            // Cell missing → treat as zero or throw error if preferred
            return 0;
        }

        CellType cellType = cell.getCellType();
        if (cellType == CellType.NUMERIC) {
            return cell.getNumericCellValue();
        } else if (cellType == CellType.STRING) {
            String val = cell.getStringCellValue();
            try {
                return Double.parseDouble(val);
            } catch (NumberFormatException e) {
                return 0;
            }
        } else if (cellType == CellType.FORMULA) {
            if (cell.getCachedFormulaResultType() == CellType.NUMERIC) {
                return cell.getNumericCellValue();
            } else {
                return 0;
            }
        } else if (cellType == CellType.BLANK) {
            return 0;
        }
        return 0;
    }

    private String getStringCellValueSafe(Row row, int cellIndex) {
        Cell cell = row.getCell(cellIndex);
        if (cell == null) {
            return "";
        }

        CellType cellType = cell.getCellType();
        if (cellType == CellType.STRING) {
            return cell.getStringCellValue();
        } else if (cellType == CellType.NUMERIC) {
            return String.valueOf(cell.getNumericCellValue());
        } else if (cellType == CellType.FORMULA) {
            if (cell.getCachedFormulaResultType() == CellType.STRING) {
                return cell.getStringCellValue();
            } else if (cell.getCachedFormulaResultType() == CellType.NUMERIC) {
                return String.valueOf(cell.getNumericCellValue());
            } else {
                return "";
            }
        } else if (cellType == CellType.BLANK) {
            return "";
        }
        return "";
    }
}