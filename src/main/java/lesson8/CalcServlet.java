package lesson8;


import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class CalcServlet extends HttpServlet {
    /*http://localhost:8080/calc?x=5&y=7*/

    private final History history;

    public CalcServlet(History history) {
        this.history = history;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String user = SessionRelated.findOrDie(req).getValue();

        try (PrintWriter writer = resp.getWriter()) {

            writer.printf("user id is : %s\n", user);

            String xs = req.getParameter("x");
            String ys = req.getParameter("y");
            int x = Integer.parseInt(xs);
            int y = Integer.parseInt(ys);
            int z = x + y;
            history.save(user, new HistoryItem(x, y, z));
            writer.printf("adding... %d + %d = %d", x, y, z);
        }


    }
}
