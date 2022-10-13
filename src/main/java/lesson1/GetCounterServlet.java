package lesson1;

import lombok.RequiredArgsConstructor;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@RequiredArgsConstructor
public class GetCounterServlet extends HttpServlet {
    private final Counter c;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (PrintWriter writer = resp.getWriter()) {
            writer.println("counted " + c.getX());
        }
    }
}
