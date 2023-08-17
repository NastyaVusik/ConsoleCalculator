package ConsoleCalculatorRev0.CalculatorUsers;

import ConsoleCalculatorRev0.ConsoleReader;
import ConsoleCalculatorRev0.ConsoleWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AllUsersMapCollection {

    //Create object of class ConsoleWriter
    private final ConsoleWriter consoleWriter = new ConsoleWriter();

    //Create object of class ConsoleReader
    private final ConsoleReader consoleReader = new ConsoleReader();

    //Create Map collection
    private Map<Integer, String> allUsersMapList = new HashMap<>();

    //Create object of class RegisterNewUser
    RegisterNewUser registerNewUser;
    CalculatorUser calculatorUser;


    public AllUsersMapCollection(RegisterNewUser registerNewUser){
        this.registerNewUser = registerNewUser;
    }


    //Method for filling Map List
    public Map<Integer, String> fillAllUserMapList(){

        String filePath = "src/ConsoleCalculatorRev0/CalculatorUsers/AllUsersMap.txt";

        //Create file object
        File allUsersMapFile = new File(filePath);

        try(FileWriter writer = new FileWriter(allUsersMapFile, true)) {
writer.write(registerNewUser.userID);
writer.write(registerNewUser.registerNewUser(calculatorUser).toString());
        } catch (IOException e){
            e.printStackTrace();
        }




        return allUsersMapList;
    }

}
