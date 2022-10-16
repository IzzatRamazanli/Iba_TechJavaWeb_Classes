package lesson7;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;
import java.util.UUID;

public class LogoutServlet extends HttpServlet {
    /*http://localhost:8080/logout*/

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        Optional<Cookie> found = SessionRelated.find(req);
        found.ifPresent(cookie -> {
            cookie.setMaxAge(0);
            resp.addCookie(cookie);
        });

        try (PrintWriter writer = resp.getWriter()) {
            String message = found
                    .map(Cookie::getValue)
                    .map(x -> String.format("user %s successfully logged out", x))
                    .orElse("there was no logged user");
            writer.println(message);
        }


    }
}
