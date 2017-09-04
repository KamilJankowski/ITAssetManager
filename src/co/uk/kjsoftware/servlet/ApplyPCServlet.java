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
import co.uk.kjsoftware.beans.Pcs;
import co.uk.kjsoftware.conn.MySQLConnUtils;
import co.uk.kjsoftware.utils.AddMobile;
import co.uk.kjsoftware.utils.AddPC;
import co.uk.kjsoftware.utils.DBUtils;

/**
 * Servlet implementation class ApplyPCServlet
 */
@WebServlet("/ApplyPCServlet")
public class ApplyPCServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApplyPCServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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

		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/index");

		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		
		List<Pcs> elist = null;

		Connection conn;
		try {
			conn = MySQLConnUtils.getMySQLConnection();
			elist = DBUtils.queryIdPC(conn);
			String buttonUpdatePcs = request.getParameter("updatePC");
	

			for (Pcs idpc : elist) {
				if (idpc.getId().equals(buttonUpdatePcs)) {
					// String buttonAttr = (String)
					// request.getAttribute("updateMobile");
					AddPC addPC = new AddPC();
					addPC.AddPCRow(request, response);
					String idPC = idpc.getId();

					String idPCRequest = request.getParameter("updatePC");
					// System.out.print(i);
					conn = MySQLConnUtils.getMySQLConnection();
				
					
					DBUtils.updatePC(conn, idPC);

					

				}

			}

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}

		
		
		
	}

}
