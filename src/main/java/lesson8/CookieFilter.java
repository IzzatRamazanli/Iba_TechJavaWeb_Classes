package lesson8;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CookieFilter implements HttpFilter {


    private boolean isCookiePresent(HttpServletRequest request) {
        return SessionRelated.find(request).isPresent();
    }

    @Override
    public void doHttpFilter(HttpServletRequest request,
                             HttpServletResponse response,
                             FilterChain chain) throws IOException, ServletException {
        if (isCookiePresent(request)) chain.doFilter(request, response);
        else response.sendRedirect("/login");

    }
}
