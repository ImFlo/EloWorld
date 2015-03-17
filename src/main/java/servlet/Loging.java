package servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.Path;
import javax.ws.rs.client.ClientBuilder;
import bdd.joueur.*;

@Path("/loging")
public class Loging extends HttpServlet {

    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException {
			/*trouver comment utiliser le dao*/
			response.sendRedirect("index.jsp");
    }

    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException {

    }

}
