package ConsoleCalculatorRev0;

import ConsoleCalculatorRev0.CalculatorUsers.RegisterNewUser;
import ConsoleCalculatorRev0.CalculatorUsers.CalculatorUser;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class MainCalculation {


//    Реализовать консольный калькулятор с операциями + - * /.
//  Для хранения операций использовать коллекции, а так же файлы и предоставить возможность в коде переключаться между ними.
//  1) Добавить просмотр истории в меню калькулятора.
//    2) Добавить возможность хранить историю в коллекции


    public static void main(String[] args) {

        //Create object of class Calculator
        Calculator calculator = new Calculator();

        //Create object of class ConsoleReader
        ConsoleReader consoleReader = new ConsoleReader();

        //Create object of class ConsoleWriter
        ConsoleWriter consoleWriter = new ConsoleWriter();

        //Create object of class InMemoryHistory
        InMemoryHistory inMemoryHistory = new InMemoryHistory();

        //Create object of class Login
        String newUserName = "";
        String newUserPassword = "";

        CalculatorUser calculatorUser = new CalculatorUser(newUserName, newUserPassword);
        RegisterNewUser authorisation = new RegisterNewUser(calculatorUser);
        authorisation.registerNewUser(newUserName, newUserPassword);

        //Create object of class StartApplication
        StartApplication startApplication = new StartApplication(calculatorUser);


        //Begin and enjoy!!!
//        startApplication.start();

        //Begin and enjoy after successful authorisation!!!
//        authorisation.checkUsernamePassword();


    }


}

