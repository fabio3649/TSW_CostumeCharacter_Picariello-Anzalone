package control;

import model.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EditProduct
 */
@WebServlet("/EditProduct")
public class EditProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditProduct() {
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
		

		
		ProductModelDS dao = new ProductModelDS();
		ProductBean bean = new ProductBean();
		
		int id = Integer.parseInt((String)request.getSession().getAttribute("id"));
		request.getSession().removeAttribute("id");
		
		
		try {
			dao.updateAge(id, request.getParameter("age"));
			dao.updateCategory(id, request.getParameter("category"));
			dao.updateCopies(id, Integer.parseInt(request.getParameter("copies")));
			dao.updateDescription(id, request.getParameter("description"));
			dao.updateIva(id, Integer.parseInt(request.getParameter("iva")));
			dao.updatePrice(id, Double.parseDouble(request.getParameter("price")));
			dao.updateSize(id, request.getParameter("size"));
			dao.updateType(id, request.getParameter("type"));
			dao.updateWeight(id, Double.parseDouble(request.getParameter("weight")));
			dao.updateName(id, request.getParameter("name"));
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
	}

}
