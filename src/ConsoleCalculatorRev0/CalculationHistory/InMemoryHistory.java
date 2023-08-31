package ConsoleCalculatorRev0.CalculationHistory;

import ConsoleCalculatorRev0.Objects.CalcOperation;

import ConsoleCalculatorRev0.Objects.CalculatorUser;
import ConsoleCalculatorRev0.IO.ConsoleWriter;
import ConsoleCalculatorRev0.UserSession.ConsoleSessions;

import java.util.ArrayList;

public class InMemoryHistory implements History {

   //Create ArrayList to keep history in memory
   protected ArrayList <String> memoryHistory = new ArrayList<>();


    //Create object of class ConsoleWriter
    ConsoleWriter consoleWriter = new ConsoleWriter();

//    ConsoleSessions currentSession = new ConsoleSessions();


    //Method for writing history of calculations in memory
    @Override
    public void writeHistory(CalcOperation calcOperation){
        memoryHistory.add("num1: " + calcOperation.getNum1() + " num2: " + calcOperation.getNum2() + " action: " + calcOperation.getAction() +
                " =result: " + calcOperation.getResult() + ", Date and time of operation: " + calcOperation.getFormatDateTime());

    }


    @Override
    public void writeHistoryWithUser(CalcOperation calcOperation, CalculatorUser calculatorUser){
        memoryHistory.add("num1: " + calcOperation.getNum1() + " num2: " + calcOperation.getNum2() + " action: " + calcOperation.getAction() +
                " =result: " + calcOperation.getResult() + ", Date and time of operation: " + calcOperation.getFormatDateTime() +", User ID: " + calculatorUser.getUserID());
    }


    @Override
    public ArrayList<String> getOperationHistory(){
        return memoryHistory;
    }




//    //Method for print ArrayList in console
//    public void printArrayList(){
//
//        consoleWriter.printMessage("\n\nHistory of calculation in ArrayList:\n ");
//
//        for(String history : memoryHistory){
//            consoleWriter.printMessage(history);
//        }
//
//        consoleWriter.printMessage("\n\n");
//    }


}
