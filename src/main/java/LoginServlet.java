import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@WebServlet(name = "LoginServlet", urlPatterns = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ServletContext servletContext = getServletContext();


        if (servletContext.getAttribute("brugerMap") == null) {
            Map<String, String> brugerMap = new HashMap<>();
            brugerMap.put("Admin","1234");
            servletContext.setAttribute("brugerMap", brugerMap);
        }

        if (servletContext.getAttribute("aktiveBrugere") == null) {
            Set<String> aktiveBrugere = new HashSet<>();
            servletContext.setAttribute("aktiveBrugere", aktiveBrugere);
        }

        checkCredentials(servletContext, request, response);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }


    private void checkCredentials(ServletContext servletContext, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        String navn = request.getParameter("navn");
        String pass = request.getParameter("password");
        Map<String, String> brugerMap = (Map<String, String>) servletContext.getAttribute("brugerMap");
        Set<String> aktiveBrugere = (Set<String>)servletContext.getAttribute("aktiveBrugere");

        if (session.getAttribute("brugerNavn") != null){
            request.getRequestDispatcher("WEB-INF/Huskeliste.jsp").forward(request,response);
        }


        if (!brugerMap.containsKey(navn)) {
            request.setAttribute("besked", "Bruger findes ikke");
            request.getRequestDispatcher("index.jsp").forward(request,response);
        }

        if (brugerMap.get(navn).equalsIgnoreCase(pass)) {

            if (navn.equalsIgnoreCase("Admin")) {
                request.getRequestDispatcher("WEB-INF/Admin.jsp").forward(request,response);
            }

                if (!aktiveBrugere.contains(navn) ) {
                ((Set<String>) servletContext.getAttribute("aktiveBrugere")).add(navn);
                session.setAttribute("brugerNavn", navn);
                request.getRequestDispatcher("WEB-INF/Huskeliste.jsp").forward(request,response);
                 } else {
                    request.setAttribute("besked", "Brugeren er allerede logget ind..");
                    request.getRequestDispatcher("index.jsp").forward(request,response);
                }


        } else {
            request.setAttribute("besked", "Forkert kode");
            request.getRequestDispatcher("index.jsp").forward(request,response);

        }
    }
}
