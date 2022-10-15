package lesson2;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;

public class StaticFileServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String requestedName = req.getPathInfo();

        if (requestedName.startsWith("/")) requestedName = requestedName.substring(1);

        URI fileName = null;
        try {
            fileName = URIHandler.getUri(requestedName, this);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
        System.out.println(requestedName);
        System.out.println(fileName);

        try (ServletOutputStream outputStream = resp.getOutputStream()) {
            Files.copy(Path.of(fileName), outputStream);
        }


    }

}
