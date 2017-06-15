package co.uk.kjsoftware.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.uk.kjsoftware.beans.MobileId;
import co.uk.kjsoftware.beans.Mobiles;
import co.uk.kjsoftware.conn.MySQLConnUtils;
import co.uk.kjsoftware.utils.AddMobile;
import co.uk.kjsoftware.utils.DBUtils;
import co.uk.kjsoftware.servlet.MobilesServlet;

/**
 * Servlet implementation class EditMobileServlet
 */
@WebServlet(urlPatterns = { "/editmobile" })
public class EditMobileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
public static String eidUPMobiles;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditMobileServlet() {
		super();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<Mobiles> list = (List<Mobiles>) request.getAttribute("queryEditIdMobiles");
		


		// Store info in request attribute, before forward to views
		// request.setAttribute("errorString", errorString);
		// request.setAttribute("mobilesList", list);

		// request.setAttribute("errorString", errorString);

		request.setAttribute("mobilesList", list);

		RequestDispatcher dispatcher = this.getServletContext()
				.getRequestDispatcher("/WEB-INF/views/editMobileView.jsp");

		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

		// read button delete value and delete row from table mobile

		
		

		String buttonUpdateMobiles = request.getParameter("updateMobile");
		// for (Mobiles idmob : mlist) {
		if ("update_Mobile".equals(buttonUpdateMobiles)) {
			
			  AddMobile addMobile = new AddMobile();
			  addMobile.AddMobileRow(request, response);
						
			Connection conn = null;
			try {
				
				conn = MySQLConnUtils.getMySQLConnection();
				DBUtils.updateMobile(conn);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			System.out.println("OK");
			

			// }

			// RequestDispatcher dispatcher =
			// request.getServletContext().getRequestDispatcher("/mobiles");

			// dispatcher.forward(request, response);

		}
	}

}
