package lesson3;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

@SuppressWarnings("all")
public class DatabaseIntro {
    public static void main(String[] args) {
        DbHelper helper = new DbHelper();
        ResultSet resultSet;
        try (Connection connection = helper.connection(); Statement statement = connection.createStatement()) {
            resultSet = statement.executeQuery("SELECT * FROM card");
            ArrayList<Card> cards = new ArrayList<>();
            while (resultSet.next()) {
                cards.add(new Card(resultSet.getInt("id"),
                        resultSet.getString("pan"),
                        resultSet.getString("type"),
                        resultSet.getInt("price"),
                        resultSet.getInt("img")));
            }
            System.out.println(cards.size());
            System.out.println(cards);

        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
        }
    }
}
