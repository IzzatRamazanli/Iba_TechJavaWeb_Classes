package lesson7;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class ServerApp {
    public static void main(String[] args) throws Exception {
        Server server = new Server(8080);
        CalcServlet calcServlet = new CalcServlet();
        HistoryServlet history = new HistoryServlet();
        LogoutServlet logoutServlet = new LogoutServlet();

        ServletContextHandler handler = new ServletContextHandler();
        handler.addServlet(new ServletHolder(calcServlet), "/calc");
        handler.addServlet(new ServletHolder(history), "/history");
        handler.addServlet(new ServletHolder(logoutServlet), "/logout");

        server.setHandler(handler);
        server.start();
        server.join();

    }
}
