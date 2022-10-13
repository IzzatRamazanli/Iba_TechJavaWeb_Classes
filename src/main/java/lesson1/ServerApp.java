package lesson1;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class ServerApp {
    public static void main(String[] args) throws Exception {
        Server server = new Server(8080);

        Counter c = new Counter();
        CountServlet countServlet = new CountServlet(c);
        GetCounterServlet getCounterServlet = new GetCounterServlet(c);


        ServletContextHandler handler = new ServletContextHandler();
        handler.addServlet(HelloServlet.class, "/hello"); //"?x=7&y=5"
        handler.addServlet(ByeServlet.class, "/bye");
        handler.addServlet(CustomerServlet.class, "/customers");

        handler.addServlet(new ServletHolder(countServlet), "/count");
        handler.addServlet(new ServletHolder(getCounterServlet), "/getCount");

        server.setHandler(handler);
        server.start();
        server.join();

    }
}
