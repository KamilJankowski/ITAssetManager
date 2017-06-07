package co.uk.kjsoftware.utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.opencsv.CSVWriter;

import co.uk.kjsoftware.beans.Departments;
import co.uk.kjsoftware.beans.HWmake;
import co.uk.kjsoftware.beans.HWmodel;
import co.uk.kjsoftware.beans.Mobiles;
import co.uk.kjsoftware.beans.SIM;
import co.uk.kjsoftware.beans.Users;
import co.uk.kjsoftware.conn.MySQLConnUtils;




public class AddMobile extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static List<Mobiles> iAddMobileList;
	public static HWmake iAddMake; 
	public static HWmodel iAddModel;
	public static SIM iAddSIM;
	public static Users iAddUser;
	public static Departments iAddDepartment;
	

	public AddMobile() {
	}
	
	
	
	public void AddMobileRow(HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException {
		AddMakeRow(request, response);
		AddModelRow(request, response);
		AddSIMRow(request, response);
		AddUserRow(request, response);
		AddDepartment(request, response);
		List<Mobiles> addMobileList = new ArrayList<Mobiles>();
		
		String readmake = request.getParameter("make");
		String readmodel = request.getParameter("model");
		String readimei = request.getParameter("imei");
		String readserial_number = request.getParameter("serial_number");
		String readprovider = request.getParameter("provider");
		String readsim_serial_number = request.getParameter("sim_serial_number");
		String readmobile_number = request.getParameter("mobile_number");
		String readfirst_name = request.getParameter("first_name");
		String readlast_name = request.getParameter("last_name");
		String readdepartment = request.getParameter("department");

		readmake = readmake.trim();
		readmodel = readmodel.trim();
		readimei = readimei.trim();
		readserial_number = readserial_number.trim();
		readprovider = readprovider.trim();
		readsim_serial_number = readsim_serial_number.trim();
		readmobile_number = readmobile_number.trim();
		readfirst_name = readfirst_name.trim();
		readlast_name = readlast_name.trim();
		readdepartment = readdepartment.trim();

		Mobiles mobiles = new Mobiles();
		mobiles.setFirst_name(readfirst_name);
		mobiles.setLast_name(readlast_name);
		mobiles.setMake(readmake);
		mobiles.setModel(readmodel);
		mobiles.setM_serial_number(readserial_number);
		mobiles.setImei(readimei);
		mobiles.setProvider(readprovider);
		mobiles.setS_serial_number(readsim_serial_number);
		mobiles.setMobile_number(readmobile_number);
		mobiles.setDepartment(readdepartment);
		
		addMobileList.add(mobiles);
		
		iAddMobileList = addMobileList;
		
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
	
	public void AddSIMRow(HttpServletRequest request, HttpServletResponse response)
	           throws ServletException, IOException {
		
		
		
		String readprovider = request.getParameter("provider");
		String readsim_serial_number = request.getParameter("sim_serial_number");
		String readmobile_number = request.getParameter("mobile_number");
		readprovider = readprovider.trim();
		readsim_serial_number = readsim_serial_number.trim();
		readmobile_number = readmobile_number.trim();
		
		SIM sim = new SIM();
		sim.setProvider(readprovider);
		sim.setSerial_number(readsim_serial_number);
		sim.setMobile_number(readmobile_number);
		
		SIM addSIM = sim;		
		iAddSIM = addSIM;
	}
	
	public void AddUserRow(HttpServletRequest request, HttpServletResponse response)
	           throws ServletException, IOException {
		
				
		String readfirst_name = request.getParameter("first_name");
		String readlast_name = request.getParameter("last_name");
		
		readfirst_name = readfirst_name.trim();
		readlast_name = readlast_name.trim();
				
		Users users = new Users();
		users.setFirst_name(readfirst_name);
		users.setLast_name(readlast_name);
				
		Users addUser = users;		
		iAddUser = addUser;
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
