package lesson2;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class ShowTextFileServlet extends HttpServlet {
    /*http://localhost:8080/showtextfile*/
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        //this is hard coding
        String badExample = "src/main/resources/templates/test.ftl";

//        //must create resources directory under main folder
//        URI uri;
//        try {
//            uri = URIHandler.getUri("test.ftl", this);
//        } catch (URISyntaxException e) {
//            throw new RuntimeException(e);
//        }

        List<String> lines = Files.readAllLines(Path.of(badExample));
        try (PrintWriter writer = resp.getWriter()) {
            for (String line : lines) {
                writer.println(line);
            }
        }
    }

}
