package ConsoleCalculatorRev0;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class MainCalculation {
    public static void main(String[] args) {

        //Create object of calculator
        ConsoleCalculator consoleCalculator = new ConsoleCalculator();

       System.out.print("Enter the number num1: ");
        double num1 = readNumbers();

        System.out.print("Enter the number num2: ");
        double num2 = readNumbers();

        System.out.print("Enter the operation with this numbers: ");
        String action = readAction();
        double result = consoleCalculator.calculateResult(num1, num2, action);
        System.out.println("Calculate result: " + result);
        writeHistory(num1, num2, action, result);
    }
        //Write history of calculations

        static void writeHistory(double num1, double num2; String action; double result)
    {
        File file = new File("history.txt");
        try {
            FileWriter fileWriter = new FileWriter(file, true);
            fileWriter.write("num1: " + num1 + " num2: " + num2 + " action: " + action + " =result: " + result);
            fileWriter.write(10);
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




        }

