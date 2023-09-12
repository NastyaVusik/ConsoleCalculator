package ConsoleCalculatorRev0.CalculatorUsers;

import ConsoleCalculatorRev0.Objects.CalculatorUser;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NewUserInfoChecker {

    //Create object of class SaveNewUserInList
    SaveNewUser saveNewUser;


    public NewUserInfoChecker(SaveNewUser saveNewUser){
        this.saveNewUser = saveNewUser;

    }

    private final String regexUserName = "^([^\\s]{1,16})$";
    private final String regexUserPassword = "^(?!.* )(?=.*\\d)(?=.*[A-Z]).{8,15}$";
    private final String regexUserEmail = "^(.+)@(.+)$";


    //Method for checking a new user's name
    public boolean checkUserName(String userName) {
        Pattern pattern = Pattern.compile(regexUserName);
        Matcher nameMatcher = pattern.matcher(userName);
        return nameMatcher.matches();
    }

    //Method for checking a new user password
    public boolean checkUserPassword(String userPassword) {
        Pattern pattern = Pattern.compile(regexUserPassword);
        Matcher pasMatcher = pattern.matcher(userPassword);
        return pasMatcher.matches();
    }


    //Method for checking a new email
    public boolean checkUserEmail(String userEmail) {
        Pattern pattern = Pattern.compile(regexUserEmail);
        Matcher emailMatcher = pattern.matcher(userEmail);
        return emailMatcher.matches();
    }


    //Method for checking, if userName is already applied
    public boolean isUserNameOccupied(String userName) {

        List < CalculatorUser> calculatorUserList = saveNewUser.addUsersInfoToArrayList();

        for (int i = 0; i < calculatorUserList.size(); i++) {
            if (calculatorUserList.get(i).getUserName().equalsIgnoreCase(userName)){
                return true;
            }
        }
        return false;
        }


        //Method for checking, if newUserEmail is already applied
        public boolean isUserEmailOccupied(String userEmail){

//        String userEmail1 = registerNewUser.getUsersInfoArrayList().stream().filter(email -> {return email.equals(userEmail)}).findAny().orElse(null);

            for(int i = 0; i < saveNewUser.addUsersInfoToArrayList().size(); i++){

            return (saveNewUser.addUsersInfoToArrayList().get(i).getUserEmail()).equals(userEmail);
        }
return false;
    }
}
