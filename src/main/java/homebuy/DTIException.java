package homebuy;

public class DTIException extends Exception{
    private double DTI;
    private String errorString;

    public DTIException(double DTI) {
        this.DTI = DTI;
        this.errorString = "Your debt to income ratio of " + this.DTI + "is too high for approval.\n" +
        "You can learn how to lower your debt to income ratio here: https://www.prosper.com/blog/how-can-you-lower-your-debt-to-income-ratio";
    }

    @Override
    public String toString() {
        return this.errorString;
    }
}
