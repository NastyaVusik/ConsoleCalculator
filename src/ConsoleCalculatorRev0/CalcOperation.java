package ConsoleCalculatorRev0;

import java.time.LocalDate;

public class CalcOperation {

    //Create variables
    double num1;
    double num2;
    String action;
    double result;
    LocalDate createdDate = LocalDate.now();


    public CalcOperation(double num1, double num2, String action) {
        this.num1 = num1;
        this.num2 = num2;
        this.action = action;
    }

    public CalcOperation(double num1, double num2, String action, double result, LocalDate createdDate) {
        this.num1 = num1;
        this.num2 = num2;
        this.action = action;
        this.result = result;
        this.createdDate = createdDate;
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

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
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
