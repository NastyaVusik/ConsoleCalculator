package ConsoleCalculatorRev0;

public class OperationService {

    //Method for realisation of operations with numbers

    static double getResult(double num1, double num2, String action) {
        switch(action) {
            case ("sum"):
                result =  num1 + num2;
                return result;
            break;

            case ("deduct"):
                result =  num1 - num2;
                return result;
            break;

            case ("mult"):
                result =  num1 * num2;
                return result;
            break;

            case ("divide"):
                result =  num1 / num2;
                return result;
            break;
        }
        return result;
    }
}
