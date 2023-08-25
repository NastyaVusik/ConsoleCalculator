package ConsoleCalculatorRev0.CalculatorUsers;

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

public class SaveNewUserInFile implements SaveNewUser {
    private final ConsoleWriter consoleWriter = new ConsoleWriter();
    private final ConsoleReader consoleReader = new ConsoleReader();
    CalcUserService calcUserService = new CalcUserService();
    List<CalculatorUser> usersInfoFromFileToList = new ArrayList<>();
    CalculatorUser calculatorUser = new CalculatorUser();



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
                    " " + calculatorUser.getUserPassword() + " " + calcUserService.getFormatDateTime());
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

                calculatorUser.setUserID(Integer.valueOf(fields[0]));
                calculatorUser.setUserName(fields[1]);
                calculatorUser.setUserEmail(fields[2]);
                calculatorUser.setUserPassword(fields[3]);
                calcUserService.setFormatDateTime(fields[4]);
                usersInfoFromFileToList.add(calculatorUser);
            });

        } catch (IOException e) {
            e.printStackTrace();
        }

        return usersInfoFromFileToList;
    }




    //Method for finding old user by userName and userPassword
   @Override
    public Optional<CalculatorUser> getOldUserFromList(String userName, String userPassword){

        List<String> list = Collections.singletonList(addUsersInfoToArrayList().stream().toString());


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
               calcUserService.setFormatDateTime(fields[4]);

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



//    @Override
//    public Optional<CalculatorUser> getOldUserFromList(String userName, String userPassword){
//
//        List<String> list = Collections.singletonList(addUsersInfoToArrayList().stream().toString());
//
//        list.forEach(s -> {
//            String[] fields = s.split(" ");
//
////           CalculatorUser calculatorUser = new CalculatorUser();
//            calculatorUser.setUserID(Integer.valueOf(fields[0]));
//            calculatorUser.setUserName(fields[1]);
//            calculatorUser.setUserEmail(fields[2]);
//            calculatorUser.setUserPassword(fields[3]);
//            calcUserService.setFormatDateTime(fields[4]);
//
//            if((userName.equalsIgnoreCase(fields[1])) && (userPassword.equals(fields[3]))){
//                return Optional.of(calculatorUser);
//            }
//
//        });
//
//        return Optional.empty();
//
//    }




    //Method for finding old user by ID
    public CalculatorUser getOldUserByID(Integer userID){

        List<String> list = Collections.singletonList(addUsersInfoToArrayList().stream().toString());

        for (String s : list) {
            String[] fields = s.split(" ");

            calculatorUser.setUserID(Integer.valueOf(fields[0]));
            calculatorUser.setUserName(fields[1]);
            calculatorUser.setUserEmail(fields[2]);
            calculatorUser.setUserPassword(fields[3]);
            calcUserService.setFormatDateTime(fields[4]);

            Integer IDtoInt = Integer.valueOf(fields[0]);
            if (userID.equals(IDtoInt)) {
                return calculatorUser;
            }

        }

        return null;

    }

    }









