package control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.*;

/**
 * Servlet implementation class MakeOrder
 */
@WebServlet("/MakeOrder")
public class MakeOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MakeOrder() {
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
		
		
		
		int id = 0;
		OrderModelDS daoOrder = new OrderModelDS();
		OrderBean order = new OrderBean();
		String username = (String ) request.getSession().getAttribute("currentUser");
		UserModelDS dao = new UserModelDS();   
		
			try {
				UserBean user = (UserBean) dao.doRetrieveByKey(username);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
		AddressModelDS daoAd = new AddressModelDS();
		AddressBean address = new AddressBean();
		String payment = request.getParameter("payment");
		
		
		
		// Creazione indirizzi
		if(request.getParameter("address").equals("billing")) {
					
						try {
							address = daoAd.doRetrieveMinByUser(username);  // prendo l' id indirizzo più piccolo che quindi
							 											// corrisponde all'indirizzo di fatturazione
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							System.out.println(e);
						}
				order.setAddress(address.getIdAddress());	
			
		}
		else if(request.getParameter("address").equals("newAddress")){
			
			
			try {
				address.setIdAddress(daoAd.nextId());
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				System.out.println(e1);
			}
			address.setAddress(request.getParameter("via"));
			address.setCity(request.getParameter("city"));
			address.setProvince(request.getParameter("province"));
			address.setCap(Integer.parseInt(request.getParameter("cap")));
			address.setUser(username);
			address.setVisible(false);
			try {
				daoAd.doSave(address);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println(e);
			}
			
			order.setAddress(address.getIdAddress());
		}
		
		
		else  {
			
			try {
				address = daoAd.doRetrieveByKey(Integer.parseInt(request.getParameter("address")));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println(e);
			}
						
			order.setAddress(address.getIdAddress());
		}
		
		Cart cart = (Cart) request.getSession().getAttribute("cart");
		ArrayList<ProductBean> products = (ArrayList<ProductBean>) cart.getProducts();
		Double total=0.0;
		
		for(int i=0; i< products.size(); i++) {
			
			total = total +  (products.get(i).getPrice()  * products.get(i).getQuantity());
		}
		
		// Creo Ordine
		
		
		try {
			id = daoOrder.nextId();
			order.setIdOrder(id);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
		order.setPaymentMethod(payment);
		java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime()); 
		order.setDate(date);
		order.setStatus("complete");
		order.setTotalPrice(total);
		order.setShippingCosts(10.00);
		order.setUser(username);
		
		try {
			daoOrder.doSave(order);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			System.out.println(e1);
		}
		
		
		
		//Creo i riferimenti ordini per i prodotti
		
		RefOrderModelDS daoRef = new RefOrderModelDS();
		
		for(int i=0;i < products.size() ;i++) {
			
			RefOrderBean refOrder = new RefOrderBean();
			refOrder.setOrder(id);
			refOrder.setProduct(products.get(i).getId());
			refOrder.setQuantity(products.get(i).getQuantity());
			refOrder.setSellingPrice(products.get(i).getPrice());
			refOrder.setIva(products.get(i).getIva());
            try {
				daoRef.doSave(refOrder);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println(e);
			}			
			
		}
		
		
			
		
		request.getSession().removeAttribute("cart");
		
	}

}
