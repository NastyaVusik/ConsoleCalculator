package ConsoleCalculatorRev0;

import ConsoleCalculatorRev0.Objects.CalcOperation;
import ConsoleCalculatorRev0.Objects.CalculatorUser;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class SaveFileHistoryInThread implements Runnable {

//       private FileHistory fileHistory = new FileHistory();

       private final CalcOperation calcOperation;
       private final CalculatorUser calculatorUser;
       public SaveFileHistoryInThread(CalcOperation calcOperation, CalculatorUser calculatorUser){
           this.calcOperation = calcOperation;
           this.calculatorUser = calculatorUser;
       }

    String filePath1 = "src/ConsoleCalculatorRev0/CalculationHistory/SaveHistoryFiles/ historyWithUser.txt";


    @Override
        public void run() {

            File file = new File(filePath1);
            FileWriter fileWriter;
            try {
                fileWriter = new FileWriter(file, true);
                fileWriter.write("num1: " + calcOperation.getNum1() + " num2: " + calcOperation.getNum2() + " action: " + calcOperation.getAction() +
                        " result: " + calcOperation.getResult() + ", Date and time of operation: " + calcOperation.getFormatDateTime() + ", User ID: " + calculatorUser.getUserID());
                fileWriter.write('\n');
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException();
            }

        }
    }

