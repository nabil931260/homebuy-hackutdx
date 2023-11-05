package homebuy;


public class LTVException extends Exception{
    private double LTV;
    private String errorString;

    public LTVException(double LTV, boolean PMI) {
        this.LTV = LTV;
        if (!PMI) {
            this.errorString = "Your loan to value ratio of " + this.LTV + " is too high for approval.\n" +
            "An ideal loan to value ratio will be 80% or lower.\n" +
            "You can learn how to lower your loan to value ratio here: https://wealthfit.com/articles/loan-to-value-ratio/";
        }
        else {
            this.errorString = "Your loan to value ratio of " + this.LTV + " allows you to get approval with Private Mortgage Insurance.\n" +
            "Private Mortgage Insurance is required until your loan to value ratio falls below 80%.\n" +
            "You can learn how to lower your loan to value ratio here: https://wealthfit.com/articles/loan-to-value-ratio/";
        }
    }

    @Override
    public String toString() {
        return this.errorString;
    }
}
