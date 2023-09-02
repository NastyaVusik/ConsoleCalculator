package ConsoleCalculatorRev0.CalculationHistory;

import ConsoleCalculatorRev0.Objects.CalcOperation;
import ConsoleCalculatorRev0.Objects.CalculatorUser;
import ConsoleCalculatorRev0.SaveFileHistoryInThread;
import ConsoleCalculatorRev0.UserSession.ConsoleSessions;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FileHistory implements History {

    String filePath = "src/ConsoleCalculatorRev0/CalculationHistory/SaveHistoryFiles/ history.txt";
            String filePath1 = "src/ConsoleCalculatorRev0/CalculationHistory/SaveHistoryFiles/ historyWithUser.txt";


    public FileHistory(){
    }

            public FileHistory(String filePath){
                this.filePath = filePath;
            }


    //Write history of calculations
    @Override
    public void writeHistory(CalcOperation calcOperation) {

        File file = new File(filePath);
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
        SaveFileHistoryInThread saveFileHistoryInThread;

Thread thread = new Thread(new SaveFileHistoryInThread(calcOperation, calculatorUser));
thread.start();
    }


    @Override
   public ArrayList<String> getOperationHistory(){
        ArrayList <String> listHistory;

        try {
            listHistory = (ArrayList<String>) Files.readAllLines(Path.of("src/ConsoleCalculatorRev0/CalculationHistory/SaveHistoryFiles/ historyWithUser.txt"));

            } catch (IOException ex) {
            throw new RuntimeException(ex);
        }

return listHistory;

    }

}
