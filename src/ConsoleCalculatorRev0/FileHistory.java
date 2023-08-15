package ConsoleCalculatorRev0;

import ConsoleCalculatorRev0.CalculatorUsers.CalculatorUser;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;

public class FileHistory implements History{

    //Create object of class CalculatorUser
    CalculatorUser calculatorUser;


    //Write history of calculations
    @Override
    public void writeHistory(CalcOperation calcOperation) {
        File file = new File("src/ConsoleCalculatorRev0/SaveHistoryFiles" + calculatorUser.getNewUserName() + ".txt");
        FileWriter fileWriter;
        try {
            fileWriter = new FileWriter(file, true);
            fileWriter.write("num1: " + calcOperation.num1 + " num2: " + calcOperation.num2 + " action: " + calcOperation.action + " =result: " + calcOperation.result +
                    ", Date and time of operation: " + calcOperation.getFormatDateTime());
            fileWriter.write(10);
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
}
