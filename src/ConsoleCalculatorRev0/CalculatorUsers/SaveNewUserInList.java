package ConsoleCalculatorRev0.CalculatorUsers;

import java.util.ArrayList;
import java.util.List;

public class SaveNewUserInList implements SaveNewUser{

    private List<CalculatorUser> usersInfoArrayList = new ArrayList<>();


    @Override
    public void saveNewUser(CalculatorUser calculatorUser){
//        userID = usersInfoArrayList.size() + 1;
//        calculatorUser.setUserID(userID);
        // usersInfoArrayList.set(userID, calculatorUser);           ????????????????????????????????????????????
        usersInfoArrayList.add(calculatorUser);
        usersInfoArrayList.stream().forEach(user -> System.out.println(user));

    }

//    public List<CalculatorUser> getUsersInfoArrayList() {
//        return usersInfoArrayList;
//    }
}

