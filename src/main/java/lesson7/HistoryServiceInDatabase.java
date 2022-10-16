package lesson7;

import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HistoryServiceInDatabase implements History {
    private final Connection connection;

    public HistoryServiceInDatabase(Connection connection) {
        this.connection = connection;
    }

    @SneakyThrows
    @Override
    public void save(String user, HistoryItem item) {
        String query = "insert into history (u, x, y, z, t) values (?, ?,?,?,?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, user);
            statement.setInt(2, item.x);
            statement.setInt(3, item.y);
            statement.setInt(4, item.z);
            statement.setString(5, item.ldt.toString());
            statement.executeUpdate();
        }


    }

    @Override
    @SneakyThrows
    public List<HistoryItem> getAll(String user) {
        ArrayList<HistoryItem> data = new ArrayList<>();
        String query = "select * from history where u=?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, user);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                data.add(new HistoryItem(resultSet.getInt("x"),
                        resultSet.getInt("y"),
                        resultSet.getInt("z")));
            }

        }

        return data;
    }

    @Override
    @SneakyThrows
    public void delete(String user) {
        String query = "delete from history where u=?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, user);
            statement.execute();
        }
    }
}
