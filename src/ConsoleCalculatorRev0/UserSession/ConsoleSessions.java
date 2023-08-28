package ConsoleCalculatorRev0.UserSession;

import ConsoleCalculatorRev0.CalculatorUsers.*;
import ConsoleCalculatorRev0.Objects.CalculatorUser;
import ConsoleCalculatorRev0.Services.CalcUserService;
import ConsoleCalculatorRev0.Services.LoginOldUserService;

import java.io.*;

public class ConsoleSessions implements Session {
    private CalculatorUser calculatorUser;
    private ConsoleSessions consoleSession;

    CalcUserService calcUserService = new CalcUserService();
LoginOldUserService loginOldUserService = new LoginOldUserService();

    SaveNewUser getNewUserFromList = new SaveNewUserInList();
    SaveNewUser getNewUserFromFile = new SaveNewUserInFile();


    String filePath = "src/ConsoleCalculatorRev0/UserSession/ConsoleSession.txt";

    public ConsoleSessions() {

    }

    public ConsoleSessions(ConsoleSessions consoleSession) {
        this.consoleSession = consoleSession;
    }


    public ConsoleSessions getConsoleSession() {
        return consoleSession;
    }

    public CalculatorUser getCurrentUser() {
        return calculatorUser;
    }


@Override
public CalculatorUser setUserInSession(){

    try(BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
        String line = "";

        while (bufferedReader.readLine() != null) {
            line = bufferedReader.readLine();
            String[] fields = line.split(" ");

            Integer userID = Integer.valueOf(fields[0]);

            CalculatorUser calculatorUserByID = calcUserService.getCalculatorUserByID(userID);
            return calculatorUserByID;
        }
    }catch (IOException e) {
        throw new RuntimeException(e);
    }
    return null;

}




    @Override
    public void writeUserInSession(CalculatorUser calculatorUser){
        this.calculatorUser = calculatorUser;

        try(FileWriter fileWriter = new FileWriter(filePath, false)) {
            fileWriter.write(String.valueOf(calculatorUser));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    //Method for user logOut
    public void logOutUser(){

        consoleSession = null;

try(FileWriter fileWriter = new FileWriter(filePath, false)) {
    fileWriter.write("");

} catch (IOException e) {
    throw new RuntimeException(e);
}
    }



}
