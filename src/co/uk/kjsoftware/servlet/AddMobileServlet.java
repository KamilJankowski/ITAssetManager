package co.uk.kjsoftware.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.uk.kjsoftware.beans.Mobiles;
import co.uk.kjsoftware.conn.MySQLConnUtils;
import co.uk.kjsoftware.utils.AddMobile;
import co.uk.kjsoftware.utils.DBUtils;
 
@WebServlet(urlPatterns = { "/addmobile"})
public class AddMobileServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;
 
   public static String addreadmake;
   public static String readmodel;
   public static String readimei;
   public static String readserial_number;
   public static String readprovider;
   public static String sim_serial_number;
   public static String readmobile_number;
   public static String readfirst_name;
   public static String readlast_name;
   public static String readdepartment;
   
   public AddMobileServlet() {
       super();
   }
 
   @Override
   protected void doGet(HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException {
 
        
       // Forward to /WEB-INF/views/addMobileView.jsp
       // (Users can not access directly into JSP pages placed in WEB-INF)
       RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/addMobileView.jsp");
        
       dispatcher.forward(request, response);
        
   }
 
   @Override
   protected void doPost(HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException {
       doGet(request, response);
       
       String button = request.getParameter("addMobile");
		if ("add_mobile".equals(button)) {
			
			AddMobile addMobile = new AddMobile();
			addMobile.AddMobileRow(request, response);
			
			Connection conn;
			try {
				conn = MySQLConnUtils.getMySQLConnection();
				DBUtils.addMobiles(conn);
				
				//doGet(request, response);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
			
		}
   }
 
}