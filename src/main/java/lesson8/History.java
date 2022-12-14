package lesson8;

import java.sql.SQLException;
import java.util.List;

public interface History {
    void save(String user, HistoryItem item) ;

    List<HistoryItem> getAll(String user);

    void delete(String user);
}
