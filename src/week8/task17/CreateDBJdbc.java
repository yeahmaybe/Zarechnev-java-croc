package week8.task17;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateDBJdbc {
    static final String DATABASE_URL = "jdbc:postgresql://localhost:5432/";
    static final String USER = "postgres";
    static final String PASSWORD = "postgres";

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        try (Connection connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
             Statement statement = connection.createStatement()) {

            String SQLcreateDB = "CREATE DATABASE newDB";
            statement.executeUpdate(SQLcreateDB);

            String SQLcreateOrderHeaderTable =
            "CREATE TABLE OrderHeader";
            statement.executeUpdate(SQLcreateOrderHeaderTable);

            String SQLcreateOrderHeaderDetail = "CREATE TABLE OrderHeader";

        }
    }
}