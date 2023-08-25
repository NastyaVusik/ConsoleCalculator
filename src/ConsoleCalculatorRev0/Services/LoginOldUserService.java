//package ConsoleCalculatorRev0.Services;
//
//import ConsoleCalculatorRev0.CalculatorUsers.SaveNewUserInFile;
//import ConsoleCalculatorRev0.IO.ConsoleReader;
//import ConsoleCalculatorRev0.IO.ConsoleWriter;
//import ConsoleCalculatorRev0.Objects.CalculatorUser;
//
//import java.io.*;
//import java.util.List;
//
//public class LoginOldUserService {
//
//    //Create object of class ConsoleWriter
//    private final ConsoleWriter consoleWriter = new ConsoleWriter();
//
//    //Create object of class ConsoleReader
//    private final ConsoleReader consoleReader = new ConsoleReader();
//
//    //Create object of class SaveAllUsersInFile
//    SaveNewUserInFile saveAllUsersInFile = new SaveNewUserInFile();
//
//
//    //Method for authorisation of old user
//    public CalculatorUser checkUsernamePassword() throws IOException {
//
//        while (true) {
//            consoleWriter.printMessage("\nEnter your username: ");
//            String userName = consoleReader.readAction();
//
//            consoleWriter.printMessage("\nEnter your password: ");
//            String userPassword = consoleReader.readAction();
//
//            List<CalculatorUser> calculatorUserList =  saveAllUsersInFile.getUsersInfoArrayList();
//            CalculatorUser oldUser = null;
//
//            for(CalculatorUser user : calculatorUserList){
//                boolean match = (userName.equalsIgnoreCase(user.getUserName()) && userPassword.equals(user.getUserPassword()));
//
//                if(match){
//                    oldUser = user;
//            }
//
//                    if (oldUser != null) {
//                        consoleWriter.printMessage("Hi, " + oldUser.getUserName() + " with ID = "
//                                + oldUser.getUserID() + "!" + "Registration is successful!\n");
//                    } else {
//                        consoleWriter.printMessage("\nYou username or password are wrong. Please, try again.\n");
//                    }
//
//                    return oldUser;
//                }
//
//        }
//    }
//}
