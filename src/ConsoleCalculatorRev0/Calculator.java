package ConsoleCalculatorRev0;

import ConsoleCalculatorRev0.CalculationHistory.FileHistory;
import ConsoleCalculatorRev0.CalculationHistory.History;
import ConsoleCalculatorRev0.CalculationHistory.InMemoryHistory;
import ConsoleCalculatorRev0.CalculatorUsers.CalculatorUser;

public class Calculator {

    //Date and time

//    LocalDateTime now = LocalDateTime.now();
//    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
//    String formatDateTime = now.format(formatter);


    //Create object, which belongs to class FileHistory
    History fileHistory = new FileHistory();


    //Create object, which belongs to class InMemoryHistory
    InMemoryHistory inMemoryHistory = new InMemoryHistory();


    //Method for realisation of operations with numbers
    public double calculateResult(CalcOperation calcOperation, CalculatorUser calculatorUser) {            //Pass object calcOperation instead (double num1, double num2, String action)

        switch (calcOperation.getAction()) {
            case ("+") -> {
                double res1 = calcOperation.getNum1() + calcOperation.getNum2();
                CalcOperation calcOperation1 = new CalcOperation(calcOperation.getNum1(), calcOperation.getNum2(), calcOperation.getAction(), res1, calcOperation.getFormatDateTime(), calculatorUser.getUserID());                 //Create object of class CalcOperation
                fileHistory.writeHistory(calcOperation1, calculatorUser);
                inMemoryHistory.writeHistory(calcOperation1, calculatorUser);
                return res1;
            }
            case ("-") -> {
                double res2 = calcOperation.getNum1() - calcOperation.getNum2();
                CalcOperation calcOperation2 = new CalcOperation(calcOperation.getNum1(), calcOperation.getNum2(), calcOperation.getAction(), res2, calcOperation.getFormatDateTime(), calculatorUser.getUserID());                 //Create object of class CalcOperation
                fileHistory.writeHistory(calcOperation2, calculatorUser);
                inMemoryHistory.writeHistory(calcOperation2, calculatorUser);
                return res2;
            }
            case ("*") -> {
                double res3 = calcOperation.getNum1() * calcOperation.getNum2();
                CalcOperation calcOperation3 = new CalcOperation(calcOperation.getNum1(), calcOperation.getNum2(), calcOperation.getAction(), res3, calcOperation.getFormatDateTime(), calculatorUser.getUserID());                 //Create object of class CalcOperation
                fileHistory.writeHistory(calcOperation3, calculatorUser);
                inMemoryHistory.writeHistory(calcOperation3, calculatorUser);
                return res3;
            }
            case ("/") -> {
                double res4 = calcOperation.getNum1() / calcOperation.getNum2();
                CalcOperation calcOperation4 = new CalcOperation(calcOperation.getNum1(), calcOperation.getNum2(), calcOperation.getAction(), res4, calcOperation.getFormatDateTime(), calculatorUser.getUserID());                 //Create object of class CalcOperation
                fileHistory.writeHistory(calcOperation4, calculatorUser);
                inMemoryHistory.writeHistory(calcOperation4, calculatorUser);
                return res4;
            }
        }
//        return 0;
        throw new RuntimeException();
    }

}

