package ConsoleCalculatorRev0.CalculatorUsers;

import ConsoleCalculatorRev0.IO.ConsoleWriter;
import ConsoleCalculatorRev0.Objects.CalculatorUser;
import ConsoleCalculatorRev0.Services.RegistrationDate;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SaveNewUserInJDBC implements SaveNewUser {

    private final String URL1 = "jdbc:postgresql://localhost:5432/postgres";
    private final String USER1 = "postgres";
    private final String PASSWORD1 = "PGPangalin013$";

    ConsoleWriter consoleWriter = new ConsoleWriter();
    RegistrationDate registrationDate = new RegistrationDate();
//    CalculatorUser calculatorUser = new CalculatorUser();


    Integer lastID;

    //Determine user ID
//public SaveNewUserInJDBC(){
//
//    Connection connection;
//    try {
//        connection = DriverManager.getConnection(URL1, USER1, PASSWORD1);
//        Statement statement = connection.createStatement();
//    ResultSet resultSet = statement.executeQuery("select count(id) from \"Calculator_users\" where id >= 0");
//
//    resultSet.next();
//lastID = resultSet.getInt(1);
//
//    } catch (SQLException e) {
//        throw new RuntimeException(e);
//    }
//
//}

    public SaveNewUserInJDBC(){
//        Connection connection;
//        try {
//            connection = DriverManager.getConnection(URL1, USER1, PASSWORD1);
//
//            PreparedStatement prepareStatement = connection.prepareStatement("SELECT id FROM \"Calculator_users\"");
//            lastID = prepareStatement.getResultSet().getInt(5);
//
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }


    }


    @Override
    public void  saveNewUser(CalculatorUser calculatorUser) {   //Integer userID, String username, String userEmail, String userPassword, String registrationDate

        try {
            Connection connection = DriverManager.getConnection(URL1, USER1, PASSWORD1);

            PreparedStatement prepareStatement = connection.prepareStatement("insert into \"Calculator_users\" values (?, ?, ?, ?, default)", Statement.RETURN_GENERATED_KEYS);
//            prepareStatement.setInt(5, calculatorUser.getUserID());

            prepareStatement.setString(1, calculatorUser.getUserName());

            prepareStatement.setString(2, calculatorUser.getUserEmail());
            prepareStatement.setString(3, calculatorUser.getUserPassword());
            prepareStatement.setString(4, registrationDate.getFormatDateTime());

            prepareStatement.execute();

            ResultSet resultSet = prepareStatement.getGeneratedKeys();
//            int generatedKey = 0;

            if(resultSet.next()){
                lastID = resultSet.getInt(5);
            }

            calculatorUser.setUserID(lastID);


            prepareStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


    @Override
    public List<CalculatorUser> addUsersInfoToArrayList() {
//        List<CalculatorUser> usersInfoFromJDBCToList = new ArrayList<>();
        List<CalculatorUser> usersInfoFromJDBCToList;


        try {
            Connection connection = DriverManager.getConnection(URL1, USER1, PASSWORD1);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from \"Calculator_users\"");
           usersInfoFromJDBCToList = new ArrayList<>();


            while (resultSet.next()) {
                Integer userID = resultSet.getInt(5);
                String userName = resultSet.getString(1);
                String userEmail = resultSet.getString(2);
                String userPassword = resultSet.getString(3);
                String registrationDate = resultSet.getString(4);

                CalculatorUser calculatorUser = new CalculatorUser(userID, userName, userEmail, userPassword, registrationDate);

                usersInfoFromJDBCToList.add(calculatorUser);
            }
            statement.close();


            } catch(SQLException e){
                throw new RuntimeException(e);
            }


        return usersInfoFromJDBCToList;
    }


    @Override
    public CalculatorUser getOldUserByID(Integer id){

        try {
            Connection connection = DriverManager.getConnection(URL1, USER1, PASSWORD1);
            PreparedStatement preparedStatement = connection.prepareStatement("select * from \"Calculator_users\" where id = ?");

            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String userName = resultSet.getString(1);
                Integer userID = resultSet.getInt(5);
                String userEmail = resultSet.getString(2);
                String userPassword = resultSet.getString(3);
                String registrationDate = resultSet.getString(4);

                CalculatorUser calculatorUser = new CalculatorUser(userID, userName, userEmail, userPassword, registrationDate);

                return calculatorUser;
            }
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }

        consoleWriter.printMessage("User with this ID doesn't exist");
        return null;
    }


    public Optional<CalculatorUser> getUserByName(String userName){

        try {
            Connection connection = DriverManager.getConnection(URL1, USER1, PASSWORD1);

        PreparedStatement preparedStatement = connection.prepareStatement("select * from \"Calculator_users\" where name = ?");
preparedStatement.setString(1, userName);

ResultSet resultSet = preparedStatement.executeQuery();

if(resultSet.next()){
    userName = resultSet.getString(1);
    Integer userID = resultSet.getInt(5);
    String userEmail = resultSet.getString(2);
    String userPassword = resultSet.getString(3);
    String registrationDate = resultSet.getString(4);

    CalculatorUser calculatorUser = new CalculatorUser(userID, userName, userEmail, userPassword, registrationDate);

return Optional.of(calculatorUser);

}
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }

        return Optional.empty();

    }
}
