package ConsoleCalculatorRev0.CalculatorUsers;

import ConsoleCalculatorRev0.Objects.CalculatorUser;

import java.util.List;
import java.util.Optional;

public interface SaveNewUser {
    void saveNewUser(CalculatorUser calculatorUser);
    List<CalculatorUser> addUsersInfoToArrayList();

}
