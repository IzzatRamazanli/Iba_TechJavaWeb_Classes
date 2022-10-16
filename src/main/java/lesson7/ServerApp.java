package lesson7;

import lesson3.DbHelper;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

import java.sql.Connection;

public class ServerApp {
    public static void main(String[] args) throws Exception {
        Server server = new Server(8080);
        DbHelper helper = new DbHelper();
        Connection connection = helper.connection();
        History historyService = new HistoryServiceInDatabase(connection);

        CalcServlet calcServlet = new CalcServlet(historyService);
        HistoryServlet history = new HistoryServlet(historyService);
        LogoutServlet logoutServlet = new LogoutServlet(historyService);

        ServletContextHandler handler = new ServletContextHandler();
        handler.addServlet(new ServletHolder(calcServlet), "/calc");
        handler.addServlet(new ServletHolder(history), "/history");
        handler.addServlet(new ServletHolder(logoutServlet), "/logout");

        server.setHandler(handler);
        server.start();
        server.join();

    }
}
