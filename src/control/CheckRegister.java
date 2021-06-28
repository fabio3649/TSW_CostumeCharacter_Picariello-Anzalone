package control;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.*;
import java.util.*;

@WebServlet("/CheckRegister")
public class CheckRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public CheckRegister() {
        super();
     
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
		//inizializzazioni
		UserModelDS userDao = new UserModelDS();
		AddressModelDS addressDao = new AddressModelDS();
		String username = request.getParameter("username");
		boolean exUsername = false;
		
		
		try {
			ArrayList<UserBean> users = (ArrayList<UserBean>) userDao.doRetrieveAll("username");
			for(UserBean bean : users) {
				if(bean.getUsername().equals(username)){
					exUsername=true;
				}
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
		
		
		//controlli
		if(exUsername) {
			request.getSession().setAttribute("exUsername", "true");
			response.sendRedirect("Register.jsp");
		}
		
		else if(!request.getParameter("password1").equals(request.getParameter("password2"))) {
			request.getSession().setAttribute("incorrectPasswords", "true");
			response.sendRedirect("Register.jsp");
		}
		
		//salvataggio nel database
		
		else {
			
			UserBean user = new UserBean();
			user.setUsername(request.getParameter("username"));
			user.setPassword(request.getParameter("password1"));
			user.setName(request.getParameter("name"));
			user.setSurname(request.getParameter("surname"));
		
			
			System.out.println(request.getParameter("birthdate"));
			
			
			

			String dateInString = request.getParameter("birthdate");
			System.out.println(dateInString);
			String [] list = dateInString.split("-");
			 String year = list[0];
			 String month = list[1];
			 String day = list[2];
			 Date dateOfBirth = new Date(Integer.parseInt(year)-1900, Integer.parseInt(month), Integer.parseInt(day));
			 java.sql.Date sqlDate = new java.sql.Date(dateOfBirth.getTime());

			System.out.println(sqlDate);
			user.setBirthDate(sqlDate);
			user.setTelephoneNumber(String.valueOf(request.getParameter("telephon")));
			user.setEmail(request.getParameter("email"));
			user.setBillingAddress(request.getParameter("address"));
			user.setBillingCAP(Integer.parseInt(request.getParameter("cap")));
			user.setBillingCity(request.getParameter("city"));
			user.setBillingProvince(request.getParameter("province"));
			
			try {
				userDao.doSave(user);
			}
			catch(Exception e) {
				System.out.println(e);
			}
			
			//salvataggio primo indirizzo nella rubrica con l'indirizzo di fatturazione
			AddressBean address = new AddressBean();
			address.setAddress(request.getParameter("address"));
			address.setCap(Integer.parseInt(request.getParameter("cap")));
			address.setCity(request.getParameter("city"));
			address.setProvince(request.getParameter("province"));
			address.setUser(request.getParameter("username"));
			try {
				address.setIdAddress(addressDao.nextId());
			} catch (SQLException e1) {
				System.out.println(e1);
			}
			
			try {
				addressDao.doSave(address);
			}
			catch(Exception e) {
				System.out.println(e);
			}
			//setta validation a true se l'utente è validato
			request.getSession().setAttribute("validation", "true");
			
			//setta parametro dell'utente corrente tramite username
			request.getSession().setAttribute("currentUser", username);
			
			//setta parametro dell'ruolo (role) con Admistrator || User
			request.getSession().setAttribute("role", "User");
			response.sendRedirect("index.jsp");
			
		}	
	}
}
