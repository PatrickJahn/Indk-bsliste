import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "LoginServlet", urlPatterns = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ServletContext servletContext = getServletContext();


        if (servletContext.getAttribute("brugerMap") == null) {
            Map<String, String> brugerMap = new HashMap<>();
            brugerMap.put("test","test");
            servletContext.setAttribute("brugerMap", brugerMap);
        }


        checkCredentials(servletContext, request, response);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }


    private void checkCredentials(ServletContext servletContext, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String navn = request.getParameter("navn");
        String pass = request.getParameter("password");


        if (((Map<String, String>) servletContext.getAttribute("brugerMap")).containsKey(navn)) {

            // TODO: Gå til loginside



        } else {
            request.setAttribute("besked", "Bruger findes ikke");
            request.getRequestDispatcher("index.jsp").forward(request,response);
        }

        if (((Map<String, String>) servletContext.getAttribute("brugerMap")).get(navn).equalsIgnoreCase(pass)) {

            request.getRequestDispatcher("WEB-INF/Huskeliste.jsp").forward(request,response);
            // TODO: Gå til huskelisten

        } else {
            request.setAttribute("besked", "Forkert kode");
            request.getRequestDispatcher("index.jsp").forward(request,response);

        }
    }
}
