package jdbc_h2;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class H2DeleteCity {
    private static final String deleteTableSQL = "delete from cities where id = 1";

    public static void main(String[] argv) throws SQLException {
        H2DeleteCity deleteExample = new H2DeleteCity();
        deleteExample.deleteRecord();
    }

    public void deleteRecord() throws SQLException {

        System.out.println(deleteTableSQL);
        // Step 1: Establishing a Connection
        try (Connection connection = H2JDBCUtils.getConnection();
             // Step 2:Create a statement using connection object
             Statement statement = connection.createStatement();) {

            // Step 3: Execute the query or update query
            statement.execute(deleteTableSQL);

        } catch (SQLException e) {
            // print SQL exception information
            H2JDBCUtils.printSQLException(e);
        }
    }
}
