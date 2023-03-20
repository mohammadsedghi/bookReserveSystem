package ir.bookReserveSystem.connection;

import java.sql.DriverManager;

public class JdbcConnection {
    public static final String DB_URL = "jdbc:postgresql://localhost/irmaktab";
    public static final String USER = "postgres";
    public static final String PASS = "12345";
    public static java.sql.Connection getConnection() {
        try {
            java.sql.Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);

            return connection;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
}
