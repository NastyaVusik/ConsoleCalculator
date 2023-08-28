package ConsoleCalculatorRev0;

import ConsoleCalculatorRev0.CalculationHistory.PrintMemoryHistoryToConsole;
import ConsoleCalculatorRev0.IO.ConsoleReader;
import ConsoleCalculatorRev0.IO.ConsoleWriter;
import ConsoleCalculatorRev0.Objects.CalcOperation;
import ConsoleCalculatorRev0.Objects.CalculatorUser;
import ConsoleCalculatorRev0.Services.CalcUserService;
import ConsoleCalculatorRev0.Services.OperationService;
import ConsoleCalculatorRev0.Services.RegisterNewUserService;
import ConsoleCalculatorRev0.UserSession.ConsoleSessions;

import java.util.List;

public class StartApplication {

    private final ConsoleWriter consoleWriter = new ConsoleWriter();
    private final ConsoleReader consoleReader = new ConsoleReader();
    OperationService calculator = new OperationService();
    CalcOperation calcOperation = new CalcOperation();
ConsoleSessions consoleSessions = new ConsoleSessions();
CalcUserService calcUserService = new CalcUserService();

    CalculatorUser calculatorUser;
    PrintMemoryHistoryToConsole printMemoryHistoryToConsole;

    private boolean excistsUser= true;


//public void start(){
//while (excistsUser){
//    if (consoleSessions.getCurrentUser() == null){
//        showAuthorisationMenu();
//    }
//   else showUserMenu();
//}
//}

    public void start(){

            if (consoleSessions.getCurrentUser() == null){
                showAuthorisationMenu();
            }
            else showUserMenu();
        }
    


    private void showAuthorisationMenu() {
        consoleWriter.printMessage("Enter:\n 0 - exit;\n 1 - sign up;\n 2 - login");
    }


    private void showUserMenu() {
        consoleWriter.printMessage("Enter:\n 0 - exit;\n 1 - sign up;\n 2 - login;\n 3 - use calculator");
    }



    private void makeAuthorisationAction(){
    boolean excistsUser1 = true;

        while (excistsUser1){

    showAuthorisationMenu();
    double choice = consoleReader.readNumbers();

  switch ((int) choice){
       case (0) -> {
           excistsUser = false;
           excistsUser1 = false;
//           consoleSessions.logOutUser();
           break;
       }
       case (1) -> {
          calcUserService.signUpNewUser(calculatorUser.getUserName(), calculatorUser.getUserEmail(), calculatorUser.getUserPassword());
           break;
       }
       case (2) -> {
           calcUserService.logInCalculatorUser(calculatorUser.getUserName(), calculatorUser.getUserPassword());
           break;
       }
      default -> throw new IllegalStateException("Unexpected value: " + (int) choice);

   }

    }

    }



    private void makeUserAction(){
        boolean excistsUser1 = true;

        while (excistsUser1){

            showUserMenu();
            double choice = consoleReader.readNumbers();

            switch ((int) choice){
                case (0) -> {
//                    excistsUser = false;
//                    excistsUser1 = false;
           consoleSessions.logOutUser();
                    break;
                }
                case (1) -> {
                    calcUserService.signUpNewUser(calculatorUser.getUserName(), calculatorUser.getUserEmail(), calculatorUser.getUserPassword());
                    break;
                }
                case (2) -> {
                    calcUserService.logInCalculatorUser(calculatorUser.getUserName(), calculatorUser.getUserPassword());
                    break;
                }
                case (3) -> {
                    calculate();
                }

                default -> throw new IllegalStateException("Unexpected value: " + (int) choice);
            }

        }

    }




    private void calculate(){

        while (true){
            consoleWriter.printMessage("Enter the number num1: ");
            double num1 = consoleReader.readNumbers();

            consoleWriter.printMessage("Enter the number num2: ");
            double num2 = consoleReader.readNumbers();

            consoleWriter.printMessage("Enter the operation with this numbers: ");
            String action = consoleReader.readAction();

            double result = calculator.calculateResult(new CalcOperation(num1, num2, action));
            consoleWriter.printMessage("Result of calculation: " + result);

            consoleWriter.printMessage("Date and time of operation: " + calcOperation.getFormatDateTime());

            consoleWriter.printMessage("User ID is " + calculatorUser.getUserID());


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
//                PrintMemoryHistoryToConsole.printArrayList();
                consoleWriter.printMessage("Don't know");

                }

            }

        }

    }


