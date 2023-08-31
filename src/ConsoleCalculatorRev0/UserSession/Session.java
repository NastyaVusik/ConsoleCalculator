package ConsoleCalculatorRev0.UserSession;

import ConsoleCalculatorRev0.Objects.CalcOperation;
import ConsoleCalculatorRev0.Objects.CalculatorUser;

public interface Session {
    CalculatorUser readCurrentUser();
    void writeUserInSessionHistory(CalculatorUser calculatorUser);
    void logOutUser(CalculatorUser calculatorUser);
    void writeOperationsInSessionHistory(CalcOperation calcOperation, CalculatorUser calculatorUser);
}
