package control;

import model.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Insert
 */
@WebServlet("/InsertProduct")
public class InsertProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertProduct() {
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
		
		try {
			bean.setId(dao.nextId());
			System.out.println(bean.getId());
			bean.setName(request.getParameter("name"));
			bean.setType(request.getParameter("type"));
			bean.setDescription(request.getParameter("description"));
			bean.setAge(request.getParameter("age"));
			bean.setSize(request.getParameter("size"));
			bean.setNumCopies(Integer.parseInt(request.getParameter("copies")));
			bean.setIva(Integer.parseInt(request.getParameter("iva")));
			bean.setPrice(Double.parseDouble(request.getParameter("price")));
			bean.setWeight(Double.parseDouble(request.getParameter("weight")));
			bean.setCategory(request.getParameter("categoty"));
			System.out.println(bean);
			dao.doSave(bean);
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
		
}

