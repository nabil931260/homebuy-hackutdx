package homebuy;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class App {
    private static final int MIN_CREDIT_RATING = 640;
    private static final double LTV_THRESHOLD = 0.80;
    private static final double MAX_DTI = 0.43;
    private static final double MAX_FEDTI = 0.28;

    public static void main(String[] args) {
        List<HomeBuyer> homeBuyers = new ArrayList<>();

        try {
            FileInputStream excelFile = new FileInputStream("HackUTD-2023-HomeBuyerInfo.xlsx");
            Workbook workbook = new XSSFWorkbook(excelFile);
            Sheet sheet = workbook.getSheetAt(0);

            Iterator<Row> rowIterator = sheet.iterator();

            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                
                // Skip the header row
                if (row.getRowNum() == 0) {
                    continue;
                }

                HomeBuyer homeBuyer = createHomeBuyerFromRow(row);
                homeBuyers.add(homeBuyer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (HomeBuyer buyer : homeBuyers) {
            boolean isApproved = isHomeBuyerApproved(buyer);
            String approvalStatus = isApproved ? "Approved" : "Not Approved";
            System.out.println("Homebuyer ID: " + buyer.getId() + " - " + approvalStatus);

            if (!isApproved) {
                // Provide suggestions for potential homebuyers who are not approved
                List<String> suggestions = generateSuggestions(buyer);
                for (String suggestion : suggestions) {
                    System.out.println("Suggestion: " + suggestion);
                }
            }
        }
    }

    private static HomeBuyer createHomeBuyerFromRow(Row row) {
        int id = (int) row.getCell(0).getNumericCellValue();
        double grossMonthlyIncome = row.getCell(1).getNumericCellValue();
        double creditCardPayment = row.getCell(2).getNumericCellValue();
        double carPayment = row.getCell(3).getNumericCellValue();
        double studentLoanPayments = row.getCell(4).getNumericCellValue();
        double appraisedValue = row.getCell(5).getNumericCellValue();
        double downPayment = row.getCell(6).getNumericCellValue();
        double loanAmount = row.getCell(7).getNumericCellValue();
        int creditScore = (int) row.getCell(8).getNumericCellValue();

        return new HomeBuyer(id, grossMonthlyIncome, creditCardPayment, carPayment, studentLoanPayments, appraisedValue, downPayment, loanAmount, creditScore);
    }

    private static boolean isHomeBuyerApproved(HomeBuyer homeBuyer) {
        return homeBuyer.getCreditScore() >= MIN_CREDIT_RATING
                && homeBuyer.calculateLTV() < LTV_THRESHOLD
                && homeBuyer.calculateDTI() <= MAX_DTI
                && homeBuyer.calculateFEDTI() <= MAX_FEDTI;
    }

    private static List<String> generateSuggestions(HomeBuyer homeBuyer) {
        List<String> suggestions = new ArrayList<>();
        // Add suggestions based on the criteria you specified
        if (homeBuyer.getCreditScore() < MIN_CREDIT_RATING) {
            suggestions.add("Improve your credit score.");
        }
        if (homeBuyer.calculateLTV() >= LTV_THRESHOLD) {
            suggestions.add("Consider a larger down payment to reduce the LTV ratio.");
        }
        if (homeBuyer.calculateDTI() > MAX_DTI) {
            suggestions.add("Lower your monthly debt payments to meet the DTI criteria.");
        }
        if (homeBuyer.calculateFEDTI() > MAX_FEDTI) {
            suggestions.add("Adjust your car payment to meet the FEDTI criteria.");
        }
        return suggestions;
    }
}
