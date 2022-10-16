package lesson7;

import java.sql.SQLException;
import java.util.List;

public interface History {
    void save(String user, HistoryItem item) throws SQLException;

    List<HistoryItem> getAll(String user);
}
