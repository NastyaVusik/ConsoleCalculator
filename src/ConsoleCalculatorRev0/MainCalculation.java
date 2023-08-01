package ConsoleCalculatorRev0;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class MainCalculation {
    public static void main(String[] args) {

        //Create object of class ConsoleCalculator
        ConsoleCalculator consoleCalculator = new ConsoleCalculator();

        //Create object of class ConsoleReader
        ConsoleReader consoleReader = new ConsoleReader();

       System.out.print("Enter the number num1: ");
        double num1 = consoleReader.readNumbers();

        System.out.print("Enter the number num2: ");
        double num2 = consoleReader.readNumbers();

        System.out.print("Enter the operation with this numbers: ");
        String action = consoleReader.readAction();


        double result = consoleCalculator.calculateResult(num1, num2, action);
        System.out.println("Result of calculation: " + result);
    }






        }

