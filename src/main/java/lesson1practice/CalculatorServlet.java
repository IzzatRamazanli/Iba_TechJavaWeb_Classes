package lesson1practice;

import lombok.RequiredArgsConstructor;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@RequiredArgsConstructor
public class CalculatorServlet extends HttpServlet {

    private final CalculatorOperations op;
    private final CalculatorHistory history;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String x = req.getParameter("x");
        String y = req.getParameter("y");
        String op = req.getParameter("operation");

        double xr = parseDouble(x);
        double yr = parseDouble(y);

        try (PrintWriter writer = resp.getWriter()) {
            switch (op) {
                case "plus" -> {
                    double result = this.op.add(xr, yr);
                    history.save(result);
                    writer.println(result);
                }
                case "minus" -> {
                    double result = this.op.subtract(xr, yr);
                    history.save(result);
                    writer.println(result);
                }
            }
        }
    }

    private double parseDouble(String param) {
        return Double.parseDouble(param);
    }

}
