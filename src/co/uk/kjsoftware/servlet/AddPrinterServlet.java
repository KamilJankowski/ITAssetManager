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
import co.uk.kjsoftware.utils.AddPrinter;
import co.uk.kjsoftware.utils.DBUtils;

/**
 * Servlet implementation class AddPrinterServlet
 */
@WebServlet(name = "addprinter", urlPatterns = { "/addprinter" })
public class AddPrinterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddPrinterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/addPrinterView.jsp");
        
	       dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		String button = request.getParameter("addprinter");
		if ("addprinter".equals(button)) {
			System.out.println("addprinter!!!");
			AddPrinter addPrinter = new AddPrinter();
			addPrinter.AddPrinterRow(request, response);

			Connection conn;
			try {
				conn = MySQLConnUtils.getMySQLConnection();
				DBUtils.addPrinter(conn);

				// doGet(request, response);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

}
