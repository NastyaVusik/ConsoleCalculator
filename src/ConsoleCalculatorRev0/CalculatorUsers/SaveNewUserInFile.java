package ConsoleCalculatorRev0.CalculatorUsers;

import ConsoleCalculatorRev0.ConsoleReader;
import ConsoleCalculatorRev0.ConsoleWriter;

import javax.xml.stream.events.Characters;
import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SaveNewUserInFile implements SaveNewUser {

    //Create object of class ConsoleWriter
    private final ConsoleWriter consoleWriter = new ConsoleWriter();

    //Create object of class ConsoleReader
    private final ConsoleReader consoleReader = new ConsoleReader();

    String filePath = "src/ConsoleCalculatorRev0/CalculatorUsers/AllUsersFile.txt";
    Integer lastID = 0;


    public SaveNewUserInFile() {
        if(!getUsersInfoArrayList().isEmpty()) {
            lastID = getUsersInfoArrayList().size();
        }
        else {
            lastID = 0;
        }
    }


    @Override
    public void saveNewUser(CalculatorUser calculatorUser) {
        lastID++;
        calculatorUser.setUserID(lastID);


        try (FileWriter fileWriter = new FileWriter(filePath, true)) {

            fileWriter.write(calculatorUser.getUserID() + " " + calculatorUser.getUserName() + " " + calculatorUser.getUserEmail() +
                    " " + calculatorUser.getUserPassword() + " " + calculatorUser.getFormatDateTime());
            fileWriter.write('\n');

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public List<CalculatorUser> getUsersInfoArrayList() {

        List<CalculatorUser> usersInfoFromFileToList = new ArrayList<>();
//        List<CalculatorUser> Optional = new ArrayList<>();
        if (!usersInfoFromFileToList.isEmpty()) {
            try {
                List<String> list = Files.readAllLines(
                        new File(filePath).toPath());

                list.stream().forEach(s -> {
                    String[] fields = s.split(" ");
                    CalculatorUser calculatorUser = new CalculatorUser();
                    calculatorUser.setUserID(Integer.valueOf(fields[0]));
                    calculatorUser.setUserName(fields[1]);
                    calculatorUser.setUserEmail(fields[2]);
                    calculatorUser.setUserPassword(fields[3]);
                    calculatorUser.setFormatDateTime(fields[4]);
                    usersInfoFromFileToList.add(calculatorUser);
                });

            } catch (IOException e) {
                e.printStackTrace();
            }
            return usersInfoFromFileToList;
        }
//        else return Optional;
        else return null;

    }
    }



