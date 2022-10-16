package lesson8;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;

public class HistoryServlet extends HttpServlet {
    /*http://localhost:8080/history*/

    private final History history;

    public HistoryServlet(History history) {
        this.history = history;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String user = SessionRelated.findOrDie(req).getValue();

        try (PrintWriter writer = resp.getWriter()) {
            writer.println("history:");
            history.getAll(user).forEach(writer::println);
        }
    }
}
