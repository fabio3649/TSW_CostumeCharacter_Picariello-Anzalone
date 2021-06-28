package control;


import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.UserBean;
import model.UserModelDS;

/**
 * Servlet implementation class CheckUsername
 */
@WebServlet("/CheckUsername")
public class CheckUsername extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckUsername() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("username");
		String novalid="";
		try {
		UserModelDS dao = new UserModelDS();
		UserBean user = (UserBean) dao.doRetrieveByKey(username);
				if(user!=null && user.getUsername().equalsIgnoreCase(username)) {
					
				    response.getWriter().print("<p>username gi&agrave; presente</p>");
				    novalid = "true";
				    request.getSession().setAttribute("valid",novalid);
					return ;
				}else {
					novalid="false";
					//response.getWriter().print("<p>username valida</p>");
					
				}
				
					response.getWriter().print("<p></p>");
					return ;
				
		
			
	}catch (SQLException e) {
		e.printStackTrace();
	}
		
		

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
	}
	}


