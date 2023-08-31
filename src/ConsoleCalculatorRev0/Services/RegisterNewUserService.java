package ConsoleCalculatorRev0.Services;

import ConsoleCalculatorRev0.CalculatorUsers.NewUserInfoChecker;
import ConsoleCalculatorRev0.CalculatorUsers.SaveNewUserInFile;
import ConsoleCalculatorRev0.IO.ConsoleReader;
import ConsoleCalculatorRev0.IO.ConsoleWriter;
import ConsoleCalculatorRev0.Objects.CalculatorUser;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class RegisterNewUserService {

    private final ConsoleWriter consoleWriter = new ConsoleWriter();
    private final ConsoleReader consoleReader = new ConsoleReader();
    NewUserInfoChecker newUserInfoChecker = new NewUserInfoChecker();
    SaveNewUserInFile saveNewUserInFile = new SaveNewUserInFile();



    public CalculatorUser registerNewUser() {

        CalculatorUser calculatorUser = new CalculatorUser();

        while (true) {
            consoleWriter.printMessage("\nEnter your username. It might be one word. Quantity of symbols is from 1 to 18: ");
            String userName = consoleReader.readAction();

            if ((newUserInfoChecker.checkUserName(userName))  && !(newUserInfoChecker.isUserNameOccupied(userName))) {
                calculatorUser.setUserName(userName);
                break;

            } else {
                consoleWriter.printMessage("\nUsername isn't correct or this username has been already registered. Please, try again...");
            }
        }

        while (true) {
            consoleWriter.printMessage("\nEnter your email: ");
            String userEmail = consoleReader.readAction();

            if (newUserInfoChecker.checkUserEmail(userEmail) && !(newUserInfoChecker.isUserEmailOccupied(userEmail))) {
                calculatorUser.setUserEmail(userEmail);
                break;

            } else {
                consoleWriter.printMessage("\nEmail's format isn't correct or user with this email we has been already registered. Please, enter another email...");
            }
        }

        while (true) {
            consoleWriter.printMessage("\nEnter your password. Length of password is more 6 symbols. There is required at least one digit," +
                    " one upper case letter, one ony other special symbol: ");
            String userPassword = consoleReader.readAction();

            if (newUserInfoChecker.checkUserPassword(userPassword)) {
                calculatorUser.setUserPassword(userPassword);
                break;

            } else {
                consoleWriter.printMessage("\nThe password isn't correct. Please, try again...");
            }
        }

        consoleWriter.printMessage("\nHi, " + calculatorUser.getUserName() + "!" + "Your registration was successful!\n");

        saveNewUserInFile.saveNewUser(calculatorUser);

        return calculatorUser;
    }

}
