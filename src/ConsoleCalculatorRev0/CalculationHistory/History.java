package ConsoleCalculatorRev0.CalculationHistory;

import ConsoleCalculatorRev0.Objects.CalcOperation;
import ConsoleCalculatorRev0.Objects.CalculatorUser;

import java.util.ArrayList;

public interface History {
    void writeHistory(CalcOperation calcOperation);
    void writeHistoryWithUser(CalcOperation calcOperation, CalculatorUser calculatorUser);
    ArrayList<String> getOperationHistory();

}
