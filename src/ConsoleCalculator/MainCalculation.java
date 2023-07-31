package ConsoleCalculator;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class MainCalculation {
    public static void main(String[] args) {
        double num1 = 2;
        double num2 = 5;
         String action = "mul";
        double result = 0;

    }

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

