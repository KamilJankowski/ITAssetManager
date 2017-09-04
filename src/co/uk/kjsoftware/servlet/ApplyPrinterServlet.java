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

import co.uk.kjsoftware.beans.Pcs;
import co.uk.kjsoftware.beans.Printers;
import co.uk.kjsoftware.conn.MySQLConnUtils;
import co.uk.kjsoftware.utils.AddPC;
import co.uk.kjsoftware.utils.AddPrinter;
import co.uk.kjsoftware.utils.DBUtils;

/**
 * Servlet implementation class ApplyPrinterServlet
 */
@WebServlet(name = "applyprinter", urlPatterns = { "/applyprinter" })
public class ApplyPrinterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApplyPrinterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String errorString = null;
		List<Printers> list = null;
		try {
			Connection conn = MySQLConnUtils.getMySQLConnection();
			list = DBUtils.queryPrinters(conn);

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			errorString = e.getMessage();
		}

		// Store info in request attribute, before forward to views
		request.setAttribute("errorString", errorString);
		request.setAttribute("printersList", list);

		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/index");

		dispatcher.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		
		
		List<Printers> elist = null;

		Connection conn;
		try {
			conn = MySQLConnUtils.getMySQLConnection();
			elist = DBUtils.queryIdPrinter(conn);
			String buttonUpdatePrinters = request.getParameter("updatePrinter");
	

			for (Printers idprinter : elist) {
				if (idprinter.getId().equals(buttonUpdatePrinters)) {
					// String buttonAttr = (String)
					// request.getAttribute("updateMobile");
					AddPrinter addPrinter = new AddPrinter();
					addPrinter.AddPrinterRow(request, response);
					String idPrinter = idprinter.getId();

					String idPrinterRequest = request.getParameter("updatePrinter");
					// System.out.print(i);
					conn = MySQLConnUtils.getMySQLConnection();
				
					
					DBUtils.updatePrinter(conn, idPrinter);

					

				}

			}

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}

		
	}

}
