package ConsoleCalculatorRev0.CalculationHistory;

import ConsoleCalculatorRev0.CalcOperation;

import ConsoleCalculatorRev0.CalculatorUsers.CalculatorUser;
import ConsoleCalculatorRev0.ConsoleWriter;
import ConsoleCalculatorRev0.UserSession.CurrentSession;

import java.util.ArrayList;

public class InMemoryHistory implements History {

   //Create ArrayList to keep history in memory
    ArrayList <String> memoryHistory = new ArrayList<>();

    //Create object of class ConsoleWriter
    ConsoleWriter consoleWriter = new ConsoleWriter();

    CurrentSession currentSession = new CurrentSession();



    //Method for writing history of calculations in memory
    @Override
    public void writeHistory(CalcOperation calcOperation, CalculatorUser calculatorUser){
        memoryHistory.add("num1: " + calcOperation.getNum1() + " num2: " + calcOperation.getNum2() + " action: " + calcOperation.getAction() +
                " =result: " + calcOperation.getResult() + ", Date and time of operation: " + calcOperation.getFormatDateTime() +", User ID: " + currentSession.getCurrentUser(calculatorUser));
    }



//Method for print ArrayList in console
    public void printArrayList(){
        consoleWriter.printMessage("\n\nHistory of calculation in ArrayList:\n ");

        for(String history : memoryHistory){
consoleWriter.printMessage(history);
        }

        consoleWriter.printMessage("\n\n");
    }
}
