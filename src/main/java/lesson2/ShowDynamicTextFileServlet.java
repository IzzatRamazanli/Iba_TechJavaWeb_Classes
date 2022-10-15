package lesson2;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;

public class ShowDynamicTextFileServlet extends HttpServlet {
    /*http://localhost:8080/dynamic*/

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        HashMap<String, String> data = new HashMap<>();
        data.put("iphone 14", "3000");
        data.put("macbook", "5000");
        data.put("macbook 16", "6000");

        URI uri;
        try {
            uri = URIHandler.getUri("test2.html", this);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }

        List<String> lines = Files.readAllLines(Path.of(uri));
        try (PrintWriter writer = resp.getWriter()) {
            for (String line : lines) {
                writer.println(line);
            }
        }
    }

}
