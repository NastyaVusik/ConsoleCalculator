package ConsoleCalculatorRev0.CalculatorUsers;

import ConsoleCalculatorRev0.ConsoleReader;
import ConsoleCalculatorRev0.ConsoleWriter;

import java.io.*;

public class AuthoriseOldUser {

    //Create object of class ConsoleWriter
    private final ConsoleWriter consoleWriter = new ConsoleWriter();

    //Create object of class ConsoleReader
    private final ConsoleReader consoleReader = new ConsoleReader();

    //Create object of class SaveAllUsersInFile
    SaveAllUsersInFile saveAllUsersInFile = new SaveAllUsersInFile();


    //Method for authorisation of old user
    public CalculatorUser checkUsernamePassword() throws IOException {

        while (true) {
            consoleWriter.printMessage("\nEnter your username: ");
            String userName = consoleReader.readAction();

            consoleWriter.printMessage("\nEnter your password: ");
            String userPassword = consoleReader.readAction();

            File filePath = new File("src/ConsoleCalculatorRev0/CalculatorUsers/UsersInfoList.txt");
            try (BufferedReader bReader =new BufferedReader(new FileReader(filePath))){
                String line = bReader.readLine();
                while (line != null) {
                    line = bReader.readLine();

                    if (userName.equalsIgnoreCase(saveAllUsersInFile.calculatorUser.getUserName()) &&
                            userPassword.equals(saveAllUsersInFile.calculatorUser.getUserPassword())) {

                        consoleWriter.printMessage("Hi, " + saveAllUsersInFile.calculatorUser.getUserName() + " with ID = "
                                + saveAllUsersInFile.calculatorUser.getUserID() + "!" + "Registration is successful!\n");
                    } else {
                        consoleWriter.printMessage("\nYou username or password are wrong. Please, try again.\n");
                    }

                    return saveAllUsersInFile.calculatorUser;
                }
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
