package co.uk.kjsoftware.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.uk.kjsoftware.beans.Departments;
import co.uk.kjsoftware.beans.HWmake;
import co.uk.kjsoftware.beans.HWmodel;
import co.uk.kjsoftware.beans.Pcs;
import co.uk.kjsoftware.beans.Printers;
import co.uk.kjsoftware.beans.Users;

public class AddPrinter extends HttpServlet  {
	
	private static final long serialVersionUID = 1L;
	public static List<Printers> iAddPrinterList;
	public static HWmake iAddMake;
	public static HWmodel iAddModel;
	public static Departments iAddDepartment;
	
	public AddPrinter() {
		
	}
	

	public void AddPrinterRow(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		AddMakeRow(request, response);
		AddModelRow(request, response);
		AddDepartment(request, response);
		List<Printers> addPrinterList = new ArrayList<Printers>();

		String readmake = request.getParameter("make");
		String readmodel = request.getParameter("model");
		String readhostname = request.getParameter("hostname");
		String readip_address = request.getParameter("ip_address");
		String readserial_number = request.getParameter("serial_number");
		String readdepartment = request.getParameter("department");

		readmake = readmake.trim();
		readmodel = readmodel.trim();
		readhostname = readhostname.trim();
		readip_address = readip_address.trim();
		readserial_number = readserial_number.trim();
		readdepartment = readdepartment.trim();

		System.out.println(readmake);
		System.out.println(readmodel);
		System.out.println(readhostname);
		System.out.println(readip_address);
		System.out.println(readserial_number);
		System.out.println(readdepartment);
		
		
		Printers printer = new Printers();
		printer.setMake(readmake);
		printer.setModel(readmodel);
		printer.setHostname(readhostname);
		printer.setIp_address(readip_address);
		printer.setSerial_number(readserial_number);
		printer.setDepartment(readdepartment);

		addPrinterList.add(printer);

		iAddPrinterList = addPrinterList;

	}

	public void AddMakeRow(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String readmake = request.getParameter("make");
		readmake = readmake.trim();

		HWmake make = new HWmake();
		make.setMake(readmake);

		HWmake addMake = make;
		iAddMake = addMake;
	}

	public void AddModelRow(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String readmodel = request.getParameter("model");
		readmodel = readmodel.trim();

		HWmodel model = new HWmodel();
		model.setModel(readmodel);

		HWmodel addModel = model;
		iAddModel = addModel;
	}

	


	public void AddDepartment(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String readdepartment = request.getParameter("department");

		readdepartment = readdepartment.trim();

		Departments department = new Departments();
		department.setDepartment_name(readdepartment);

		Departments addDepartment = department;
		iAddDepartment = addDepartment;
	}
}
