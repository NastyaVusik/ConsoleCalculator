package ConsoleCalculatorRev0;

import ConsoleCalculatorRev0.CalculatorUsers.SaveAllUsersInFile;
import ConsoleCalculatorRev0.CalculatorUsers.AuthoriseOldUser;
import ConsoleCalculatorRev0.CalculatorUsers.CalculatorUser;
import ConsoleCalculatorRev0.CalculatorUsers.RegisterNewUser;

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
    SaveAllUsersInFile saveAllUsersInFile = new SaveAllUsersInFile();

    AuthoriseOldUser authoriseOldUser = new AuthoriseOldUser();





    //Method for repeating action with object of class Calculator
    public void start(){

        consoleWriter.printMessage("\nEnter 1 - if you want to sign up." +
                "\nEnter 2 - if you want to login");
        int choice = (int) consoleReader.readNumbers();

        if(choice == 1){
            registerNewUser.registerNewUser();
            registerNewUser.saveNewUser(calculatorUser);
            try {
                saveAllUsersInFile.saveAllUserInFile();
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }

        }

        if(choice == 2){
            try {
                authoriseOldUser.checkUsernamePassword();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }


        while (true){
            consoleWriter.printMessage("Enter the number num1: ");
            double num1 = consoleReader.readNumbers();

            consoleWriter.printMessage("Enter the number num2: ");
            double num2 = consoleReader.readNumbers();

            consoleWriter.printMessage("Enter the operation with this numbers: ");
            String action = consoleReader.readAction();

            double result = calculator.calculateResult(new CalcOperation(num1, num2, action));                  //(num1, num2, action)
            consoleWriter.printMessage("Result of calculation: " + result);

            consoleWriter.printMessage("Date and time of operation: " + calcOperation.formatDateTime);

            //Continue calculation?
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
