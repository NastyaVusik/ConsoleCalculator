package ConsoleCalculatorRev0.UserSession;

import ConsoleCalculatorRev0.CalculationHistory.FileStorage.FileHistory;
import ConsoleCalculatorRev0.CalculationHistory.History;
import ConsoleCalculatorRev0.CalculatorUsers.SaveNewUser;
import ConsoleCalculatorRev0.Objects.CalcOperation;
import ConsoleCalculatorRev0.Objects.CalculatorUser;
import ConsoleCalculatorRev0.Services.CalcUserService;
import ConsoleCalculatorRev0.Services.RegistrationDate;

import java.io.*;

public class ConsoleSessions implements Session {
    private CalculatorUser calculatorUser;
    CalcUserService calcUserService;

    public ConsoleSessions(CalcUserService calcUserService){
     this.calcUserService = calcUserService;
    }

    ConsoleSessions consoleSession;
    History history;
    RegistrationDate registrationDate = new RegistrationDate();


    String filePath = "src/ConsoleCalculatorRev0/UserSession/ConsoleSession.txt";

    public ConsoleSessions() {
        this.history = new FileHistory(filePath);

    }


    public CalculatorUser getCurrentUser() {
        return calculatorUser;
    }


    public void setCalculatorUser(CalculatorUser calculatorUser) {
        this.calculatorUser = calculatorUser;
    }



    @Override
public CalculatorUser readCurrentUser(){

    try(BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
        String line = "";


        if ((line = bufferedReader.readLine()) != null) {

            String[] fields = line.split(" ");

            if (fields.length == 6) {
                Integer userID = Integer.parseInt(fields[0]);

                return calcUserService.getCalculatorUserByID(userID);
            }
        }
    }catch (IOException e) {
        throw new RuntimeException(e);
    }
    return null;

}




    @Override
    public void writeUserInSessionHistory(CalculatorUser calculatorUser){

        this.calculatorUser = calculatorUser;

        try(FileWriter fileWriter = new FileWriter(filePath, false)) {

            fileWriter.write(calculatorUser.getUserID() + " " + calculatorUser.getUserName() + " " + calculatorUser.getUserEmail() +
                    " " + calculatorUser.getUserPassword() + " " + registrationDate.getFormatDateTime());
            fileWriter.write('\n');

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



    @Override
    public void writeOperationsInSessionHistory(CalcOperation calcOperation, CalculatorUser calculatorUser){

        this.calculatorUser = calculatorUser;

   history.writeHistoryWithUser(calcOperation, calculatorUser);
    }



    @Override
    //Method for user logOut
    public void logOutUser(CalculatorUser calculatorUser){

        consoleSession = null;

try(FileWriter fileWriter = new FileWriter(filePath, false)) {
    fileWriter.write("");

} catch (IOException e) {
    throw new RuntimeException(e);
}
    }



}
