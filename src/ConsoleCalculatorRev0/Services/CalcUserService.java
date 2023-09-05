package ConsoleCalculatorRev0.Services;

import ConsoleCalculatorRev0.CalculationHistory.History;
import ConsoleCalculatorRev0.CalculatorUsers.SaveNewUserInJDBC;
import ConsoleCalculatorRev0.IO.ConsoleReader;
import ConsoleCalculatorRev0.IO.ConsoleWriter;
import ConsoleCalculatorRev0.Objects.CalculatorUser;

import java.util.ArrayList;
import java.util.Optional;

public class CalcUserService {

    private final ConsoleWriter consoleWriter = new ConsoleWriter();
    private final ConsoleReader consoleReader = new ConsoleReader();
//    SaveNewUserInFile saveNewUserInFile = new SaveNewUserInFile();

    SaveNewUserInJDBC jdbcUserStorage = new SaveNewUserInJDBC();              //!!!!!!!!!!!!!!!!!!!!! Changed from File storage
    LoginOldUserService loginOldUserService = new LoginOldUserService();
    RegisterNewUserService registerNewUserService = new RegisterNewUserService();


    public CalculatorUser signUpNewUser() {
        return registerNewUserService.registerNewUser();
    }


    //Method for getting old user by userName and userPassword
    public Optional<CalculatorUser> logInCalculatorUser() {          //LogIn
        return loginOldUserService.getOldUserFromList();
    }


    //Method for getting old user by ID
    public CalculatorUser getCalculatorUserByID(Integer userID) {
//        return saveNewUserInFile.getOldUserByID(userID);
        return jdbcUserStorage.getOldUserByID();                         //!!!!!!!!!!!!!!!!!!!!! Changed from File storage

    }


    public void printConsoleHistoryByUser(History history) {
        ArrayList<String> listHistoryByUser = history.getOperationHistory();


        if (listHistoryByUser.isEmpty()) {
            consoleWriter.printMessage("History of this user is empty");
        } else {
            consoleWriter.printMessage("\n\nHistory of calculation in ArrayList:\n ");

            for (String list : listHistoryByUser) {
                consoleWriter.printMessage(list);
            }
        }
    }

}

