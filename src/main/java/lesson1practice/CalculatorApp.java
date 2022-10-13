package lesson1practice;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

import java.util.ArrayList;
import java.util.List;

public class CalculatorApp {
    public static void main(String[] args) throws Exception {

        Server server = new Server(8080);
        ServletContextHandler handler = new ServletContextHandler();

        List<String > list = new ArrayList<>();
        CalculatorOperations op = new CalculatorOperations();
        CalculatorHistory history = new CalculatorHistory(list);

        CalculatorServlet calculatorServlet = new CalculatorServlet(op, history);
        HistoryServlet historyServlet = new HistoryServlet(history);

        handler.addServlet(new ServletHolder(calculatorServlet), "/calc");
        handler.addServlet(new ServletHolder(historyServlet), "/calc/his");

        server.setHandler(handler);
        server.start();
        server.join();

    }
}
