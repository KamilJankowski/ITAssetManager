package co.uk.kjsoftware.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.fabric.Response;

import co.uk.kjsoftware.beans.MobileId;
import co.uk.kjsoftware.beans.Mobiles;

import co.uk.kjsoftware.conn.MySQLConnUtils;
import co.uk.kjsoftware.utils.DBUtils;
import co.uk.kjsoftware.utils.DownloadFile;
import co.uk.kjsoftware.utils.FileChooser;

/**
 * Servlet implementation class MobilesServlet
 */
@WebServlet("/mobiles")
public class MobilesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private FileChooser filechooser;
	private File mobileCSV;
	public static String idMobiles;
	public static String editidMobiles;
	public static List<Mobiles> mqueryEditIdMobiles;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MobilesServlet() {
		super();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

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

		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/mobilesView.jsp");

		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		// import CSV file
		String button = request.getParameter("importCSV");
		if ("importCSV".equals(button)) {
			FileChooser filechooser = new FileChooser();

			File chooseCSV = filechooser.chooseCSV();
			System.out.println("Passed file: " + chooseCSV);

			// choose what to import
			filechooser.importCSVMobiles(chooseCSV);
			try {
				Connection conn = MySQLConnUtils.getMySQLConnection();
				DBUtils.insertMobiles(conn);

				doGet(request, response);

			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		// export table mobiles to CSV file
		String buttonEC = request.getParameter("exportCSV");

		if ("exportCSV".equals(buttonEC)) {

			DownloadFile downloadfile = new DownloadFile();

		}

		// add mobile to mobiles
		String buttonAddMobile = request.getParameter("exportCSV");

		if ("exportCSV".equals(buttonEC)) {

			DownloadFile downloadfile = new DownloadFile();

		}

		// read button delete value and delete row from table mobile

		List<Mobiles> mlist = null;
		try {
			Connection conn = MySQLConnUtils.getMySQLConnection();
			mlist = DBUtils.queryIdMobile(conn);
			String buttonDelMobiles = request.getParameter("delMobileBtn");

			for (Mobiles idmob : mlist) {
				if (idmob.getId().equals(buttonDelMobiles)) {

					
					String idMobiles1 = idmob.getId();

					DBUtils.removeIdMobile(conn, idMobiles1);

					doGet(request, response);
				}

			}

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}

		// read button edit value and edit row from table mobile

		List<Mobiles> elist = null;

		try {
			Connection conn = MySQLConnUtils.getMySQLConnection();
			elist = DBUtils.queryIdMobile(conn);
			String buttonEditMobiles = request.getParameter("editMobileBtn");
			for (Mobiles idmob : elist) {
				if (idmob.getId().equals(buttonEditMobiles)) {
					
					String idMobiles2 = idmob.getId();
					//DBUtils.getIdMobile(conn, idMobiles2);
					List<Mobiles> queryEditIdMobiles= DBUtils.editIdMobile(conn, idMobiles2);
								
					//String idUPMobiles = idMobiles2;
					request.setAttribute("buttonEditMobiles", buttonEditMobiles);
					request.setAttribute("queryEditIdMobiles", queryEditIdMobiles);
					//doGet(request, response);
					//String idUPMobiles = (String) request.getAttribute("buttonEditMobiles");
					//System.out.println("This is string " + idUPMobiles);
					
					RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/editmobile");

					dispatcher.forward(request, response);

				}

			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}


	}
}
