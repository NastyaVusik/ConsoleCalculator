package ConsoleCalculatorRev0.CalculatorUsers;

import ConsoleCalculatorRev0.Calculator;
import ConsoleCalculatorRev0.ConsoleReader;
import ConsoleCalculatorRev0.ConsoleWriter;
import ConsoleCalculatorRev0.StartApplication;

public class CalculatorUser {
    //Create object of class ConsoleWriter
    private final ConsoleWriter consoleWriter = new ConsoleWriter();

    //Create object of class ConsoleReader
    private final ConsoleReader consoleReader = new ConsoleReader();

    //Create object of class Calculator
    Calculator calculator = new Calculator();


    //Object of new visitor, which will register the first time
    private String newUserName;
    private String newUserEmail;
    private String newUserPassword;
    private int userID;

    public CalculatorUser(String newUserName, String newUserEmail, String newUserPassword) {
        this.newUserName = newUserName;
        this.newUserEmail = newUserEmail;
        this.newUserPassword = newUserPassword;
        this.userID = userID;
    }


    //Object of old visitor
    private String realOldUserName = newUserName;             //Create variable actual username and password
    private String realOldUserEmail = newUserEmail;
    private String realOldUserPassword = newUserPassword;
    private String oldUserNameInput;            //Create variables of username and password, which old user input in time of registration
    private String oldUserPasswordInput;


    public CalculatorUser(String realOldUserName, String realOldUserEmail, String realOldUserPassword, String oldUserNameInput, String oldUserPasswordInput) {
        this.realOldUserName = realOldUserName;
        this.realOldUserEmail = realOldUserEmail;
        this.realOldUserPassword = realOldUserPassword;
        this.oldUserNameInput = oldUserNameInput;
        this.oldUserPasswordInput = oldUserPasswordInput;
        this.userID = userID;
    }


    //Getters and Setters

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        userID = userID;
    }

    public String getNewUserName() {
        return newUserName;
    }

    public void setNewUserName(String newUserName) {
        this.newUserName = newUserName;
    }

    public String getNewUserEmail() {
        return newUserEmail;
    }

    public void setNewUserEmail(String newUserEmail) {
        this.newUserEmail = newUserEmail;
    }

    public String getNewUserPassword() {
        return newUserPassword;
    }

    public void setNewUserPassword(String newUserPassword) {
        this.newUserPassword = newUserPassword;
    }

    public String getRealOldUserName() {
        return realOldUserName;
    }

    public void setRealOldUserName(String realOldUserName) {
        this.realOldUserName = realOldUserName;
    }

    public String getRealOldUserEmail() {
        return realOldUserEmail;
    }

    public void setRealOldUserEmail(String realOldUserEmail) {
        this.realOldUserEmail = realOldUserEmail;
    }

    public String getRealOldUserPassword() {
        return realOldUserPassword;
    }

    public void setRealOldUserPassword(String realOldUserPassword) {
        this.realOldUserPassword = realOldUserPassword;
    }

    public String getOldUserNameInput() {
        return oldUserNameInput;
    }

    public void setOldUserNameInput(String oldUserNameInput) {
        this.oldUserNameInput = oldUserNameInput;
    }

    public String getOldUserPasswordInput() {
        return oldUserPasswordInput;
    }

    public void setOldUserPasswordInput(String oldUserPasswordInput) {
        this.oldUserPasswordInput = oldUserPasswordInput;
    }


//    @Override
//    public String toString() {
//        return "\nHello " + realOldUserName + " !\n";
//    }


    @Override
    public String toString() {
        return "\nUser's common information:\n" +
                 "1) Username is " + getRealOldUserName() + ";\n" +
                "2) ID is" + getUserID() + ";\n" +
                "3) Email is " + getRealOldUserEmail() + ";\n" +
                "4) Password is" + getRealOldUserPassword() + ";\n" +
                "5) Date and time of registration is ";
    }
}