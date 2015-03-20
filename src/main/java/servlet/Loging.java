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
			System.out.println("patate radioactive ! " +  request.getParameter("password") + " et " +request.getParameter("login"));
			try{
				//response.sendRedirect("index.jsp");
				Joueur str =  ClientBuilder.newClient()//
        	.target("http://localhost:8080/v1/joueurdb/" + request.getParameter("login") + "&" + request.getParameter("password"))
        	.request()
        	.get(Joueur.class);
					System.out.println("patate asexué ! " + request.getParameter("password") + ":"+str.getMdp() + ":" + ( request.getParameter("password").equals(str.getMdp())));
					if(str.getPseudo().equals(request.getParameter("login")) && str.getMdp().equals(request.getParameter("password"))){
						
						HttpSession session = request.getSession();
						session.setAttribute("login",request.getParameter("login"));
						response.sendRedirect("homepage.jsp");
					}
			}catch(Exception e){
				System.out.println(e.toString());
				/*not logging*/
				response.getOutputStream().print("catched !");
				response.sendRedirect("index.jsp?fail=true");
			}
    }

    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException {

    }

}
