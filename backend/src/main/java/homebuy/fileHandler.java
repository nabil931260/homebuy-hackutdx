package homebuy;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

class HomeBuyerInfo {
    int id;
    double grossMonthlyIncome;
    double creditCardPayment;
    double carPayment;
    double studentLoanPayments;
    double appraisedValue;
    double downPayment;
    double loanAmount;
    double monthlyMortgagePayment;
    int creditScore;

    // Constructor, getters, and setters can be added here
}

public class FileHandler {

    public List<HomeBuyerInfo> readExcelFile(String filePath) {
        List<HomeBuyerInfo> homeBuyerInfoList = new ArrayList<>();
        try (FileInputStream file = new FileInputStream(new File(filePath))) {
            Workbook workbook = new XSSFWorkbook(file);
            Sheet sheet = workbook.getSheetAt(0);

            Iterator<Row> rowIterator = sheet.iterator();
            rowIterator.next(); // Skip the header row

            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                HomeBuyerInfo info = new HomeBuyerInfo();
                info.id = (int) row.getCell(0).getNumericCellValue();
                info.grossMonthlyIncome = row.getCell(1).getNumericCellValue();
                info.creditCardPayment = row.getCell(2).getNumericCellValue();
                info.carPayment = row.getCell(3).getNumericCellValue();
                info.studentLoanPayments = row.getCell(4).getNumericCellValue();
                info.appraisedValue = row.getCell(5).getNumericCellValue();
                info.downPayment = row.getCell(6).getNumericCellValue();
                info.loanAmount = row.getCell(7).getNumericCellValue();
                info.monthlyMortgagePayment = row.getCell(8).getNumericCellValue();
                info.creditScore = (int) row.getCell(9).getNumericCellValue();

                homeBuyerInfoList.add(info);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return homeBuyerInfoList;
    }

    public static void main(String[] args) {
        String excelFilePath = "C:\\Users\\nabil\\OneDrive\\Documents\\HackUTD-2023-HomeBuyerInfo\\HackUTD-2023-HomeBuyerInfo.xlsx"; // change this to the filepath of the excel file
        FileHandler fileHandler = new FileHandler();
        List<HomeBuyerInfo> list = fileHandler.readExcelFile(excelFilePath);
    }
}
