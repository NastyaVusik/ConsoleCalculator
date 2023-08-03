package ConsoleCalculatorRev0;

public class StartApplication {

    //Create object of class ConsoleWriter
    private final ConsoleWriter consoleWriter = new ConsoleWriter();

    //Create object of class ConsoleReader
    private final ConsoleReader consoleReader = new ConsoleReader();

    //Create object of class ConsoleCalculator
    ConsoleCalculator consoleCalculator = new ConsoleCalculator();



    //Method for repeating action with object of class ConsoleCalculator
    public void start(){

        while (true){
            consoleWriter.printMessage("Enter the number num1: ");
            double num1 = consoleReader.readNumbers();

            consoleWriter.printMessage("Enter the number num2: ");
            double num2 = consoleReader.readNumbers();

            consoleWriter.printMessage("Enter the operation with this numbers: ");
            String action = consoleReader.readAction();

            double result = consoleCalculator.calculateResult(new CalcOperation(num1, num2, action));                  //(num1, num2, action)
            consoleWriter.printMessage("Result of calculation: " + result);

            consoleWriter.printMessage("Date and time of operation: " + consoleCalculator.getCreatedDate());

            //Continue calculation?
            consoleWriter.printMessage("\n\nEnter 0 - if you want exit. \nEnter 1 - continue. \n2 - show history of calculation");
            double number = consoleReader.readNumbers();

            if(number == 0){
                consoleWriter.printMessage("Goodbye...");
                break;
            }
                if(number == 1){
                    continue;
                }
                if(number == 2){
consoleCalculator.inMemoryHistory.printArrayList();
                }

        }
    }
}
