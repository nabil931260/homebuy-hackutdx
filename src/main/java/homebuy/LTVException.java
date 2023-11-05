package homebuy;


public class LTVException extends Exception{
    private double LTV;
    private String errorString;

    public LTVException(double LTV) {
        this.LTV = LTV;
        this.errorString = "Your loan to value ratio of " + this.LTV + " is too high for approval.\n" +
        "You can learn how to lower your loan to value ratio here: https://wealthfit.com/articles/loan-to-value-ratio/";
    }

    @Override
    public String toString() {
        return this.errorString;
    }
}
