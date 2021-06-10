package control;

import model.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.*;

/**
 * Servlet implementation class MakeCatalog
 */
@WebServlet("/MakeCatalog")
public class MakeCatalog extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MakeCatalog() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		   ArrayList<ProductBean> bean = new ArrayList<ProductBean>();
		   ProductModelDS dao = new ProductModelDS(); 
		   ImageModelDS daoImg = new ImageModelDS();
		   try {
			 bean = dao.doRetrieveAllByType("Costume");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   try {
			ArrayList<ProductBean> bean2 = dao.doRetrieveAllByType("Maschera");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   ImageBean urlImage = new ImageBean();
		   
		   
		   
		   StringBuffer output = new StringBuffer();
		   
		   int type = Integer.parseInt(request.getParameter("type"));
		   if(type!=0 && type == 1)
		   {
			   for( int i=0;i<bean.size();i++)
				{
					ProductBean costume = bean.get(i);
					String s = "ProductPage.jsp" + "?idProduct="+costume.getId();
					try {
						urlImage = daoImg.doRetrieveMain(costume.getId());
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}	
					
					output.append(" <a href=<%=s%>> <%=costume.getName() %> <%= costume.getSize() %>" + 
							      " <img src= \"<%=urlImage.getUrl()%>\"  alt=\"imgProduct\" >    </a>  ");
					
					//////////////////////////////  JSON 
					
				    /////////////////////////////////////////////////////
					response.getWriter().write(output.toString());
			   
		        }
		   
		
	        }
		   
		   
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
