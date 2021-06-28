package control;
import model.*;
import java.io.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

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
		
		
		int id = (int) request.getSession().getAttribute("product");
		request.getSession().removeAttribute("product");
		ProductModelDS ds = new ProductModelDS();
		String name="";
		try {
			name = ds.doRetrieveByKey(id).getName();
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		String size = request.getParameter("size");
		ArrayList<ProductBean> products = new ArrayList<ProductBean>();
		try {
			 products = ds.doRetrieveAll("name");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		int idProduct = -1;
		for(int i=0;i<products.size();i++) {
			ProductBean product = products.get(i);
			if(product.getName().equalsIgnoreCase(name)&&(product.getSize().equals(size))) {
				idProduct = product.getId();
			}
		}
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
				response.sendRedirect("Costumi.jsp");
			} else {
				response.sendRedirect("Costumi.jsp?notAvailable=true");
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
