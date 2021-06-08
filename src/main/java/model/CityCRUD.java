package model;

import jdbc_h2.H2JDBC;
import jdbc_h2.H2JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CityCRUD implements H2JDBC <City> {

    @Override
    public void createTable() {
        final String createTableSQL = "create table citycrud (\r\n" +
                "  id  int(5) primary key auto_increment,\r\n" +
                "  name varchar(20),\r\n" +
                "  region varchar(20),\r\n" +
                "  district varchar(20),\r\n" +
                "  population int(20),\r\n" +
                "  foundation int(20)\r\n" + "  );";

        try (Connection connection = H2JDBCUtils.getConnection();
             // Step 2:Create a statement using connection object
             Statement statement = connection.createStatement();) {

            // Step 3: Execute the query or update query
            statement.execute(createTableSQL);

        } catch (SQLException e) {
            // print SQL exception information
            H2JDBCUtils.printSQLException(e);
        }
    }

    @Override
    public void insertRecord(City city) {
        final String INSERT_CITY_SQL = "INSERT INTO cities" +
                "  (id, name, region, district, population, foundation) VALUES " +
                " (?, ?, ?, ?, ?, ?);";

        try (Connection connection = H2JDBCUtils.getConnection();
             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CITY_SQL)) {
            preparedStatement.setInt(1, 2);
            preparedStatement.setString(2, "Москва");
            preparedStatement.setString(3, "Московская область");
            preparedStatement.setString(4, "Центральный");
            preparedStatement.setInt(5, 11_000_000);
            preparedStatement.setInt(6, 1800);

            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            preparedStatement.executeUpdate();
        } catch (SQLException e) {

            // print SQL exception information
            H2JDBCUtils.printSQLException(e);
        }
    }

    @Override
    public void updateRecord(City city) {

    }


    @Override
    public void deleteRecord() {

    }

    @Override
    public void selectRecord() {

    }

}
