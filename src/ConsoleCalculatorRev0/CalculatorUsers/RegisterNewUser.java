package ConsoleCalculatorRev0.CalculatorUsers;

import ConsoleCalculatorRev0.CalcOperation;
import ConsoleCalculatorRev0.ConsoleReader;
import ConsoleCalculatorRev0.ConsoleWriter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.time.format.DateTimeFormatter;

public class RegisterNewUser {

    //Create object of class ConsoleWriter
    private final ConsoleWriter consoleWriter = new ConsoleWriter();

    //Create object of class ConsoleReader
    private final ConsoleReader consoleReader = new ConsoleReader();

    //Create object of class NewUserInfoChecker
    NewUserInfoChecker newUserInfoChecker = new NewUserInfoChecker();



    //Date and time
//    LocalDateTime now = LocalDateTime.now();
//    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
//    String formatDateTime = now.format(formatter);




    //Method for registration of new User
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

        return calculatorUser;
    }
}






