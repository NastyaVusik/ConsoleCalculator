package ConsoleCalculatorRev0.CalculatorUsers;

import java.util.ArrayList;
import java.util.List;

public class SaveNewUserInList implements SaveNewUser{

    //Create arrayList for keeping all registered users
    private List<CalculatorUser> usersInfoArrayList = new ArrayList<>();


    @Override
    public void saveNewUser(CalculatorUser calculatorUser){
        Integer userID = usersInfoArrayList.size() + 1;
        calculatorUser.setUserID(userID);
        usersInfoArrayList.add(calculatorUser);

    }


    @Override
    public List<CalculatorUser> getUsersInfoArrayList() {
        return usersInfoArrayList;
    }
}

