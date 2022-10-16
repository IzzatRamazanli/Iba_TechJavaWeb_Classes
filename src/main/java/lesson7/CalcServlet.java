package lesson7;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;
import java.util.UUID;

public class CalcServlet extends HttpServlet {
    /*http://localhost:8080/calc?x=5&y=7*/
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Cookie[] cookies = req.getCookies();
        Optional<String> found = Optional.empty();

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(SessionRelated.COOKIE_NAME)) {
                    found = Optional.of(cookie.getValue());
                }
            }
        }

        try (PrintWriter writer = resp.getWriter()) {

            writer.printf("user id is : %s\n", found.orElse("not found\n"));

            String xs = req.getParameter("x");
            String ys = req.getParameter("y");
            int x = Integer.parseInt(xs);
            int y = Integer.parseInt(ys);
            int z = x + y;

            writer.printf("adding... %d + %d = %d", x, y, z);
        }
        if (found.isEmpty()) {
            resp.addCookie(new Cookie(SessionRelated.COOKIE_NAME, UUID.randomUUID().toString()));
        }
    }
}
