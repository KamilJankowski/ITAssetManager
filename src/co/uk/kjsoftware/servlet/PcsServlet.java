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

import co.uk.kjsoftware.beans.Mobiles;
import co.uk.kjsoftware.beans.Pcs;

import co.uk.kjsoftware.conn.MySQLConnUtils;
import co.uk.kjsoftware.utils.DBUtils;
import co.uk.kjsoftware.utils.DownloadFile;
import co.uk.kjsoftware.utils.FileChooser;

/**
 * Servlet implementation class MobilesServlet
 */
@WebServlet("/pcs")
public class PcsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PcsServlet() {
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
        List<Pcs> list = null;
        try {
        	 Connection conn = MySQLConnUtils.getMySQLConnection(); 
            list = DBUtils.queryPcs(conn);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            errorString = e.getMessage();
        }
   
        // Store info in request attribute, before forward to views
        request.setAttribute("errorString", errorString);
        request.setAttribute("pcsList", list);
		
		
		
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/pcsView.jsp");

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
			filechooser.importCSVPcs(chooseCSV);
			try {
				Connection conn = MySQLConnUtils.getMySQLConnection();
				DBUtils.insertPcs(conn);

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
					downloadfile.DownloadFilePCs();
				}
				
				
				// read button delete value and delete row from table pcs

				List<Pcs> pclist = null;
				try {
					Connection conn = MySQLConnUtils.getMySQLConnection();
					pclist = DBUtils.queryIdPC(conn);
					String buttonDelPCs = request.getParameter("delPCBtn");

					for (Pcs idpc : pclist) {
						if (idpc.getId().equals(buttonDelPCs)) {

							
							String idPCs1 = idpc.getId();

							DBUtils.removeIdPC(conn, idPCs1);

							doGet(request, response);
						}

					}

				} catch (SQLException | ClassNotFoundException e) {
					e.printStackTrace();
				}
				
				
				// read button edit value and edit row from table pcs

				List<Pcs> elist = null;

				try {
					Connection conn = MySQLConnUtils.getMySQLConnection();
					elist = DBUtils.queryIdPC(conn);
					String buttonEditPCs = request.getParameter("editPCBtn");
					for (Pcs idpc : elist) {
						if (idpc.getId().equals(buttonEditPCs)) {
							
							String idPCs = idpc.getId();
							//DBUtils.getIdMobile(conn, idMobiles2);
							List<Pcs> queryEditIdPcs = DBUtils.editIdPC(conn, idPCs);
										
							//String idUPMobiles = idMobiles2;
							request.setAttribute("buttonEditPCs", buttonEditPCs);
							request.setAttribute("queryEditIdPcs", queryEditIdPcs);
							//doGet(request, response);
							//String idUPMobiles = (String) request.getAttribute("buttonEditMobiles");
							//System.out.println("This is string " + idUPMobiles);
							
							RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/EditPCServlet");

							dispatcher.include(request, response);

						}

					}
				} catch (SQLException | ClassNotFoundException e) {
					e.printStackTrace();
				}
				
				
				
				
				
	}

}
