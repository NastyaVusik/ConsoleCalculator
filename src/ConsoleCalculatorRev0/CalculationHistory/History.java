package ConsoleCalculatorRev0.CalculationHistory;

import ConsoleCalculatorRev0.CalcOperation;
import ConsoleCalculatorRev0.CalculatorUsers.CalculatorUser;

import java.time.LocalDate;

public interface History {
    void writeHistory(CalcOperation calcOperation);
    void writeHistoryWithUser(CalcOperation calcOperation, CalculatorUser calculatorUser);

}
