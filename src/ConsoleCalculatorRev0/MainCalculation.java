package ConsoleCalculatorRev0;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class MainCalculation {
    public static void main(String[] args) {

        //Create object of class ConsoleCalculator
        ConsoleCalculator consoleCalculator = new ConsoleCalculator();

        //Create object of class ConsoleReader
        ConsoleReader consoleReader = new ConsoleReader();

        //Create object of class ConsoleWriter
        ConsoleWriter consoleWriter = new ConsoleWriter();

        //Create object of class InMemoryHistory
        InMemoryHistory inMemoryHistory = new InMemoryHistory();

        //Create object of class StartApplication
        StartApplication startApplication = new StartApplication();

startApplication.start();


//        consoleWriter.printMessage("Enter the number num1: ");
//        double num1 = consoleReader.readNumbers();
//
//        consoleWriter.printMessage("Enter the number num2: ");
//        double num2 = consoleReader.readNumbers();
//
//consoleWriter.printMessage("Enter the operation with this numbers: ");
//        String action = consoleReader.readAction();
//
//        double result = consoleCalculator.calculateResult(new CalcOperation(num1, num2, action));                  //(num1, num2, action)
//        consoleWriter.printMessage("Result of calculation: " + result);
//
//        consoleWriter.printMessage("Date and time of operation: " + consoleCalculator.getCreatedDate());
//
//        System.out.println(inMemoryHistory.printArrayList());               //???????????????????????????????????????????????????????



    }






        }

