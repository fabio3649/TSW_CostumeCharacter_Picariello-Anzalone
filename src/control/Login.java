package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.*;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		if(CheckLogin.ceckAdministartor(username, password)) {
			request.getSession().setAttribute("role", "Administrator");
			response.sendRedirect("");
		}
		else if(CheckLogin.ceckLogin(username,password)) {
			
			//setta validation a true se l'utente è validato
			request.getSession().setAttribute("validation", "true");
			
			//setta parametro dell'utente corrente tramite username
			request.getSession().setAttribute("currentUser", username);
			
			//setta parametro dell'ruolo (role) con Admistrator || User
			request.getSession().setAttribute("role", "User");
			response.sendRedirect("Catalog.jsp");
		}
		else {
			request.getSession().setAttribute("validation", "false");
			response.sendRedirect("Login.jsp");
		}
	}
}
