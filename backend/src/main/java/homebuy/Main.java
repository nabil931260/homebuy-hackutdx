package homebuy;
import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {
        ArrayList<HomeBuyer> approved = new ArrayList<HomeBuyer>();
        ArrayList<HomeBuyer> denied = new ArrayList<HomeBuyer>();
        HomeBuyer Alex = new HomeBuyer(1, 3103.00, 317.00, 374.00, 250.00, 268468.00, 32216.16, 236251.84, 1127.90, 778);
        LoadEval AlexEval = new LoadEval(Alex);
        AlexEval.evalHomeBuyer();

        if (!Alex.getIsApproved()) {
            approved.add(Alex);
        }
        else {
            denied.add(Alex);
        }
    }
}