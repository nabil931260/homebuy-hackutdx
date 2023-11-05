package homebuy;

public class DTIException extends Exception{
    private double DTI;
    private String errorString;

    public DTIException(double DTI) {
        this.DTI = DTI;
        this.errorString = "Your debt to income ratio of " + this.DTI + "is too high for approval.\n" +
        "An ideal debt to income ratio will be 43% or lower, since this is the highest amount lenders will accept. A debt to income ratio of below 36% is preferred, with no more than 28% of the debt going towards a mortgage." +
        "You can learn how to lower your debt to income ratio here: https://www.prosper.com/blog/how-can-you-lower-your-debt-to-income-ratio";
    }

    @Override
    public String toString() {
        return this.errorString;
    }
}
