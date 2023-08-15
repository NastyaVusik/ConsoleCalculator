package ConsoleCalculatorRev0.CalculatorUsers;

import ConsoleCalculatorRev0.Calculator;
import ConsoleCalculatorRev0.ConsoleReader;
import ConsoleCalculatorRev0.ConsoleWriter;
import ConsoleCalculatorRev0.StartApplication;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RegisterNewUser implements SaveNewUser{

    //Create object of class ConsoleWriter
    private final ConsoleWriter consoleWriter = new ConsoleWriter();

    //Create object of class ConsoleReader
    private final ConsoleReader consoleReader = new ConsoleReader();

    //Create object of class NamePasswordParser
    NamePasswordParser namePasswordParser = new NamePasswordParser();

    //Create object of class Calculator
//    Calculator calculator = new Calculator();               //?????????????????????????????


    //Create object of class CalculatorUser
    CalculatorUser calculatorUser;

    //Constructor for class CalculatorUser
    public RegisterNewUser(CalculatorUser calculatorUser){
        this.calculatorUser = calculatorUser;
    }

    //Variable of user ID
    int userID = 0;



    //Method for registration of new User
    public List<String> registerNewUser(String newUserName, String newUserPassword){
        List<String> namePasswordList = new ArrayList<>();
        consoleWriter.printMessage("Enter your username. It might be one word. Quantity of symbols is from 1 to 18: ");
        newUserName = consoleReader.readAction();

        if((namePasswordParser.checkUserName(newUserName)) && (!(namePasswordList.contains(newUserName)))) {
            calculatorUser.setNewUserName(newUserName);
            namePasswordList.add(newUserName);
        }
        else{
            consoleWriter.printMessage("Username isn't correct. Please, try again...");
        }

        consoleWriter.printMessage("Enter your password. Length of password is more 6 symbols. There is required at least one digit," +
                " one upper case letter, one ony other special symbol: ");
        newUserPassword = consoleReader.readAction();

        if(namePasswordParser.checkUserPassword(newUserPassword)) {
            calculatorUser.setNewUserPassword(newUserPassword);
            namePasswordList.add(newUserPassword);
        }
        else{
            consoleWriter.printMessage("Username isn't correct. Please, try again...");
        }
consoleWriter.printMessage("HI, " + newUserName + "!\n" + "Your registration was successful!" );
        userID++;
        calculatorUser.setUserID(userID);
        namePasswordList.add(String.valueOf(userID));

        return namePasswordList;
    }


    @Override
    public void saveNewUser(CalculatorUser calculatorUser){
        File file = new File("src/ConsoleCalculatorRev0/CalculatorUsers/NamePasswordList.txt");
        FileWriter fileWriter;
        try {
            fileWriter = new FileWriter(file, true);
            fileWriter.write("User ID: "+ calculatorUser.getUserID() + "user name: " + calculatorUser.getNewUserName() + ", password: " + calculatorUser.getNewUserPassword());
            fileWriter.write(10);
            fileWriter.close();
        } catch (IOException e){
            e.printStackTrace();
        }

    }


}
