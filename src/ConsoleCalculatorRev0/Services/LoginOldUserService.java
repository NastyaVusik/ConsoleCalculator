package ConsoleCalculatorRev0.Services;

import ConsoleCalculatorRev0.CalculatorUsers.SaveNewUserInFile;
import ConsoleCalculatorRev0.IO.ConsoleReader;
import ConsoleCalculatorRev0.IO.ConsoleWriter;
import ConsoleCalculatorRev0.Objects.CalculatorUser;
import ConsoleCalculatorRev0.Services.CalcUserService;

import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class LoginOldUserService {
    SaveNewUserInFile saveNewUserInFile = new SaveNewUserInFile();
    CalculatorUser calculatorUser = new CalculatorUser();
    private final ConsoleWriter consoleWriter = new ConsoleWriter();
    private final ConsoleReader consoleReader = new ConsoleReader();

    RegistrationDate registrationDate = new RegistrationDate();

//Method for finding old user by userName and userPassword

    public Optional<CalculatorUser> getOldUserFromList(String userName, String userPassword) {

        List<String> list = Collections.singletonList(saveNewUserInFile.addUsersInfoToArrayList().stream().toString());


        while (true) {
            consoleWriter.printMessage("\nEnter your username: ");
            userName = consoleReader.readAction();

            consoleWriter.printMessage("\nEnter your password: ");
            userPassword = consoleReader.readAction();


            for (String s : list) {
                String[] fields = s.split(" ");

                calculatorUser.setUserID(Integer.valueOf(fields[0]));
                calculatorUser.setUserName(fields[1]);
                calculatorUser.setUserEmail(fields[2]);
                calculatorUser.setUserPassword(fields[3]);
                registrationDate.setFormatDateTime(fields[4]);

                if ((userName.equalsIgnoreCase(fields[1])) && (userPassword.equals(fields[3]))) {

                    consoleWriter.printMessage("Hi, " + calculatorUser.getUserName() + " with ID = "
                            + calculatorUser.getUserID() + "!" + "Registration is successful!\n");

                    return Optional.of(calculatorUser);
                }

            }

            consoleWriter.printMessage("\nYou username or password are wrong. Please, try again.\n");

            return Optional.empty();
        }

    }
}