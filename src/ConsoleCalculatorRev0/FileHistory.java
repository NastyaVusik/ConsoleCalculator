package ConsoleCalculatorRev0;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;

public class FileHistory implements History{


    //Write history of calculations
    @Override
    public void writeHistory(CalcOperation calcOperation) {
        File file = new File("history.txt");
        FileWriter fileWriter;
        try {
            fileWriter = new FileWriter(file, true);
            fileWriter.write("num1: " + calcOperation.num1 + " num2: " + calcOperation.num2 + " action: " + calcOperation.action + " =result: " + calcOperation.result +
                    ", Date and time of operation: " + calcOperation.createdDate);
            fileWriter.write(10);
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
}
