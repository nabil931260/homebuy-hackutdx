package homebuy;

public class HomeBuyer {
    private int id;
    private double grossMonthlyIncome;
    private double creditCardPayment;
    private double carPayment;
    private double studentLoanPayments;
    private double appraisedValue;
    private double downPayment;
    private double loanAmount;
    private int creditScore;

    // Constructor
    public HomeBuyer(int id, double grossMonthlyIncome, double creditCardPayment, double carPayment, double studentLoanPayments, double appraisedValue, double downPayment, double loanAmount, int creditScore) {
        this.id = id;
        this.grossMonthlyIncome = grossMonthlyIncome;
        this.creditCardPayment = creditCardPayment;
        this.carPayment = carPayment;
        this.studentLoanPayments = studentLoanPayments;
        this.appraisedValue = appraisedValue;
        this.downPayment = downPayment;
        this.loanAmount = loanAmount;
        this.creditScore = creditScore;
    }

    // Calculate Loan-to-Value (LTV) Ratio
    public double calculateLTV() {
        return loanAmount / appraisedValue;
    }

    // Calculate Debt-to-Income (DTI) Ratio
    public double calculateDTI() {
        double totalDebt = creditCardPayment + carPayment + studentLoanPayments;
        return totalDebt / grossMonthlyIncome;
    }

    // Calculate Front-End Debt-to-Income (FEDTI) Ratio
    public double calculateFEDTI() {
        return carPayment / grossMonthlyIncome;
    }

    // Getters and Setters for other attributes

    public int getId() {
        return id;
    }

    public double getGrossMonthlyIncome() {
        return grossMonthlyIncome;
    }

    public double getCreditCardPayment() {
        return creditCardPayment;
    }

    public double getCarPayment() {
        return carPayment;
    }

    public double getStudentLoanPayments() {
        return studentLoanPayments;
    }

    public double getAppraisedValue() {
        return appraisedValue;
    }

    public double getDownPayment() {
        return downPayment;
    }

    public double getLoanAmount() {
        return loanAmount;
    }

    public int getCreditScore() {
        return creditScore;
    }
}
