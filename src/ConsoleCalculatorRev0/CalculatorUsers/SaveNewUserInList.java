package ConsoleCalculatorRev0.CalculatorUsers;

import ConsoleCalculatorRev0.Objects.CalculatorUser;
import ConsoleCalculatorRev0.Services.CalcUserService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class SaveNewUserInList implements SaveNewUser{

    CalculatorUser calculatorUser = new CalculatorUser();
    CalcUserService calcUserService = new CalcUserService();

    //Create arrayList for keeping all registered users
    private List<CalculatorUser> usersInfoArrayList = new ArrayList<>();


    //Method for saving new user in file
    @Override
    public void saveNewUser(CalculatorUser calculatorUser){
        Integer userID = usersInfoArrayList.size() + 1;
        calculatorUser.setUserID(userID);
        usersInfoArrayList.add(calculatorUser);

    }


    @Override
    public List<CalculatorUser> addUsersInfoToArrayList() {
        return usersInfoArrayList;
    }


    //Method for finding old user by userName and userPassword
    @Override
    public Optional<CalculatorUser> getOldUserFromList(String userName, String userPassword){

        List<String> list = Collections.singletonList(addUsersInfoToArrayList().stream().toString());

        for (String s : list) {
            String[] fields = s.split(" ");

            calculatorUser.setUserID(Integer.valueOf(fields[0]));
            calculatorUser.setUserName(fields[1]);
            calculatorUser.setUserEmail(fields[2]);
            calculatorUser.setUserPassword(fields[3]);
            calcUserService.setFormatDateTime(fields[4]);

            if ((userName.equalsIgnoreCase(fields[1])) && (userPassword.equals(fields[3]))) {
                return Optional.of(calculatorUser);
            }

        }

        return Optional.empty();

    }
}

