package lesson2;

import freemarker.template.Configuration;
import freemarker.template.TemplateException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;

public class ShowDynamicTextFileServlet2 extends HttpServlet {
    /*http://localhost:8080/dynamic2*/

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        Configuration conf = new Configuration(Configuration.VERSION_2_3_31);
        conf.setDefaultEncoding(String.valueOf(StandardCharsets.UTF_8));
        conf.setClassForTemplateLoading(this.getClass(), "/templates/");
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("Jim", 20, "BE3"));
        students.add(new Student("Alex", 23, "BE4"));
        students.add(new Student("Izzat", 20, "BE5"));

        HashMap<String, Object> data = new HashMap<>();
        data.put("data", students);

        try (PrintWriter writer = resp.getWriter()) {
            conf.getTemplate("test3.ftl").process(data, writer);
        } catch (TemplateException e) {
            throw new RuntimeException(e);
        }
    }

}
