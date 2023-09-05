package ConsoleCalculatorRev0.CalculatorUsers;

import ConsoleCalculatorRev0.Objects.CalculatorUser;
import ConsoleCalculatorRev0.Services.CalcUserService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class SaveNewUserInList implements SaveNewUser{

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


    public List<CalculatorUser> getUsersInfoArrayList() {
        return usersInfoArrayList;
    }
}



