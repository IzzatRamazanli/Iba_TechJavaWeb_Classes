package lesson2;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class ServerApp {
    public static void main(String[] args) throws Exception {
        Server server = new Server(8080);

        ServletContextHandler handler = new ServletContextHandler();
        handler.addServlet(new ServletHolder(ShowTextFileServlet.class), "/showtextfile");
        handler.addServlet(new ServletHolder(ShowDynamicTextFileServlet1.class), "/dynamic1");
        handler.addServlet(new ServletHolder(ShowDynamicTextFileServlet2.class), "/dynamic2");
        handler.addServlet(new ServletHolder(StaticFileServlet.class), "/*");
//        handler.addServlet(RagnarFileServlet.class, "/ragnar.jpg");
//        handler.addServlet(LandScapeServlet.class, "/landscape.jpg");

        server.setHandler(handler);
        server.start();
        server.join();

    }
}
