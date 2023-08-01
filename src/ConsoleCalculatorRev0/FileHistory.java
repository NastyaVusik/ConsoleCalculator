package ConsoleCalculatorRev0;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileHistory {

    //Write history of calculations
    public void writeHistory(double num1, double num2, String action, double result)
    {
        File file = new File("history.txt");
        FileWriter fileWriter;
        try {
             fileWriter = new FileWriter(file, true);
            fileWriter.write("num1: " + num1 + " num2: " + num2 + " action: " + action + " =result: " + result);
            fileWriter.write(10);
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
}
