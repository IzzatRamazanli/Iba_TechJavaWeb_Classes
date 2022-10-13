package lesson1;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class CustomerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try (PrintWriter writer = resp.getWriter()) {
            for (Customer customer : collectCustomers()) {
                writer.println(customer);
            }
        }
    }

    private Customer getCustomer() {
        return new Customer(1, "izzat", "ramazanli");
    }

    private Customer getCustomer2() {
        return new Customer(2, "hummat", "ramazanli");
    }

    private List<Customer> collectCustomers() {
        return new ArrayList<>(List.of(getCustomer(), getCustomer2()));
    }
}
