package homebuy;

public class LowCreditScoreException extends Exception {
    private int creditScore;
    private String errorString;

    public LowCreditScoreException(int creditScore) {
        this.creditScore = creditScore;
        this.errorString = "Your credit score of " + this.creditScore + " is too low for approval.\n" + 
        "You can learn how to improve your credit score here: https://www.investopedia.com/how-to-improve-your-credit-score-4590097";
    }

    @Override
    public String toString() {
        return this.errorString;
    }
}
