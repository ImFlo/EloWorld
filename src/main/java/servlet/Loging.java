import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import bdd.joueur.*;

public class Loging extends HttpServlet {

    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException {
			Joueur j = new JoueurDao().findJoueur(request.getParameter("login"), request.getParameter("passwd"));

			if(j != null){
				HttpSession session = request.getSession();
				session.setAttribute("login",request.getParameter("login"));
			}
			response.sendRedirect("index.jsp");
    }

    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException {

    }

}
