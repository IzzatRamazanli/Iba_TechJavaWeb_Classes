package lesson8;


import java.util.Map;

public interface Session {
    void save(String user, String key, Object value);

    Map<String, Object> getAll(String user);
}
