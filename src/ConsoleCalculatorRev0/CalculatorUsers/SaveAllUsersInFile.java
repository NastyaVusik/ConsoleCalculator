package ConsoleCalculatorRev0.CalculatorUsers;

import ConsoleCalculatorRev0.ConsoleReader;
import ConsoleCalculatorRev0.ConsoleWriter;

import java.io.*;

public class SaveAllUsersInFile {

    //Create object of class ConsoleWriter
    private final ConsoleWriter consoleWriter = new ConsoleWriter();

    //Create object of class ConsoleReader
    private final ConsoleReader consoleReader = new ConsoleReader();

    //Create object of class RegisterNewUser
    RegisterNewUser registerNewUser;
    CalculatorUser calculatorUser;
    SaveNewUser saveNewUser = new SaveNewUserInList();


    //Method for filling Map List
//    public void saveAllUserMapList() throws FileNotFoundException {
//
//        allUsersMapList = new HashMap<>();
//        String filePath = "src/ConsoleCalculatorRev0/CalculatorUsers/UsersInfoList.txt";
//        String line = "";
//
//        try (BufferedReader breader = new BufferedReader(new FileReader(filePath))) {
//            while (!(line.equals(breader.readLine()))) {
//                String[] keyValuePair = line.split(":", 2);
//                if (keyValuePair.length > 1) {
//                    String key = keyValuePair[0];
//                    String value = keyValuePair[1];
//                    allUsersMapList.put(key, value);
//
//                }
//            }
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//        public Map<String, CalculatorUser> getAllUsersMapList() {
//            return allUsersMapList;
//        }


    public void saveAllUserInFile() throws FileNotFoundException {

        String filePath = "src/ConsoleCalculatorRev0/CalculatorUsers/AllUsersFile.txt";

        try(FileWriter fileWriter = new FileWriter(filePath, true)) {

                fileWriter.write("User ID= " + calculatorUser.getUserID() + ": user name= " + calculatorUser.getUserName() + ", user's email= " + calculatorUser.getUserEmail() +
                        ", password= " + calculatorUser.getUserPassword() + ", date and time of registration= " + calculatorUser.getFormatDateTime() + "\n");
                fileWriter.write(10);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
