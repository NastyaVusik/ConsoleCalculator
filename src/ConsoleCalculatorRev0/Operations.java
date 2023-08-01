package ConsoleCalculatorRev0;

import java.time.LocalDate;

public class Operations {


    //Variables
     double num1 = readNumbers();
     double num2 = readNumbers();
     String action = readAction();
     double result = 0;
    LocalDate createdDate;


    //Constructor with three parameters
    public Operations(double num1, double num2, String action) {
        this.num1 = num1;
        this.num2 = num2;
        this.action = action;
    }

    //Constructor with four parameters
    public Operations(double num1, double num2, String action, double result) {
        this.num1 = num1;
        this.num2 = num2;
        this.action = action;
        this.result = result;
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
    public String toString(){
        return "Operstion { " + "num1 = " + num1 + "  " +
                ", num2 = " + num2 + "  " +
                ", action = " + action + "  " +
                ", result = " + result + "  " +
                ", date is " + createdDate + " }";

    }
}