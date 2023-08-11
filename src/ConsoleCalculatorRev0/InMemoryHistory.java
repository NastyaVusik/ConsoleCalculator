package ConsoleCalculatorRev0;

import java.time.LocalDate;
import java.util.ArrayList;

public class InMemoryHistory implements History{

   //Create ArrayList to keep history in memory
    ArrayList <String> memoryHistory = new ArrayList<>();

    //Create object of class ConsoleWriter
    ConsoleWriter consoleWriter = new ConsoleWriter();



    //Method for writing history of calculations in memory
    @Override
    public void writeHistory(CalcOperation calcOperation){
        memoryHistory.add("num1: " + calcOperation.num1 + " num2: " + calcOperation.num2 + " action: " + calcOperation.action + " =result: " + calcOperation.result +
                ", Date and time of operation: " + calcOperation.getFormatDateTime());
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
