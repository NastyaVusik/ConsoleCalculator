package ConsoleCalculatorRev0;

public class Authorisation {

    //Create object of class ConsoleWriter
    private final ConsoleWriter consoleWriter = new ConsoleWriter();

    //Create object of class ConsoleReader
    private final ConsoleReader consoleReader = new ConsoleReader();

    //Create object of class StartApplication
        StartApplication startApplication = new StartApplication();

    //Create object of class Calculator
    Calculator calculator = new Calculator();



    //Create variable actual username and password
     private String realUsername = "Nastya";
     private String realPassword = "123";

    //Create variables of username and password
    String username;
    String password;


    //Method to check username and password
public String checkUsernamePassword() {
    while (true) {
        consoleWriter.printMessage("Enter you username: ");
        username = consoleReader.readAction();
        consoleWriter.printMessage("Enter you password: ");
        password = consoleReader.readAction();

        if((username.equalsIgnoreCase(realUsername)) && (password.equals(realPassword))){
            consoleWriter.printMessage("Registration is successful!\n");
         startApplication.start();
        }
        else{
            consoleWriter.printMessage("You username or password are wrong. Please, try again.");
        }

    }
}

}
