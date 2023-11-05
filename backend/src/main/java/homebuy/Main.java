package homebuy;

public class Main {
    public static void main(String[] args) {
        HomeBuyer Alex = new HomeBuyer(1, 3103.00, 317.00, 374.00, 250.00, 268468.00, 32216.16, 236251.84, 1127.90, 778);
        LoadEval AlexEval = new LoadEval(Alex);
        AlexEval.evalHomeBuyer();
    }
}