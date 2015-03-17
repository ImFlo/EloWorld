package servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.Path;
import bdd.joueur.*;

@Path("/loging")
public class Loging extends HttpServlet {

    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException {
			/*trouver comment utiliser le dao*/
			/*Joueur j = ClientBuilder().newClient()
																.target()
																.request()
																.get(Joueur.class);

			if(j != null){
				HttpSession session = request.getSession();
				session.setAttribute("login",request.getParameter("login"));
			}
			response.sendRedirect("index.jsp");*/
    }

    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException {

    }

}
