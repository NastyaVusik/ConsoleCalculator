package ConsoleCalculatorRev0;

public class Login {

    //Create object of class ConsoleWriter
    private final ConsoleWriter consoleWriter = new ConsoleWriter();

    //Create object of class ConsoleReader
    private final ConsoleReader consoleReader = new ConsoleReader();

    //Create object of class StartApplication
        StartApplication startApplication = new StartApplication();


    //Create variable actual username and password
    private String realUsername;
    private String realPassword;

    //Create variables of username and password, which user inputs
    String username;
    String password;


    //Method of registration in calculator app
    public String loginNewUser(){

    }



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
