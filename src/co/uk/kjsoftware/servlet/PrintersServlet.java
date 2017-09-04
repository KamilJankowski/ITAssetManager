package co.uk.kjsoftware.servlet;

import java.io.File;
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
import co.uk.kjsoftware.utils.DBUtils;
import co.uk.kjsoftware.utils.DownloadFile;
import co.uk.kjsoftware.utils.FileChooser;

/**
 * Servlet implementation class MobilesServlet
 */
@WebServlet("/printers")
public class PrintersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PrintersServlet() {
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
		
		
		
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/printersView.jsp");

		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		// import CSV file
				String button = request.getParameter("importCSV");
				if ("importCSV".equals(button)) {
					FileChooser filechooser = new FileChooser();

					File chooseCSV = filechooser.chooseCSV();
					System.out.println("Passed file: " + chooseCSV);

					// choose what to import
					filechooser.importCSVPrinters(chooseCSV);
					try {
						Connection conn = MySQLConnUtils.getMySQLConnection();
						DBUtils.insertPrinters(conn);

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
			downloadfile.DownloadFilePrinters();
		}
		
		
		
		// read button delete value and delete row from table printers

		List<Printers> printerlist = null;
		try {
			Connection conn = MySQLConnUtils.getMySQLConnection();
			printerlist = DBUtils.queryIdPrinter(conn);
			String buttonDelPrinters = request.getParameter("delPrinterBtn");

			for (Printers idprinter : printerlist) {
				if (idprinter.getId().equals(buttonDelPrinters)) {

					
					String idPrinters1 = idprinter.getId();

					DBUtils.removeIdPrinter(conn, idPrinters1);

					doGet(request, response);
				}

			}

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		
		
		
		

		List<Printers> elist = null;

		try {
			Connection conn = MySQLConnUtils.getMySQLConnection();
			elist = DBUtils.queryIdPrinter(conn);
			String buttonEditPrinters = request.getParameter("editPrinterBtn");
			for (Printers idprinter : elist) {
				if (idprinter.getId().equals(buttonEditPrinters)) {
					
					String idPrinters = idprinter.getId();
					//DBUtils.getIdMobile(conn, idMobiles2);
					List<Printers> queryEditIdPrinters = DBUtils.editIdPrinter(conn, idPrinters);
								
					//String idUPMobiles = idMobiles2;
					request.setAttribute("buttonEditPrinters", buttonEditPrinters);
					request.setAttribute("queryEditIdPrinters", queryEditIdPrinters);
					//doGet(request, response);
					//String idUPMobiles = (String) request.getAttribute("buttonEditMobiles");
					//System.out.println("This is string " + idUPMobiles);
					
					RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/EditPrinterServlet");

					dispatcher.include(request, response);

				}

			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}

}
