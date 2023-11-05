package homebuy;
import java.util.*;
import homebuy.LowCreditScoreException;
import homebuy.LTVException;

public class LoadEval {
    private HomeBuyer buyer;
    // Constants
    private final int MIN_CREDIT_SCORE = 640;
    private final double MAX_LTV = 0.95; 
    private final double MAX_DTI = 0.43; 
    private final double MAX_FEDTI = 0.28; 

    public LoadEval(HomeBuyer buyer) {
        this.buyer = buyer;
    }

    public void evalHomeBuyer(HomeBuyer buyer) {
        double LTV = buyer.calculateLTV();
        double DTI = buyer.calculateDTI();
        double FEDTI = buyer.calculateFEDTI();
        boolean approved = true;
        boolean PMI = false;
        LowCreditScoreException creditScoreException = null;
        LTVException LTVException = null;
        DTIException DTIException = null;
        FEDTIException FEDTIException = null;

        if (buyer.creditScore < MIN_CREDIT_SCORE) {
            approved = false;
            creditScoreException = new LowCreditScoreException(buyer.creditScore);
        }
        if (LTV > MAX_LTV) {
            approved = false;
            LTVException = new LTVException(LTV);
        }
        else if (LTV > 0.80) {
            PMI = true;
        }
        if (DTI > MAX_DTI) {
            approved = false;
            DTIException = new DTIException(DTI);
        }
        if (FEDTI > MAX_FEDTI) {
            approved = false;
            FEDTIException = new FEDTIException(FEDTI);
        }

        if (approved) {
            System.out.println("Congratulations! You have been approved.");
        }
        //Display the feedback for each exception that exists.
        else {
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