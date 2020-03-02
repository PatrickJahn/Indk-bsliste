import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet(name = "AdminServlet", urlPatterns = "/AdminServlet")
public class AdminServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String navn = request.getParameter("navn");
        ServletContext servletContext = getServletContext();
        Map<String, String> brugerMap = ( Map<String, String>) servletContext.getAttribute("brugerMap");
        if (brugerMap.containsKey(navn)) {

            brugerMap.remove(navn);
            request.setAttribute("besked", "Brugeren "+ navn + " er nu slettet");
            request.getRequestDispatcher("WEB-INF/Admin.jsp").forward(request,response);
        } else {
            request.setAttribute("besked", "Bruger findes ikke");
            request.getRequestDispatcher("WEB-INF/Admin.jsp").forward(request,response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
