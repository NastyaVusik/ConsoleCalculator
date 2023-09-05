package ConsoleCalculatorRev0.CalculationHistory.JDBCStorage;

import ConsoleCalculatorRev0.CalculationHistory.History;
import ConsoleCalculatorRev0.IO.ConsoleWriter;
import ConsoleCalculatorRev0.Objects.CalcOperation;
import ConsoleCalculatorRev0.Objects.CalculatorUser;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCHistory implements History {

    ConsoleWriter consoleWriter = new ConsoleWriter();

    private final String URL1 = "jdbc:postgresql://localhost:5432/postgres";
    private final String USER1 = "postgres";
    private final String PASSWORD1 = "root";


    @Override
    public void writeHistory(CalcOperation calcOperation) {

        try {
            Connection connection = DriverManager.getConnection(URL1, USER1, PASSWORD1);

            PreparedStatement prepareStatement = connection.prepareStatement("insert into \"Calculation_history\" values (?, ?, ?, ?, ?)");
            prepareStatement.setDouble(1, calcOperation.getNum1());

            prepareStatement.setDouble(2, calcOperation.getNum2());

            prepareStatement.setString(3, calcOperation.getAction());
            prepareStatement.setDouble(4, calcOperation.getResult());
            prepareStatement.setString(5, calcOperation.getFormatDateTime());

            prepareStatement.execute();
            prepareStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }



    @Override
    public void writeHistoryWithUser(CalcOperation calcOperation, CalculatorUser calculatorUser) {

        try {
        Connection connection = DriverManager.getConnection(URL1, USER1, PASSWORD1);

            PreparedStatement prepareStatement = connection.prepareStatement("insert into \"Calculation_historyWithUser\" values (?, ?, ?, ?, ?, ?)");
            prepareStatement.setDouble(1, calcOperation.getNum1());

            prepareStatement.setDouble(2, calcOperation.getNum2());

            prepareStatement.setString(3, calcOperation.getAction());
            prepareStatement.setDouble(4, calcOperation.getResult());
            prepareStatement.setString(5, calcOperation.getFormatDateTime());
            prepareStatement.setInt(6, calculatorUser.getUserID());

prepareStatement.execute();
        prepareStatement.close();
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }

    }


    @Override
    public ArrayList<String> getOperationHistory(){

        try {
            Connection connection = DriverManager.getConnection(URL1, USER1, PASSWORD1);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from \"Calculation_history\"");

            ArrayList <String> operationList = new ArrayList<>();

            while (resultSet.next()) {
                double num1 = resultSet.getDouble(1);
                double num2 = resultSet.getDouble(2);
                String action = resultSet.getString(3);
                double result = resultSet.getDouble(4);
                String date = resultSet.getString(5);
                Integer userID = resultSet.getInt(6);

                CalcOperation calcOperation = new CalcOperation(num1, num2, action, result, date, userID);

                operationList.add(String.valueOf(calcOperation));

//                return operationList;
            }
            return operationList;

        }catch (SQLException e) {
            throw new RuntimeException(e);
        }

//        return null;
    }
}

