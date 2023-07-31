package ConsoleCalculatorRev0;

import java.util.Scanner;

public class ConsoleReader implements IFScanReader{

   //Initialisation of scanner
    Scanner scanReader = new Scanner(System.in);

    @Override
    public double readNumbers(){
      return scanReader.nextDouble();
    }

    @Override
    public String readAction(){
        return scanReader.next();
    }

}
