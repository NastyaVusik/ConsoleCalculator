package ConsoleCalculatorRev0;

import java.time.LocalDate;

public class ConsoleCalculator {

//    //Create variables
//    double num1;
//    double num2;
//    String action;
//    double result;
    LocalDate createdDate = LocalDate.now();

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
    History fileHistory = new FileHistory();


    //Create object, which belongs to class InMemoryHistory
    InMemoryHistory inMemoryHistory = new InMemoryHistory();


    //Method for realisation of operations with numbers
    public double calculateResult(double num1, double num2, String action) {

        switch (action) {
            case ("sum"):
                double res1 = num1 + num2;
                CalcOperation calcOperation1 = new CalcOperation(num1, num2, action, res1, createdDate);                 //Create object of class CalcOperation

                fileHistory.writeHistory(calcOperation1);
                inMemoryHistory.writeHistory(calcOperation1);
                inMemoryHistory.printArrayList();
                return res1;

            case ("deduct"):
                double res2 = num1 - num2;
                CalcOperation calcOperation2 = new CalcOperation(num1, num2, action, res2, createdDate);                 //Create object of class CalcOperation

                fileHistory.writeHistory(calcOperation2);
                inMemoryHistory.writeHistory(calcOperation2);
                inMemoryHistory.printArrayList();
                return res2;

            case ("mult"):
                double res3 = num1 * num2;
                CalcOperation calcOperation3 = new CalcOperation(num1, num2, action, res3, createdDate);                 //Create object of class CalcOperation

                fileHistory.writeHistory(calcOperation3);
                inMemoryHistory.writeHistory(calcOperation3);
                inMemoryHistory.printArrayList();
                return res3;

            case ("divide"):
                double res4 = num1 / num2;
                CalcOperation calcOperation4 = new CalcOperation(num1, num2, action, res4, createdDate);                 //Create object of class CalcOperation

                fileHistory.writeHistory(calcOperation4);
                inMemoryHistory.writeHistory(calcOperation4);
                inMemoryHistory.printArrayList();
                return res4;
        }
        return 0;
    }



    //Getters and setters
        public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }


//
//    public double getNum1() {
//        return num1;
//    }
//
//    public void setNum1(double num1) {
//        this.num1 = num1;
//    }
//
//    public double getNum2() {
//        return num2;
//    }
//
//    public void setNum2(double num2) {
//        this.num2 = num2;
//    }
//
//    public String getAction() {
//        return action;
//    }
//
//    public void setAction(String action) {
//        this.action = action;
//    }
//
//    public double getResult() {
//        return result;
//    }
//
//    public void setResult(double result) {
//        this.result = result;
//    }


//    @Override
//    public String toString() {
//        return "Operation { " + "num1 = " + num1 + "  " +
//                ", num2 = " + num2 + "  " +
//                ", action = " + action + "  " +
//                ", result = " + result + "  " +
//                ", date is " + createdDate + " }";
//    }
}

