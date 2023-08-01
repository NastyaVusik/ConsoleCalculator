package ConsoleCalculatorRev0;

import java.time.LocalDate;

public class ConsoleCalculator {

    //Create variables
    double num1;
    double num2;
    String action;
    double result;
    LocalDate createdDate;

//    public ConsoleCalculator(double num1, double num2, String action) {
//        this.num1 = num1;
//        this.num2 = num2;
//        this.action = action;
//    }
//
//    public ConsoleCalculator(double num1, double num2, String action, double result) {
//        this.num1 = num1;
//        this.num2 = num2;
//        this.action = action;
//        this.result = result;
//    }


    //Create object, which belongs to class FileHistory
    FileHistory fileHistory = new FileHistory();


    //Method for realisation of operations with numbers
    public double calculateResult(double num1, double num2, String action) {

        switch (action) {
            case ("sum"):
                double res1 = num1 + num2;
                fileHistory.writeHistory(num1, num2, action, res1);
                return res1;
            break;

            case ("deduct"):
                double res2 = num1 - num2;
                fileHistory.writeHistory(num1, num2, action, res2);
                return res2;
            break;

            case ("mult"):
                double res3 = num1 * num2;
                fileHistory.writeHistory(num1, num2, action, res3);
                return res3;
            break;

            case ("divide"):
                double res4 = num1 / num2;
                fileHistory.writeHistory(num1, num2, action, res4);
                return res4;
            break;
        }
        return 0;
    }


    //Getters and setters

    public double getNum1() {
        return num1;
    }

    public void setNum1(double num1) {
        this.num1 = num1;
    }

    public double getNum2() {
        return num2;
    }

    public void setNum2(double num2) {
        this.num2 = num2;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "Operation { " + "num1 = " + num1 + "  " +
                ", num2 = " + num2 + "  " +
                ", action = " + action + "  " +
                ", result = " + result + "  " +
                ", date is " + createdDate + " }";
    }
}

