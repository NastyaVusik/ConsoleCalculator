package ConsoleCalculatorRev0.CalculationHistory;

import ConsoleCalculatorRev0.Objects.CalcOperation;
import ConsoleCalculatorRev0.Objects.CalculatorUser;
import ConsoleCalculatorRev0.UserSession.ConsoleSessions;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileHistory implements History {

    ConsoleSessions currentSession = new ConsoleSessions();


    //Write history of calculations
    @Override
    public void writeHistory(CalcOperation calcOperation) {

        File file = new File("src/ConsoleCalculatorRev0/CalculationHistory/SaveHistoryFiles/ history.txt");
        FileWriter fileWriter;
        try {
            fileWriter = new FileWriter(file, true);
            fileWriter.write("num1: " + calcOperation.getNum1() + " num2: " + calcOperation.getNum2() + " action: " + calcOperation.getAction() +
                    " result: " + calcOperation.getResult() + ", Date and time of operation: " + calcOperation.getFormatDateTime());
            fileWriter.write('\n');
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }



    @Override
    public void writeHistoryWithUser(CalcOperation calcOperation,  CalculatorUser calculatorUser) {

        File file = new File("src/ConsoleCalculatorRev0/CalculationHistory/SaveHistoryFiles/ historyWithUser.txt");
        FileWriter fileWriter;
        try {
            fileWriter = new FileWriter(file, true);
            fileWriter.write("num1: " + calcOperation.getNum1() + " num2: " + calcOperation.getNum2() + " action: " + calcOperation.getAction() +
                    " result: " + calcOperation.getResult() + ", Date and time of operation: " + calcOperation.getFormatDateTime() + ", User ID: " + currentSession.getCurrentUser().getUserID());
            fileWriter.write('\n');
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
}
