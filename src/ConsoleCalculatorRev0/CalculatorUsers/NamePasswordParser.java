package ConsoleCalculatorRev0.CalculatorUsers;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NamePasswordParser {

    private String regexUserName = "\\(.{1,16}[^\s]\\)";            //?????????????????????
private String regexUserPassword = "\\(.{6,}\\)\\(\\+[A-Z]\\){1,}\\(\\+\\d{1,}\\)\\+\\(\\S{1,}\\)";


    //Method for checking a new user's name
    public boolean checkUserName(String newUserName){
        Pattern pattern = Pattern.compile(regexUserName);
        Matcher nameMatcher = pattern.matcher(newUserName);
        if(nameMatcher.matches()){
            return true;
        }
else {
            return false;
        }
    }

    //Method for checking a new user password
    public boolean checkUserPassword(String newUserPassword){
       Pattern pattern = Pattern.compile(regexUserPassword);
       Matcher pasMatcher = pattern.matcher(newUserPassword);
       if(pasMatcher.matches()){
           return true;
       }
       else {
           return false;
       }
    }


}
