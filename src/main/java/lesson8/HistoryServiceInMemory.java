package lesson8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HistoryServiceInMemory implements History {
    private final Map<String, List<HistoryItem>> data = new HashMap<>();

    @Override
    public void save(String user, HistoryItem item) {
        List<HistoryItem> historyPerUser = data.getOrDefault(user, new ArrayList<>());
        historyPerUser.add(item);
        if (historyPerUser.size() == 1) data.put(user, historyPerUser);
    }

    @Override
    public List<HistoryItem> getAll(String user) {
        return data.getOrDefault(user, new ArrayList<>());
    }
}
