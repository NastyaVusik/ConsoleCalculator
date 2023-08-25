package ConsoleCalculatorRev0.CalculationHistory;

import ConsoleCalculatorRev0.Objects.CalcOperation;
import ConsoleCalculatorRev0.Objects.CalculatorUser;

public interface History {
    void writeHistory(CalcOperation calcOperation);
    void writeHistoryWithUser(CalcOperation calcOperation, CalculatorUser calculatorUser);

}
