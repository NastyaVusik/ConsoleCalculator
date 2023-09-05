package ConsoleCalculatorRev0.CalculatorUsers;

import ConsoleCalculatorRev0.IO.ConsoleReader;
import ConsoleCalculatorRev0.IO.ConsoleWriter;
import ConsoleCalculatorRev0.Objects.CalculatorUser;
import ConsoleCalculatorRev0.Services.CalcUserService;
import ConsoleCalculatorRev0.Services.RegisterNewUserService;
import ConsoleCalculatorRev0.Services.RegistrationDate;

import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class SaveNewUserInFile implements SaveNewUser {
    private final ConsoleWriter consoleWriter = new ConsoleWriter();
//    List<CalculatorUser> usersInfoFromFileToList = new ArrayList<>();
    CalculatorUser calculatorUser = new CalculatorUser();

    RegistrationDate registrationDate = new RegistrationDate();



    String filePath = "src/ConsoleCalculatorRev0/CalculatorUsers/AllUsersFile.txt";
    Integer lastID = 0;


    //Determine user ID
    public SaveNewUserInFile() {
        lastID = addUsersInfoToArrayList().size();
    }



    //Method for saving new user in file
    @Override
    public void saveNewUser(CalculatorUser calculatorUser) {
        lastID++;
        calculatorUser.setUserID(lastID);

        try (FileWriter fileWriter = new FileWriter(filePath, true)) {

            fileWriter.write(calculatorUser.getUserID() + " " + calculatorUser.getUserName() + " " + calculatorUser.getUserEmail() +
                    " " + calculatorUser.getUserPassword() + " " + registrationDate.getFormatDateTime());
            fileWriter.write('\n');

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



    //Add all users from file to list
    @Override
    public List<CalculatorUser> addUsersInfoToArrayList() {

        List<CalculatorUser> usersInfoFromFileToList = new ArrayList<>();

        try {
            List<String> list = Files.readAllLines(
                    new File(filePath).toPath());

            list.stream().forEach(s -> {
                String[] fields = s.split(" ");

                if(fields.length == 6) {
                    calculatorUser.setUserID(Integer.valueOf(fields[0]));
                    calculatorUser.setUserName(fields[1]);
                    calculatorUser.setUserEmail(fields[2]);
                    calculatorUser.setUserPassword(fields[3]);
                    registrationDate.setFormatDateTime(fields[4]);
                    usersInfoFromFileToList.add(calculatorUser);
                }
                });




        } catch (IOException e) {
            e.printStackTrace();
        }

        return usersInfoFromFileToList;
    }



    //Method for finding old user by ID
    public CalculatorUser getOldUserByID(Integer userID){

        List<String> list = Collections.singletonList(addUsersInfoToArrayList().stream().toString());

        for (String s : list) {
            String[] fields = s.split(" ");

if(fields.length == 6) {
    calculatorUser.setUserID(Integer.valueOf(fields[0]));
    calculatorUser.setUserName(fields[1]);
    calculatorUser.setUserEmail(fields[2]);
    calculatorUser.setUserPassword(fields[3]);
    registrationDate.setFormatDateTime(fields[4]);

    if (userID.equals(calculatorUser.getUserID())) {
        return calculatorUser;
    }
}

        }

        return null;

    }

    }









