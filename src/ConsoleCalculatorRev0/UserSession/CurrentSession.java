package ConsoleCalculatorRev0.UserSession;

import ConsoleCalculatorRev0.CalculatorUsers.*;

public class CurrentSession implements Session {

    SaveNewUser getNewUserFromList = new SaveNewUserInList();
    SaveNewUser getNewUserFromFile = new SaveNewUserInFile();

    @Override
    public CalculatorUser getCurrentUser(CalculatorUser calculatorUser) {

        Integer currentUserID = calculatorUser.getUserID();

        if (currentUserID == (getNewUserFromList.getUsersInfoArrayList().size())) {
            calculatorUser = getNewUserFromList.getUsersInfoArrayList().get(currentUserID);
            return calculatorUser;
        } else if (currentUserID != (getNewUserFromFile.getUsersInfoArrayList().size())) {
            calculatorUser = getNewUserFromFile.getUsersInfoArrayList().get(currentUserID);
            return calculatorUser;
        }
        else return null;
    }
}
