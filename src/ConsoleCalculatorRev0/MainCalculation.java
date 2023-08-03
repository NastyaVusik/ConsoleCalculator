package ConsoleCalculatorRev0;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class MainCalculation {
    public static void main(String[] args) {

        //Create object of class ConsoleCalculator
        ConsoleCalculator consoleCalculator = new ConsoleCalculator();

        //Create object of class ConsoleReader
        ConsoleReader consoleReader = new ConsoleReader();

        //Create object of class ConsoleWriter
        ConsoleWriter consoleWriter = new ConsoleWriter();

        //Create object of class InMemoryHistory
        InMemoryHistory inMemoryHistory = new InMemoryHistory();

        //Create object of class StartApplication
        StartApplication startApplication = new StartApplication();

        //Create object of class Login
        Authorisation authorisation = new Authorisation();


        //Begin and enjoy!!!
//        startApplication.start();

        //Begin and enjoy after successful authorisation!!!
        authorisation.checkUsernamePassword();


    }


}

