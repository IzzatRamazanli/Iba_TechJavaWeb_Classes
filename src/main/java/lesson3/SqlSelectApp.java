package lesson3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

interface MyFunction<A, B> {
    B apply(A a) throws Exception;

}

public class SqlSelectApp {
    public static void main(String[] args) throws SQLException {
        DbHelper helper = new DbHelper();
        Connection connection = helper.connection();
        PreparedStatement st = connection
                .prepareStatement("select * from person where name like ?");
        st.setString(1, "A%");
        ResultSet result = st.executeQuery();
        while (result.next()) {
            int id = result.getInt("id");
            String name = result.getString("name");
            System.out.printf("%d: %s\n", id, name);
        }
    }

    static List<Person> remapResultSet(ResultSet set, MyFunction<ResultSet, Person> f) throws Exception {
        ArrayList<Person> people = new ArrayList<>();
        while (set.next()) {
            Person p = f.apply(set);
            people.add(p);
        }
        return people;
    }

}
