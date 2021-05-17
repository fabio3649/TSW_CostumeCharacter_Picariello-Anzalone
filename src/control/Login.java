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
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		try{
			UserModelDS daoUser = new UserModelDS();
			UserBean user = (UserBean) daoUser.doRetrieveByKey(username);
			if(user != null){		
	           if(user.getPassword().equals(password)) {
	        	   request.getSession(true).setAttribute("user", user);
	        	   response.sendRedirect("Test.jsp");
	           }
	           else {
	        	   response.sendRedirect("UserLogin.jsp");
	           }
			}
		}catch(Exception e){
			 System.out.println(e);
	
		}
	   
		
	
	}
	
}
