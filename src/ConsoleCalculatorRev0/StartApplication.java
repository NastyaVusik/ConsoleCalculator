package ConsoleCalculatorRev0;

import ConsoleCalculatorRev0.CalculatorUsers.*;

import java.io.FileNotFoundException;
import java.io.IOException;

public class StartApplication {

    //Create object of class ConsoleWriter
    private final ConsoleWriter consoleWriter = new ConsoleWriter();

    //Create object of class ConsoleReader
    private final ConsoleReader consoleReader = new ConsoleReader();

    //Create object of class Calculator
    Calculator calculator = new Calculator();
    CalcOperation calcOperation = new CalcOperation();

    //Create object of class CalculatorUser
    CalculatorUser calculatorUser;
    public StartApplication(CalculatorUser calculatorUser){
        this.calculatorUser = calculatorUser;
    }

    //Create object of class RegisterNewUser
    RegisterNewUser registerNewUser = new RegisterNewUser();

    //Create object of class SaveAllUsersInFile
    SaveNewUserInFile saveAllUsersInFile = new SaveNewUserInFile();

    AuthoriseOldUser authoriseOldUser = new AuthoriseOldUser();
    SaveNewUserInList saveNewUserInList = new SaveNewUserInList();





    //Method for repeating action with object of class Calculator
    public void start(){

        consoleWriter.printMessage("\nEnter 1 - if you want to sign up." +
                "\nEnter 2 - if you want to login" +
        "\nEnter 0 - if you want to exit");
        int choice = (int) consoleReader.readNumbers();


        if(choice == 1){
           calculatorUser = registerNewUser.registerNewUser();
           saveNewUserInList.saveNewUser(calculatorUser);
            saveNewUserInList.getUsersInfoArrayList().stream().forEach(user -> System.out.println(user));

                saveAllUsersInFile.saveNewUser(calculatorUser);
                saveAllUsersInFile.getUsersInfoArrayList().stream().forEach(user -> System.out.println(user));
        }

        if(choice == 2) {
            while (true) {
                try {
                  authoriseOldUser.checkUsernamePassword();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }

           else if(choice == 0){
               return;
            }




        while (true){
            consoleWriter.printMessage("Enter the number num1: ");
            double num1 = consoleReader.readNumbers();

            consoleWriter.printMessage("Enter the number num2: ");
            double num2 = consoleReader.readNumbers();

            consoleWriter.printMessage("Enter the operation with this numbers: ");
            String action = consoleReader.readAction();

            double result = calculator.calculateResult(new CalcOperation(num1, num2, action), calculatorUser);                  //(num1, num2, action)
            consoleWriter.printMessage("Result of calculation: " + result);

            consoleWriter.printMessage("Date and time of operation: " + calcOperation.getFormatDateTime());


            consoleWriter.printMessage("\n\nEnter 0 - if you want exit. " +
                    "\nEnter 1 - continue. " +
                    "\nEnter 2 - show history of calculation.");
            double number = consoleReader.readNumbers();

            if(number == 0){
                consoleWriter.printMessage("Goodbye...");
                break;
            }
                if(number == 1){
                    continue;
                }
                if(number == 2){
calculator.inMemoryHistory.printArrayList();
                }

        }
    }
}
