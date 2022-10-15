package lesson2;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class RagnarFileServlet extends HttpServlet {
    /*http://localhost:8080/ragnar.jpg*/
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        URI uri;
        try {
            uri = URIHandler.getUri("ragnar.jpg", this);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }

        try (ServletOutputStream outputStream = resp.getOutputStream()) {
            Files.copy(Path.of(uri), outputStream);
        }


    }

}
