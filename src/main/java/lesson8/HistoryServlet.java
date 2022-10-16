package lesson8;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class HistoryServlet extends HttpServlet {
    /*http://localhost:8080/history*/

    private final History history;
    private final static ObjectMapper mapper = new ObjectMapper();

    public HistoryServlet(History history) {
        this.history = history;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String user = SessionRelated.findOrDie(req).getValue();
        boolean isJson = !req.getParameter("json").isEmpty();

        try (PrintWriter writer = resp.getWriter()) {
            writer.println("history:");
            List<HistoryItem> items = history.getAll(user);

            if (isJson) {
                String json = mapper.writeValueAsString(items);
                writer.println(json);
            } else items.forEach(writer::println);

        }
    }
}
