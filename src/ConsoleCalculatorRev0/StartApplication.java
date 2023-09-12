package ConsoleCalculatorRev0;

import ConsoleCalculatorRev0.CalculationHistory.History;

import ConsoleCalculatorRev0.CalculatorUsers.SaveNewUser;
import ConsoleCalculatorRev0.IO.ConsoleReader;
import ConsoleCalculatorRev0.IO.ConsoleWriter;
import ConsoleCalculatorRev0.Objects.CalcOperation;
import ConsoleCalculatorRev0.Objects.CalculatorUser;
import ConsoleCalculatorRev0.Services.CalcUserService;
import ConsoleCalculatorRev0.Services.OperationService;
import ConsoleCalculatorRev0.UserSession.ConsoleSessions;

import java.util.List;
import java.util.Optional;

public class StartApplication {

    private final ConsoleWriter consoleWriter = new ConsoleWriter();
    private final ConsoleReader consoleReader = new ConsoleReader();
    OperationService calculator = new OperationService();
    CalcOperation calcOperation = new CalcOperation();
ConsoleSessions consoleSessions = new ConsoleSessions();

public StartApplication(SaveNewUser saveNewUser){
    this.calcUserService = new CalcUserService(saveNewUser);

}

CalcUserService calcUserService;

    CalculatorUser calculatorUser;

    private boolean excistsUser= false;




    public void start() {

        if (consoleSessions.getCurrentUser() == null) {
            makeAuthorisationAction();

            if (consoleSessions.getCurrentUser() == null) {
                consoleWriter.printMessage("Authorisation was failed. Exit.");
                return;

            }

        }

        calculate();

    }
    


    private void showAuthorisationMenu() {
        consoleWriter.printMessage("\nEnter:\n 0 - exit;\n 1 - sign up;\n 2 - login\n");
    }


    private void showUserMenu() {
        consoleWriter.printMessage("\nEnter:\n 0 - exit;\n 1 - continue;\n 2 - show history of calculation\n");
    }



    private void makeAuthorisationAction(){
//        showAuthorisationMenu();

    boolean toProcess = true;

        while (toProcess){

    showAuthorisationMenu();
    double choice = consoleReader.readNumbers();

  switch ((int) choice){
       case (0) -> {
           excistsUser = false;
           toProcess = false;
//           consoleSessions.logOutUser();
       }
       case (1) -> {
          calculatorUser = calcUserService.signUpNewUser();

          if(calculatorUser != null){
              excistsUser = true;
              toProcess = false;
          }
       }
       case (2) -> {
          Optional <CalculatorUser> oldCalculatorUser = calcUserService.logInCalculatorUser();

          if(!oldCalculatorUser.isEmpty()){
              calculatorUser = oldCalculatorUser.get();
              excistsUser = true;
              toProcess = false;
          }
       }
      default -> throw new IllegalStateException("Unexpected value: " + (int) choice);

   }

    }
        if(excistsUser == true){
            consoleSessions.setCalculatorUser(calculatorUser);
            consoleSessions.writeUserInSessionHistory(calculatorUser);
        }

    }



    private void calculate(){

        while (true){

            showUserMenu();
            double number = consoleReader.readNumbers();

            if(number == 0){
                consoleWriter.printMessage("\nGoodbye...\n");
                consoleSessions.logOutUser(calculatorUser);
                break;
            }
            if(number == 1){
                consoleWriter.printMessage("Enter the number num1: ");
                double num1 = consoleReader.readNumbers();

                consoleWriter.printMessage("Enter the number num2: ");
                double num2 = consoleReader.readNumbers();

                consoleWriter.printMessage("Enter the operation with this numbers: ");
                String action = consoleReader.readAction();

                double result = calculator.calculateResult(new CalcOperation(num1, num2, action), calculatorUser);
                consoleWriter.printMessage("Result of calculation: " + result);

                consoleWriter.printMessage("Date and time of operation: " + calcOperation.getFormatDateTime());

                consoleWriter.printMessage("User ID is " + calculatorUser.getUserID());

                consoleSessions.writeOperationsInSessionHistory(calcOperation, calculatorUser);
                continue;
            }
            if(number == 2){
//                calcUserService.printConsoleHistoryByUser(calculator.getInMemoryHistory());
                calcUserService.printConsoleHistoryByUser(calculator.getJdbcHistory());               //!!!!!!!!!!!!!!!!!!!!! Changed from File storage

                }
            else
            {consoleWriter.printMessage("You entered incorrect number.");
            }

            }

        }

    }


