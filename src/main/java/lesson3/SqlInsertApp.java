package lesson3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@SuppressWarnings("all")
public class SqlInsertApp {
    public static void main(String[] args) throws SQLException {
        DbHelper helper = new DbHelper();
        Connection conn = helper.connection();
        PreparedStatement ps = conn
                .prepareStatement("insert into person(id,name) values (?,?)");
        ps.setInt(1, 7);
        ps.setString(2, "Tarlan");
        ps.execute();

    }
}
