package ConsoleCalculatorRev0.CalculatorUsers;

import ConsoleCalculatorRev0.Calculator;
import ConsoleCalculatorRev0.ConsoleReader;
import ConsoleCalculatorRev0.ConsoleWriter;

import java.io.*;
import java.util.List;

public class AuthoriseOldUser {

    //Create object of class ConsoleWriter
    private final ConsoleWriter consoleWriter = new ConsoleWriter();

    //Create object of class ConsoleReader
    private final ConsoleReader consoleReader = new ConsoleReader();

    //Create object of class SaveAllUsersInFile
    SaveNewUserInFile saveAllUsersInFile = new SaveNewUserInFile();


    //Method for authorisation of old user
    public CalculatorUser checkUsernamePassword() throws IOException {

        while (true) {
            consoleWriter.printMessage("\nEnter your username: ");
            String userName = consoleReader.readAction();

            consoleWriter.printMessage("\nEnter your password: ");
            String userPassword = consoleReader.readAction();

            List<CalculatorUser> calculatorUserList =  saveAllUsersInFile.getUsersInfoArrayList();
            CalculatorUser oldUser = null;

            for(CalculatorUser user : calculatorUserList){
                boolean match = (userName.equalsIgnoreCase(user.getUserName()) && userPassword.equals(user.getUserPassword()));

                if(match){
                    oldUser = user;
            }

                    if (oldUser != null) {
                        consoleWriter.printMessage("Hi, " + oldUser.getUserName() + " with ID = "
                                + oldUser.getUserID() + "!" + "Registration is successful!\n");
                    } else {
                        consoleWriter.printMessage("\nYou username or password are wrong. Please, try again.\n");
                    }

                    return oldUser;
                }

        }
    }
}
