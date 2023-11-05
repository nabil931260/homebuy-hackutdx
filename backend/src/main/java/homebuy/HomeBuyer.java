package homebuy;

public class HomeBuyer {
    // Attributes
    private int id;
    private double grossMonthlyIncome;
    private double monthlyCreditCardPayment;
    private double monthlyCarPayment;
    private double studentLoanPayment;
    private double homeAppraisedValue;
    private double estimatedMonthlyMortgagePayment;
    private double downPaymentAmount;
    private double loanAmount;
    private int creditScore;
    private double LTV;
    private double DTI;
    private double FEDTI;
    private double PMI;

    private LowCreditScoreException LowCreditScoreException;
    private LTVException LTVException;
    private DTIException DTIException;
    private FEDTIException FEDTIException;
    private boolean isApproved;

    // Constructor
    public HomeBuyer(int id, double grossMonthlyIncome, double monthlyCarPayment, 
                     double monthlyCreditCardPayment, double studentLoanPayment, 
                     double homeAppraisedValue, double estimatedMonthlyMortgagePayment, 
                     double downPaymentAmount, double loanAmount, int creditScore) {
        this.id = id;
        this.grossMonthlyIncome = grossMonthlyIncome;
        this.monthlyCarPayment = monthlyCarPayment;
        this.monthlyCreditCardPayment = monthlyCreditCardPayment;
        this.studentLoanPayment = studentLoanPayment;
        this.homeAppraisedValue = homeAppraisedValue;
        this.estimatedMonthlyMortgagePayment = estimatedMonthlyMortgagePayment;
        this.downPaymentAmount = downPaymentAmount;
        this.loanAmount = loanAmount;
        this.creditScore = creditScore;
        calculateLTV();
        calculateDTI();
        calculateFEDTI();
        this.PMI = 0.0;
        this.LowCreditScoreException = null;
        this.LTVException = null;
        this.DTIException = null;
        this.FEDTIException = null;
        checkApproval();
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getGrossMonthlyIncome() {
        return grossMonthlyIncome;
    }

    public void setGrossMonthlyIncome(double grossMonthlyIncome) {
        this.grossMonthlyIncome = grossMonthlyIncome;
    }

    public double getMonthlyCarPayment() {
        return monthlyCarPayment;
    }

    public void setMonthlyCarPayment(double monthlyCarPayment) {
        this.monthlyCarPayment = monthlyCarPayment;
    }

    public double getMonthlyCreditCardPayment() {
        return monthlyCreditCardPayment;
    }

    public void setMonthlyCreditCardPayment(double monthlyCreditCardPayment) {
        this.monthlyCreditCardPayment = monthlyCreditCardPayment;
    }

    public double getStudentLoanPayment() {
        return studentLoanPayment;
    }

    public void setStudentLoanPayment(double studentLoanPayment) {
        this.studentLoanPayment = studentLoanPayment;
    }

    public double getHomeAppraisedValue() {
        return homeAppraisedValue;
    }

    public void setHomeAppraisedValue(double homeAppraisedValue) {
        this.homeAppraisedValue = homeAppraisedValue;
    }

    public double getEstimatedMonthlyMortgagePayment() {
        return estimatedMonthlyMortgagePayment;
    }

    public void setEstimatedMonthlyMortgagePayment(double estimatedMonthlyMortgagePayment) {
        this.estimatedMonthlyMortgagePayment = estimatedMonthlyMortgagePayment;
    }

    public double getDownPaymentAmount() {
        return downPaymentAmount;
    }

    public void setDownPaymentAmount(double downPaymentAmount) {
        this.downPaymentAmount = downPaymentAmount;
    }

    public double getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(double loanAmount) {
        this.loanAmount = loanAmount;
    }

    public int getCreditScore() {
        return creditScore;
    }

    public void setCreditScore(int creditScore) {
        this.creditScore = creditScore;
    }

    // Add methods for calculating DTI, LTV, FEDTI here
    private void calculateLTV() {
        this.LTV = this.loanAmount / this.homeAppraisedValue;
    }

    public double getLTV() {
        return this.LTV;
    }

    private void calculateDTI() {
        this.DTI = (this.monthlyCarPayment + this.monthlyCreditCardPayment + this.studentLoanPayment + this.estimatedMonthlyMortgagePayment) / this.grossMonthlyIncome;
    }

    public double getDTI() {
        return this.DTI;
    }

    private void calculateFEDTI() {
        this.FEDTI = this.estimatedMonthlyMortgagePayment / this.grossMonthlyIncome;
    }

    public double getFEDTI() {
        return this.FEDTI;
    }

    public double getPMI() {
        return this.PMI;
    }

    public void setPMI(double PMI) {
        this.PMI = PMI;
    }

    public LowCreditScoreException getLowCreditScoreException() {
        return this.LowCreditScoreException;
    }

    public void setLowCreditScoreException(LowCreditScoreException e) {
        this.LowCreditScoreException = e;
    }

    public LTVException getLTVException() {
        return this.LTVException;
    }

    public void setLTVException(LTVException e) {
        this.LTVException = e;
    }

    public DTIException getDTIException() {
        return this.DTIException;
    }
    

    public void setDTIException(DTIException e) {
        this.DTIException = e;
    }

    public FEDTIException getFEDTIException() {
        return this.FEDTIException;
    }

    public void setFEDTIException(FEDTIException e) {
        this.FEDTIException = e;
    }

    public void checkApproval() {
        if (LowCreditScoreException == null && LTVException == null && DTIException == null && FEDTIException == null) {
            this.isApproved = true;
        }
        else {
            this.isApproved = false;
        }
    }

    public boolean getIsApproved() {
        return this.isApproved;
    }

    public void setIsApproved(boolean approved) {
        this.isApproved = approved;
    }

    public void updateMortgagePMI() {
        double newMortgage = (this.estimatedMonthlyMortgagePayment * this.PMI);
        this.estimatedMonthlyMortgagePayment += newMortgage;
    }
}
