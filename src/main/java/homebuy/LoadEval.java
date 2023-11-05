package homebuy;

import javax.sound.midi.SysexMessage;

public class LoadEval {
    private HomeBuyer buyer;
    private double LTV;
    private double DTI;
    private double FEDTI;
    // Constants
    private final int MIN_CREDIT_SCORE = 640;
    private final double MAX_LTV = 0.95; 
    private final double MAX_DTI = 0.43; 
    private final double MAX_FEDTI = 0.28; 

    public LoadEval(HomeBuyer buyer) {
        this.buyer = buyer;
        this.LTV = this.buyer.getLTV();
        this.DTI = this.buyer.getDTI();
        this.FEDTI = this.buyer.getFEDTI();
    }

    public void evalHomeBuyer() {
        boolean approved = true;
        boolean PMI = false;
        LowCreditScoreException creditScoreException = null;
        LTVException LTVException = null;
        DTIException DTIException = null;
        FEDTIException FEDTIException = null;

        if (this.buyer.getCreditScore() < MIN_CREDIT_SCORE) {
            approved = false;
            creditScoreException = new LowCreditScoreException(buyer.getCreditScore());
        }
        if (this.LTV > MAX_LTV) {
            approved = false;
            LTVException = new LTVException(LTV, PMI);
        }
        else if (this.LTV > 0.80) {
            PMI = true;
            LTVException = new LTVException(LTV, PMI);
        }
        if (this.DTI > MAX_DTI) {
            approved = false;
            DTIException = new DTIException(DTI);
        }
        if (this.FEDTI > MAX_FEDTI) {
            approved = false;
            FEDTIException = new FEDTIException(FEDTI);
        }

        if (approved) {
            System.out.println("Congratulations! You have been approved.");
        }
        //Display the feedback for each exception that exists.
        else {
            System.out.println("You have not been approved. Please refer to the feedback below to see how you can improve your application.");
            generateSuggestions(creditScoreException, LTVException, DTIException, FEDTIException);
        }
    }

    private void generateSuggestions(LowCreditScoreException creditScoreException, LTVException LTVException, DTIException DTIException, FEDTIException FEDTIException) {
        if (creditScoreException != null) {
                System.out.println(creditScoreException.toString());
        }
        if (LTVException != null) {
            System.out.println(LTVException.toString());
        }
        if (DTIException != null) {
            System.out.println(DTIException.toString());
        }
        if (FEDTIException != null) {
            System.out.println(FEDTIException.toString());
        }
    }
}