package lesson2;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;

public class ServerApp {
    public static void main(String[] args) throws Exception {
        Server server = new Server(8080);

        ServletContextHandler handler = new ServletContextHandler();
        handler.addServlet(ShowTextFileServlet.class, "/showtextfile");
        handler.addServlet(RagnarFileServlet.class, "/ragnar.jpg");
        handler.addServlet(LandScapeServlet.class, "/landscape.jpg");

        server.setHandler(handler);
        server.start();
        server.join();

    }
}
