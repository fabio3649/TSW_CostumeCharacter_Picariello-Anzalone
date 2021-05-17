package control;
import model.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpdateQuantity
 */
@WebServlet("/UpdateQuantity")
public class UpdateQuantity extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public UpdateQuantity() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if(request.getParameter("method").equals("plus")) {
			Cart cart = (Cart)request.getSession().getAttribute("cart");
			ProductBean bean = cart.getProduct(Integer.parseInt(request.getParameter("id")));
			//bean.setQuantity(bean.getQuantity()+1);
			cart.addProduct(bean);
			response.sendRedirect("CartView.jsp");
		}
		if(request.getParameter("method").equals("less")) {
			Cart cart = (Cart)request.getSession().getAttribute("cart");
			ProductBean bean = cart.getProduct(Integer.parseInt(request.getParameter("id")));
			cart.deleteProduct(bean);
			response.sendRedirect("CartView.jsp");
		}
		
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
