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

import com.mysql.fabric.Response;

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

			RequestDispatcher dispatcher = this.getServletContext()
					.getRequestDispatcher("/WEB-INF/views/mobilesView.jsp");

			dispatcher.forward(request, response);
		}

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		String button = request.getParameter("importCSV");
		String errorString = null;
		List<Mobiles> list = null;
		if ("importCSV".equals(button)) {
			FileChooser filechooser = new FileChooser();

			File chooseCSV = filechooser.chooseCSV();
			System.out.println("Passed file: " + chooseCSV);

			// choose what to import
			filechooser.importCSVMobiles(chooseCSV);
			try {
				Connection conn = MySQLConnUtils.getMySQLConnection();
				DBUtils.insertMobiles(conn);

				// Store info in request attribute, before forward to views
				//request.setAttribute("errorString", errorString);
				//request.setAttribute("mobilesList", list);

				doGet(request, response);
				
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		

		String buttonEC = request.getParameter("exportCSV");

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

					System.out.println("removed id!");
					System.out.println(idmob.getId());
					String idMobiles1 = idmob.getId();

					DBUtils.removeIdMobile(conn, idMobiles1);
					// response.setHeader("Refresh", "
					// URL=http://localhost:8080/ITAssetManager/mobiles");
					// Set response content type
					// response.setHeader("Refresh", "0;
					// URL=http://localhost:8080/ITAssetManager/mobiles");
					// response.setIntHeader("Refresh", 1);
					// response.setHeader("Refresh", "0;
					// URL=http://localhost:8080/ITAssetManager/mobiles");
					
					doGet(request, response);
				}

			}

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			errorString = e.getMessage();
		}

	}

}
