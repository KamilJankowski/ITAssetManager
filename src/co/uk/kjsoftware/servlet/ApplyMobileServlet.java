package co.uk.kjsoftware.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

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

/**
 * Servlet implementation class ApplyMobileServlet
 */
@WebServlet("/ApplyMobileServlet")
public class ApplyMobileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ApplyMobileServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at:
		// ").append(request.getContextPath());

		String errorString = null;
		List<Mobiles> list = null;
		try {
			Connection conn = MySQLConnUtils.getMySQLConnection();
			list = DBUtils.queryMobiles(conn);

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			errorString = e.getMessage();
		}

		// Store info in request attribute, before forward to views
		request.setAttribute("errorString", errorString);
		request.setAttribute("mobilesList", list);

		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/index");

		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);

		List<Mobiles> elist = null;

		Connection conn;
		try {
			conn = MySQLConnUtils.getMySQLConnection();
			elist = DBUtils.queryIdMobile(conn);
			String buttonUpdateMobiles = request.getParameter("updateMobile");
	

			for (Mobiles idmob : elist) {
				if (idmob.getId().equals(buttonUpdateMobiles)) {
					// String buttonAttr = (String)
					// request.getAttribute("updateMobile");
					AddMobile addMobile = new AddMobile();
					addMobile.AddMobileRow(request, response);
					

					String idMobileRequest = request.getParameter("updateMobile");
					// System.out.print(i);
					conn = MySQLConnUtils.getMySQLConnection();
					List<Mobiles> idSIM =  DBUtils.editIdSIM(conn, idMobileRequest);
					for (Mobiles id : idSIM) {
						String idsim = id.getId_sim();
					
					DBUtils.updateMobile(conn, idMobileRequest, idsim);

					 }

				}

			}

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}

	
	}

}
