package ConsoleCalculatorRev0.CalculatorUsers;

import ConsoleCalculatorRev0.Calculator;
import ConsoleCalculatorRev0.ConsoleReader;
import ConsoleCalculatorRev0.ConsoleWriter;
import ConsoleCalculatorRev0.StartApplication;

public class CalculatorUser {

    //Object of new visitor, which will register the first time
    private String userName;
    private String userEmail;
    private String userPassword;
    private Integer userID;


    public CalculatorUser() {

    }

    public CalculatorUser(String userName, String userEmail, String userPassword, Integer userID) {
        this.userName = userName;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.userID = userID;
    }


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



//    @Override
//    public String toString() {
//        return "\nHello " + realOldUserName + " !\n";
//    }


    @Override
    public String toString() {
        return "\nUser's common information:\n" +
                 "1) Username is " + getUserName() + ";\n" +
                "2) ID is" + getUserID() + ";\n" +
                "3) Email is " + getUserEmail() + ";\n" +
                "4) Password is" + getUserEmail() + ";\n" +
                "5) Date and time of registration is ";
    }
}