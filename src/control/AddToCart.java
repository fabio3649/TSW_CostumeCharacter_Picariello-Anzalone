package control;
import model.*;
import java.io.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AddToCart")
public class AddToCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public AddToCart() {
        super();
    }
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int idProduct = (Integer.parseInt(request.getParameter("idProduct")));
		ProductModelDS ds = new ProductModelDS();
		
		try{
			if(ds.doRetrieveByKey(idProduct).getNumCopies()>0) {
				if(request.getSession().getAttribute("cart")==null) {
					Cart cart = new Cart();
					cart.addProduct(ds.doRetrieveByKey(idProduct));
					request.getSession().setAttribute("cart", cart);
				} else {
					Cart cart = (Cart)request.getSession().getAttribute("cart");
					cart.addProduct(ds.doRetrieveByKey(idProduct));
					request.getSession().setAttribute("cart", cart);
				}
				response.sendRedirect("Catalog.jsp");
			} else {
				response.sendRedirect("Catalog.jsp?notAvailable=true");
			}
		}
		catch(Exception e){	
			System.out.println(e);
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);	
	}
}
