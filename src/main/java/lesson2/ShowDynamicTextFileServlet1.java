package lesson2;

import freemarker.template.Configuration;
import freemarker.template.TemplateException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;

public class ShowDynamicTextFileServlet1 extends HttpServlet {
    /*http://localhost:8080/dynamic1*/

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        Configuration conf = new Configuration(Configuration.VERSION_2_3_31);
        conf.setDefaultEncoding(String.valueOf(StandardCharsets.UTF_8));
        conf.setClassForTemplateLoading(this.getClass(), "/templates/");

        HashMap<String, Object> data = new HashMap<>();
        data.put("name", "Izzat");
        data.put("age", 20);

        try (PrintWriter writer = resp.getWriter()) {
            conf.getTemplate("test2.ftl").process(data, writer);
        } catch (TemplateException e) {
            throw new RuntimeException(e);
        }
    }

}
