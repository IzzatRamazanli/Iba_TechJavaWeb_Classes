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
                    double plus = this.op.add(xr, yr);
                    String result = "";
                    history.save(result);
                    writer.println(result);
                }
                case "minus" -> {
                    double minus = this.op.subtract(xr, yr);
                    String result = "";
                    history.save(result);
                    writer.println(result);
                }
                case "mult" -> {
                    double mult = this.op.multiply(xr, yr);
                    String result = xr + "*" + yr;
                    history.save(result + "=" + mult);
                    writer.println(result);
                }
                case "div" -> {
                    double div = this.op.divide(xr, yr);
                    String result = "";
                    history.save(result);
                    writer.println(result);
                }
                default -> writer.println("Wrong operation");
            }
        }
    }

    private double parseDouble(String param) {
        return Double.parseDouble(param);
    }

}
