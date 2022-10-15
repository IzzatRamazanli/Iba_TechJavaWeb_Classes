package lesson2;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;

public class ServerApp {
    public static void main(String[] args) throws Exception {
        Server server = new Server(8080);

        ServletContextHandler handler = new ServletContextHandler();
        handler.addServlet(ShowTextFileServlet.class, "/showtextfile");

        server.setHandler(handler);
        server.start();
        server.join();

    }
}
