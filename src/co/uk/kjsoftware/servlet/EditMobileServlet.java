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
@WebServlet("/editmobile")
public class EditMobileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static String eidUPMobiles;
	 private List<Mobiles> list;

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

	

		request.setAttribute("mobilesList1", list);

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
		/*String buttonUpdateMobiles = request.getParameter("updateMobile");
		

		
		// read button delete value and delete row from table mobile

		List<Mobiles> elist = null;
		

		Connection conn;
		try {
			conn = MySQLConnUtils.getMySQLConnection();
			elist = DBUtils.queryIdMobile(conn);
			
			
			
		
				for (Mobiles idmob : elist) {
					if (idmob.getId().equals(buttonUpdateMobiles)) {
						// String buttonAttr = (String)
						// request.getAttribute("updateMobile");
						//AddMobile addMobile = new AddMobile();
					//	addMobile.AddMobileRow(request, response);

						//String idMobileRequest = model.getId();
						// System.out.print(i);
						// conn = MySQLConnUtils.getMySQLConnection();
						//DBUtils.updateMobile(conn, idMobileRequest);

						// }

						// RequestDispatcher dispatcher =
						// request.getServletContext().getRequestDispatcher("/index");

						// dispatcher.forward(request, response);

					}

				}
			
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
*/
	}
}
