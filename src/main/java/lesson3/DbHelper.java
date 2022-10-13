package lesson3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbHelper {
    private String userName = "postgres";
    private String password = "root";
    private String url = "jdbc:postgresql://localhost/be5";

    public Connection connection() throws SQLException {
        return DriverManager.getConnection(url, userName, password);
    }

}
