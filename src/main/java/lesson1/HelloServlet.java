package lesson1;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

public class HelloServlet extends HttpServlet {
    /*http://localhost:8080/hello?x=5&y=80*/
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        String queryString = req.getQueryString();
        String xs = req.getParameter("x");
        String ys = req.getParameter("y");
        String zs = req.getParameter("z");

        Map<String, String[]> parameterMap = req.getParameterMap();

        int x = Integer.parseInt(xs);
        int y = Integer.parseInt(ys);
        int z = Integer.parseInt(zs);
        int sum = x + y + z;

        try (PrintWriter writer = resp.getWriter()) {
            writer.println(parameterMap);
            writer.println(queryString);
            writer.printf("Hello, %d, %d, %d given, the sum is %d", x, y, z, sum);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (PrintWriter writer = resp.getWriter()) {
            writer.println("custom-header: " + req.getHeader("Custom-Header"));
            writer.println("username: " + req.getParameter("username"));
            writer.println("password: " + req.getParameter("password"));
            writer.println("Post handling");
        }
    }
}
