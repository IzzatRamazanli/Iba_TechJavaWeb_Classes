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
                    writer.println(resultStr(plus, xr, yr, "+"));
                }
                case "minus" -> {
                    double minus = this.op.subtract(xr, yr);
                    writer.println(resultStr(minus, xr, yr, "-"));
                }
                case "mult" -> {
                    double mult = this.op.multiply(xr, yr);
                    writer.println(resultStr(mult, xr, yr, "*"));
                }
                case "div" -> {
                    double div = this.op.divide(xr, yr);
                    writer.println(resultStr(div, xr, yr, "/"));
                }
                default -> writer.println("Wrong operation");
            }
        }
    }

    private String resultStr(double result, double num1, double num2, String operation) {
        String resStr = num1 + " " + operation + " " + num2 + " = " + result;
        history.save(resStr);
        return resStr;
    }

    private double parseDouble(String param) {
        return Double.parseDouble(param);
    }

}
