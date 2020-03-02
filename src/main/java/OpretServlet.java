import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "OpretServlet", urlPatterns = "/OpretServlet")
public class OpretServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext servletContext = getServletContext();

        if (servletContext.getAttribute("brugerMap") == null) {
            Map<String, String> brugerMap = new HashMap<>();
            servletContext.setAttribute("brugerMap", brugerMap);
        }

        checkCredentials(servletContext, request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }


    private void checkCredentials(ServletContext servletContext, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String navn = request.getParameter("navn");
        String pass = request.getParameter("password");
       Map<String, String> brugerMap = (Map<String, String>) servletContext.getAttribute("brugerMap");

        if (!brugerMap.containsKey(navn)) {
          brugerMap.put(navn, pass);
            request.getRequestDispatcher("WEB-INF/Huskeliste.jsp").forward(request,response);
        } else {
            request.setAttribute("besked", "Bruger findes allerede..");
            request.getRequestDispatcher("OpretBruger.jsp").forward(request,response);

        }


    }
}
