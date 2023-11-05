package homebuy;

import java.util.*;

public class HomeBuyer {
    // Attributes
    private String id;
    private double grossMonthlyIncome;
    private double monthlyCarPayment;
    private double monthlyCreditCardPayment;
    private double studentLoanPayment;
    private double homeAppraisedValue;
    private double estimatedMonthlyMortgagePayment;
    private double downPaymentAmount;
    private int creditScore;

    // Constructor
    public HomeBuyer(String id, double grossMonthlyIncome, double monthlyCarPayment, 
                     double monthlyCreditCardPayment, double studentLoanPayment, 
                     double homeAppraisedValue, double estimatedMonthlyMortgagePayment, 
                     double downPaymentAmount, int creditScore) {
        this.id = id;
        this.grossMonthlyIncome = grossMonthlyIncome;
        this.monthlyCarPayment = monthlyCarPayment;
        this.monthlyCreditCardPayment = monthlyCreditCardPayment;
        this.studentLoanPayment = studentLoanPayment;
        this.homeAppraisedValue = homeAppraisedValue;
        this.estimatedMonthlyMortgagePayment = estimatedMonthlyMortgagePayment;
        this.downPaymentAmount = downPaymentAmount;
        this.creditScore = creditScore;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public int getCreditScore() {
        return creditScore;
    }

    public void setCreditScore(int creditScore) {
        this.creditScore = creditScore;
    }

    // Add methods for calculating DTI, LTV, FEDTI here
}
