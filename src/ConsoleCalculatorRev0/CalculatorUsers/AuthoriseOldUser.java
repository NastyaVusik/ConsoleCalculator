package ConsoleCalculatorRev0.CalculatorUsers;

import ConsoleCalculatorRev0.ConsoleReader;
import ConsoleCalculatorRev0.ConsoleWriter;

public class AuthoriseOldUser {

    //Create object of class ConsoleWriter
    private final ConsoleWriter consoleWriter = new ConsoleWriter();

    //Create object of class ConsoleReader
    private final ConsoleReader consoleReader = new ConsoleReader();

    //Create object of class CalculatorUser
    CalculatorUser calculatorUser;

        //Method for authorisation of old user
public String checkUsernamePassword() {
    while (true) {
        consoleWriter.printMessage("Enter you username: ");
       String username = consoleReader.readAction();
        consoleWriter.printMessage("Enter you password: ");
        calculatorUser.getOldUserNameInput() = consoleReader.readAction();
       calculatorUser.getOldUserPasswordInput() = consoleReader.readAction();

        if((username.equalsIgnoreCase(realUsername)) && (password.equals(realPassword))){
            consoleWriter.printMessage("Registration is successful!\n");
         startApplication.start();
        }
        else{
            consoleWriter.printMessage("You username or password are wrong. Please, try again.");
        }

    }
}
}
