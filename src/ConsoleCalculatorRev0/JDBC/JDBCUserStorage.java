package ConsoleCalculatorRev0.JDBC;

import ConsoleCalculatorRev0.IO.ConsoleWriter;
import ConsoleCalculatorRev0.Objects.CalcOperation;
import ConsoleCalculatorRev0.Objects.CalculatorUser;

import java.sql.*;

public class JDBCUserStorage {

    ConsoleWriter consoleWriter = new ConsoleWriter();



    public void addUserToJDBC(CalcOperation calcOperation, CalculatorUser calculatorUser) {   //Integer userID, String username, String userEmail, String userPassword, String registrationDate

        try {
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "root");

            PreparedStatement prepareStatement = connection.prepareStatement("insert into \"Calculator_users\" values (?, ?, ?, ?, ?)");
            prepareStatement.setInt(1, calculatorUser.getUserID());

            prepareStatement.setString(2, calculatorUser.getUserName());

            prepareStatement.setString(3, calculatorUser.getUserEmail());
            prepareStatement.setString(4, calculatorUser.getUserPassword());
            prepareStatement.setString(5, calcOperation.getFormatDateTime());

            prepareStatement.execute();
            prepareStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


    public CalculatorUser getUserByID(Integer userID){

        try {
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "root");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from \"Calculator_users\" where id = ?");

            while (resultSet.next()) {
                userID = resultSet.getInt(1);
                String userName = resultSet.getString(2);
                String userEmail = resultSet.getString(3);
                String userPassword = resultSet.getString(4);
                String registrationDate = resultSet.getString(5);

                CalculatorUser calculatorUser = new CalculatorUser(userID, userName, userEmail, userPassword, registrationDate);

                return calculatorUser;
            }
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }

        consoleWriter.printMessage("User with this ID doesn't exist");
        return null;
    }
}
