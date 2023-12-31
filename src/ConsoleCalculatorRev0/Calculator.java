package ConsoleCalculatorRev0;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Calculator {

    //Date and time
    LocalDateTime now = LocalDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
    String formatDateTime = now.format(formatter);


    //Create object, which belongs to class FileHistory
    History fileHistory = new FileHistory();


    //Create object, which belongs to class InMemoryHistory
    InMemoryHistory inMemoryHistory = new InMemoryHistory();


    //Method for realisation of operations with numbers
    public double calculateResult(CalcOperation calcOperation) {            //Pass object calcOperation instead (double num1, double num2, String action)

        switch (calcOperation.getAction()) {
            case ("sum") -> {
                double res1 = calcOperation.num1 + calcOperation.num2;
                CalcOperation calcOperation1 = new CalcOperation(calcOperation.num1, calcOperation.num2, calcOperation.action, res1, calcOperation.getFormatDateTime());                 //Create object of class CalcOperation
                fileHistory.writeHistory(calcOperation1);
                inMemoryHistory.writeHistory(calcOperation1);
                return res1;
            }
            case ("deduct") -> {
                double res2 = calcOperation.num1 - calcOperation.num2;
                CalcOperation calcOperation2 = new CalcOperation(calcOperation.num1, calcOperation.num2, calcOperation.action, res2, calcOperation.getFormatDateTime());                 //Create object of class CalcOperation
                fileHistory.writeHistory(calcOperation2);
                inMemoryHistory.writeHistory(calcOperation2);
                return res2;
            }
            case ("mult") -> {
                double res3 = calcOperation.num1 * calcOperation.num2;
                CalcOperation calcOperation3 = new CalcOperation(calcOperation.num1, calcOperation.num2, calcOperation.action, res3, calcOperation.getFormatDateTime());                 //Create object of class CalcOperation
                fileHistory.writeHistory(calcOperation3);
                inMemoryHistory.writeHistory(calcOperation3);
                return res3;
            }
            case ("divide") -> {
                double res4 = calcOperation.num1 / calcOperation.num2;
                CalcOperation calcOperation4 = new CalcOperation(calcOperation.num1, calcOperation.num2, calcOperation.action, res4, calcOperation.getFormatDateTime());                 //Create object of class CalcOperation
                fileHistory.writeHistory(calcOperation4);
                inMemoryHistory.writeHistory(calcOperation4);
                return res4;
            }
        }
            return 0;
        }



//    //Getters and setters
//
//    public String getFormatDateTime() {
//        return formatDateTime;
//    }
//
//    public void setFormatDateTime(String formatDateTime) {
//        this.formatDateTime = formatDateTime;
//    }
}

