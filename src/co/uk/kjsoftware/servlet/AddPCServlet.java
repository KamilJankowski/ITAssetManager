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

import co.uk.kjsoftware.conn.MySQLConnUtils;
import co.uk.kjsoftware.utils.AddMobile;
import co.uk.kjsoftware.utils.AddPC;
import co.uk.kjsoftware.utils.DBUtils;

/**
 * Servlet implementation class AddPCServlet
 */
@WebServlet(urlPatterns = {"/addpc"})
public class AddPCServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddPCServlet() {
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
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/addPCView.jsp");
        
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

		String button = request.getParameter("addpc");
		if ("add_pc".equals(button)) {
			System.out.println("addpc!!!");
			AddPC addPC = new AddPC();
			addPC.AddPCRow(request, response);

			Connection conn;
			try {
				conn = MySQLConnUtils.getMySQLConnection();
				DBUtils.addPcs(conn);

				// doGet(request, response);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

}
