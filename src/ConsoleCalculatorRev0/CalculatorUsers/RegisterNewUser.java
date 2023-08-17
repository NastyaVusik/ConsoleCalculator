package ConsoleCalculatorRev0.CalculatorUsers;

import ConsoleCalculatorRev0.ConsoleReader;
import ConsoleCalculatorRev0.ConsoleWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RegisterNewUser implements SaveNewUser{

    //Create object of class ConsoleWriter
    private final ConsoleWriter consoleWriter = new ConsoleWriter();

    //Create object of class ConsoleReader
    private final ConsoleReader consoleReader = new ConsoleReader();

    //Create object of class NewUserInfoChecker
    NewUserInfoChecker newUserInfoChecker = new NewUserInfoChecker();

    //Create object for save date and time of new account creation
    LocalDateTime accountWasCreated = LocalDateTime.now();

//Create collection Map<Integer ID, String userInfoList> for keeping all users
     Map<Integer, String> allUsersMapList;

    //Variable of user ID
    int userID = 0;


    //Method for registration of new User
    public List<String> registerNewUser(CalculatorUser calculatorUser){
        List<String> userInfoList = new ArrayList<>();

        consoleWriter.printMessage("Enter your username. It might be one word. Quantity of symbols is from 1 to 18: ");
       String newUserName = consoleReader.readAction();
String realOldUserName = newUserName;           //??????????????????????????????????????????????????????????????????????????????
        if((newUserInfoChecker.checkUserName(newUserName)) && (newUserInfoChecker.isUserNameOccupied(newUserName) == false)){
            userInfoList.add(newUserName);
            calculatorUser.setNewUserName(newUserName);
        }
        else{
            consoleWriter.printMessage("Username isn't correct or this username has been already employed. Please, try again...");
        }

        consoleWriter.printMessage("Enter your email: ");
        String newUserEmail = consoleReader.readAction();
        String realOldUserEmail = newUserEmail;           //??????????????????????????????????????????????????????????????????????????????
        if(newUserInfoChecker.checkUserEmail(newUserEmail) == false){
            userInfoList.add(newUserEmail);
            calculatorUser.setNewUserEmail(newUserEmail);
        }
        else {
            consoleWriter.printMessage("User with this email was already registered. Please, enter another email...");
        }

        consoleWriter.printMessage("Enter your password. Length of password is more 6 symbols. There is required at least one digit," +
                " one upper case letter, one ony other special symbol: ");
        String newUserPassword = consoleReader.readAction();

        if(newUserInfoChecker.checkUserPassword(newUserPassword)) {
            userInfoList.add(newUserPassword);
            calculatorUser.setNewUserPassword(newUserPassword);
        }
        else{
            consoleWriter.printMessage("The password isn't correct. Please, try again...");
        }
consoleWriter.printMessage("HI, " + newUserName + "!\n" + "Your registration was successful!" );
        userID++;
        userInfoList.add(String.valueOf(userID));
        calculatorUser.setUserID(userID);

        return userInfoList;
    }


    @Override
    public void saveNewUser(CalculatorUser calculatorUser){
        File file = new File("src/ConsoleCalculatorRev0/CalculatorUsers/UsersInfoList.txt");
        FileWriter fileWriter;
        try {
            fileWriter = new FileWriter(file, true);
            fileWriter.write("User ID: "+ calculatorUser.getUserID() + "user name: " + calculatorUser.getNewUserName() + ", user's email: " + calculatorUser.getNewUserEmail() +
                    ", password: " + calculatorUser.getNewUserPassword() + ", date and time of registration: " + accountWasCreated +"\n");
            fileWriter.write(10);
            fileWriter.close();
        } catch (IOException e){
            e.printStackTrace();
        }

    }


}
