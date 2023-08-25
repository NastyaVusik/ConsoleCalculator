package ConsoleCalculatorRev0.Objects;



import ConsoleCalculatorRev0.Services.CalcUserService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CalculatorUser {

//    //Date and time
//    LocalDateTime now = LocalDateTime.now();
//    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
//    String formatDateTime = now.format(formatter);


    //Object of new visitor, which will register the first time
    private String userName;
    private String userEmail;
    private String userPassword;
    private Integer userID;


    public CalculatorUser() {
        this.userName = null;
        this.userEmail = null;
        this.userPassword = null;
        this.userID = 0;
    }

    public CalculatorUser(String userName, String userEmail, String userPassword) {
        this.userName = userName;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
    }

    public CalculatorUser(String userName, String userPassword) {
        this.userName = userName;
        this.userPassword = userPassword;
    }

    public CalculatorUser(String userName, String userEmail, String userPassword, Integer userID) {
        this.userName = userName;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.userID = userID;
    }

//    public CalculatorUser(String userName, String userEmail, String userPassword, Integer userID, String formatDateTime) {
//        this.userName = userName;
//        this.userEmail = userEmail;
//        this.userPassword = userPassword;
//        this.userID = userID;
//        this.formatDateTime = formatDateTime;
//    }


    //Getters and Setters

    public int getUserID(){
           return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }


//    public String getFormatDateTime() {
//        return formatDateTime;
//    }
//
//    public void setFormatDateTime(String formatDateTime) {
//        this.formatDateTime = formatDateTime;
//    }


    @Override
    public String toString() {

        //Create object of class CalculatorUser
        CalcUserService calcUserService = new CalcUserService();

        return "\nNew user's common information:\n" +
                 "1) Username is " + getUserName() + ";\n" +
                "2) ID is " + getUserID() + ";\n" +
                "3) Email is " + getUserEmail() + ";\n" +
                "4) Password is " + getUserPassword() + ";\n" +
                "5) Date and time of registration is " + calcUserService.getFormatDateTime() + "\n";
    }
}