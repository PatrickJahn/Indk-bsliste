import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

@WebServlet(name = "ItemsServlet", urlPatterns = "/ItemsServlet")
public class ItemsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();

        String vareNavn = request.getParameter("vareNavn");
        Set<String> basket = (Set<String>) session.getAttribute("basket");

        if (basket == null ) {
            basket = new HashSet<>();
            session.setAttribute("basket",basket);
        }

        basket.add(vareNavn);
        request.getRequestDispatcher("WEB-INF/Huskeliste.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
