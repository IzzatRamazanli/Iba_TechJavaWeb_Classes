package lesson8;

import lesson3.DbHelper;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

import javax.servlet.DispatcherType;
import java.sql.Connection;
import java.util.EnumSet;

public class ServerApp {
    public static void main(String[] args) throws Exception {
        Server server = new Server(8080);
        DbHelper helper = new DbHelper();
        Connection connection = helper.connection();
        History historyService = new HistoryServiceInDatabase(connection);

        CalcServlet calcServlet = new CalcServlet(historyService);
        HistoryServlet history = new HistoryServlet(historyService);
        LogoutServlet logoutServlet = new LogoutServlet(historyService);
        LoginServlet loginServlet = new LoginServlet();

        ServletContextHandler handler = new ServletContextHandler();
        handler.addServlet(new ServletHolder(loginServlet), "/login");

        EnumSet<DispatcherType> dt = EnumSet.of(DispatcherType.REQUEST);

        handler.addFilter(CookieFilter.class, "/calc", dt);
        handler.addFilter(CookieFilter.class, "/history", dt);
        handler.addFilter(CookieFilter.class, "/logout", dt);

        handler.addServlet(new ServletHolder(calcServlet), "/calc");
        handler.addServlet(new ServletHolder(history), "/history");
        handler.addServlet(new ServletHolder(logoutServlet), "/logout");


        server.setHandler(handler);
        server.start();
        server.join();

    }
}
