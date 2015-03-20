package servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.Path;
import javax.ws.rs.client.ClientBuilder;
import bdd.joueur.*;
import java.lang.Exception;
import java.io.IOException;

@Path("/loging")
public class Loging extends HttpServlet {

    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
			/*trouver comment utiliser le dao*/
			try{
				//response.sendRedirect("index.jsp");
				Joueur str =  ClientBuilder.newClient()//
        	.target("localhost:8080/v1/joueurdb/" + request.getParameter("login") + "&" + request.getParameter("password"))
        	.request()
        	.get(Joueur.class);

					if(str.getPseudo() == request.getParameter("login") && str.getMdp() == request.getParameter("password")){
						
						HttpSession session = request.getSession();
						session.setAttribute("login",request.getParameter("login"));
						response.sendRedirect("homepage.jsp");
					}
			}catch(Exception e){
				/*not logging*/
				response.getOutputStream().print("catched !");
				response.sendRedirect("index.jsp?fail=true");
			}
    }

    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException {

    }

}
