package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.client.ClientBuilder;

import org.skife.jdbi.v2.DBI;

import bdd.App;
import bdd.Base;
import bdd.joueur.Joueur;
import bdd.joueur.JoueurDao;

public class Initialize extends HttpServlet{

	public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
	
	}

	public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
		Base base = new Base();
		base.drop();
		base.create();
		response.sendRedirect("index.jsp");
	}
}
