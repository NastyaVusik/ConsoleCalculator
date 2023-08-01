package ConsoleCalculatorRev0;

public class ConsoleCalculator {

    public ConsoleCalculator(double num1, double num2, String action){
        this.num1 = num1;
        this.num2 = num2;
        this.action = action;
    }

    //Method for realisation of operations with numbers

    static double calculateResult(double num1, double num2, String action) {
        switch(action) {
            case ("sum"):
                return num1 + num2;
            break;

            case ("deduct"):
                return  num1 - num2;
            break;

            case ("mult"):
                return num1 * num2;
            break;

            case ("divide"):
                return num1 / num2;
            break;
        }
        return 0;
    }
}
}
