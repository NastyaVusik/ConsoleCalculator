package ConsoleCalculatorRev0.Services;

import ConsoleCalculatorRev0.CalculatorUsers.NewUserInfoChecker;
import ConsoleCalculatorRev0.CalculatorUsers.SaveNewUserInFile;
import ConsoleCalculatorRev0.IO.ConsoleReader;
import ConsoleCalculatorRev0.IO.ConsoleWriter;
import ConsoleCalculatorRev0.Objects.CalculatorUser;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

public class CalcUserService {

    private final ConsoleWriter consoleWriter = new ConsoleWriter();
    private final ConsoleReader consoleReader = new ConsoleReader();
    SaveNewUserInFile saveNewUserInFile = new SaveNewUserInFile();
    LoginOldUserService loginOldUserService = new LoginOldUserService();
    RegisterNewUserService registerNewUserService = new RegisterNewUserService();


//    //Date and time
//    LocalDateTime registeredAt = LocalDateTime.now();
//    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
//    String formatDateTime = registeredAt.format(formatter);



    public CalculatorUser signUpNewUser(String userName, String userEmail, String userPassword) {
        return registerNewUserService.registerNewUser(userName, userEmail, userPassword);
    }


    //Method for getting old user by userName and userPassword
    public Optional<CalculatorUser> logInCalculatorUser(String userName, String userPassword){          //LogIn
       return loginOldUserService.getOldUserFromList(userName, userPassword);
    }


    //Method for getting old user by ID
    public CalculatorUser getCalculatorUserByID(Integer userID){
        return saveNewUserInFile.getOldUserByID(userID);
    }



//    //Method to get Date and time
//    public String getFormatDateTime() {
//
//        LocalDateTime now = LocalDateTime.now();
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
//        formatDateTime = now.format(formatter);
//
//        return formatDateTime;
//    }
//
//
//    public void setFormatDateTime(String formatDateTime) {
//        this.formatDateTime = formatDateTime;
//    }


}
