package lesson2;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class HelloServlet extends HttpServlet {
    /*http://localhost:8080/hello*/
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        //this is hard coding
        String badExample = "src/main/java/lesson2/test.html";

        //must create resources directory under main folder
        String file = getClass().getClassLoader().getResource("test.html").getFile();


        List<String> lines = Files.readAllLines(Path.of(file));
        try (PrintWriter writer = resp.getWriter()) {
            for (String line : lines) {
                writer.println(line);
            }
        }
    }

}
