package lesson2;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FormServlet extends HttpServlet {

    /*http://localhost:8080/form*/

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String badExample = "src/main/resources/templates/form.ftl";

        List<String> lines = Files.readAllLines(Path.of(badExample));
        try (PrintWriter writer = resp.getWriter()) {
            for (String line : lines) {
                writer.println(line);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (PrintWriter writer = resp.getWriter()) {
            String username = req.getParameter("username");
            String password = req.getParameter("password");
            writer.printf("user entered: %s %s", username, password);
        }
    }
}
