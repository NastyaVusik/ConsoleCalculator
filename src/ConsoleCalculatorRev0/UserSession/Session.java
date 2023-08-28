package ConsoleCalculatorRev0.UserSession;

import ConsoleCalculatorRev0.Objects.CalculatorUser;

public interface Session {
    CalculatorUser setUserInSession();
    void writeUserInSession(CalculatorUser calculatorUser);
    void logOutUser();
}
