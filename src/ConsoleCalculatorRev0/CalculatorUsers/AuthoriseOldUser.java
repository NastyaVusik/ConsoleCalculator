package ConsoleCalculatorRev0.CalculatorUsers;

import ConsoleCalculatorRev0.ConsoleReader;
import ConsoleCalculatorRev0.ConsoleWriter;

public class AuthoriseOldUser {

    //Create object of class ConsoleWriter
    private final ConsoleWriter consoleWriter = new ConsoleWriter();

    //Create object of class ConsoleReader
    private final ConsoleReader consoleReader = new ConsoleReader();

    //Create object of class AllUsersMapCollection
    AllUsersMapCollection allUsersMapCollection = new AllUsersMapCollection();

    //Create object of class CalculatorUser
    CalculatorUser calculatorUser;

    //Method for authorisation of old user
    public CalculatorUser checkUsernamePassword() {
        while (true) {
            consoleWriter.printMessage("\nEnter your username: ");
            String username = consoleReader.readAction();

            consoleWriter.printMessage("\nEnter your password: ");
            String userPassword = consoleReader.readAction();

            for (CalculatorUser calculatorUser1 : allUsersMapCollection.getAllUsersMapList().values()) {
                if ((username.equalsIgnoreCase(String.valueOf(allUsersMapCollection.getAllUsersMapList().get(calculatorUser1.getUserID()))))
                        && (userPassword.equals(allUsersMapCollection.getAllUsersMapList().get(calculatorUser1.getUserPassword())))) {
                    consoleWriter.printMessage("Hi, " + allUsersMapCollection.calculatorUser.getUserName() + "!" + "Registration is successful!\n");

                    break;

                } else {
                    consoleWriter.printMessage("\nYou username or password are wrong. Please, try again.\n");
                }

            }
        }
        return calculatorUser;
    }
}
