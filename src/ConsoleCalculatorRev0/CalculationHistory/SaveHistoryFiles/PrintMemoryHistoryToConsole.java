package ConsoleCalculatorRev0.CalculationHistory.SaveHistoryFiles;

import ConsoleCalculatorRev0.CalculationHistory.InMemoryHistory;
import ConsoleCalculatorRev0.ConsoleWriter;

import java.util.ArrayList;

public class PrintMemoryHistoryToConsole {

    //Create object of class ConsoleWriter
    ConsoleWriter consoleWriter = new ConsoleWriter();
    ArrayList <String> memoryHistory;
    InMemoryHistory inMemoryHistory;

    public PrintMemoryHistoryToConsole(){
    }

    public PrintMemoryHistoryToConsole(ArrayList <String> memoryHistory){
        this.memoryHistory = memoryHistory;
    }

    public PrintMemoryHistoryToConsole(InMemoryHistory inMemoryHistory) {
        this.inMemoryHistory = inMemoryHistory;
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
