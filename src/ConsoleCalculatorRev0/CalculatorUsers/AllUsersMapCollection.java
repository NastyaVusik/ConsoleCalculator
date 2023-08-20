package ConsoleCalculatorRev0.CalculatorUsers;

import ConsoleCalculatorRev0.ConsoleReader;
import ConsoleCalculatorRev0.ConsoleWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AllUsersMapCollection {

    //Create object of class ConsoleWriter
    private final ConsoleWriter consoleWriter = new ConsoleWriter();

    //Create object of class ConsoleReader
    private final ConsoleReader consoleReader = new ConsoleReader();

    //Create Map collection
    private Map<Integer, CalculatorUser> allUsersMapList = new HashMap<>();

    //Create object of class RegisterNewUser
    RegisterNewUser registerNewUser;
    CalculatorUser calculatorUser;



    //Method for filling Map List
    public void saveAllUserMapList(){

        String filePath = "src/ConsoleCalculatorRev0/CalculatorUsers/AllUsersMap.txt";

        //Create file object
        File allUsersMapFile = new File(filePath);

        try(FileWriter writer = new FileWriter(allUsersMapFile, true)) {
writer.write(calculatorUser.getUserID());
writer.write("User name: " + calculatorUser.getUserName() + ", user email: " + calculatorUser.getUserEmail() + ", user password: " + calculatorUser.getUserPassword()+ ";\n");

        } catch (IOException e){
            e.printStackTrace();
        }

        allUsersMapList.put(calculatorUser.getUserID(), calculatorUser);

    }


//    public void readAllUserMapList(){
//
//    }

    public Map<Integer, CalculatorUser> getAllUsersMapList() {
        return allUsersMapList;
    }
}
