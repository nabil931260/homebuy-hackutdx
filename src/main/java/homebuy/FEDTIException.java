package homebuy;

public class FEDTIException extends Exception{
    private double FEDTI;
    private String errorString;

    public FEDTIException(double FEDTI) {
        this.FEDTI = FEDTI;
        this.errorString = "Your front-end debt to income ratio of " + this.FEDTI + " is too high for approval.\n" + 
        "You can learn how to lower your front-end debt to income ratio here: https://www.investopedia.com/terms/f/front-end-debt-to-income-ratio.asp";
    }

    @Override
    public String toString() {
        return this.errorString;
    }
}
