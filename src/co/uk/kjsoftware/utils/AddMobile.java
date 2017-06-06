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

import co.uk.kjsoftware.beans.HWmake;
import co.uk.kjsoftware.beans.Mobiles;
import co.uk.kjsoftware.conn.MySQLConnUtils;




public class AddMobile extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static List<Mobiles> iAddMobileList;
	public static HWmake iAddMake; 
	

	public AddMobile() {
	}
	
	
	
	public void AddMobileRow(HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException {
		AddMakeRow(request, response);
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
		
		//List<HWmake> addMakeList = new ArrayList<HWmake>();
		
		String readmake = request.getParameter("make");
		readmake = readmake.trim();
		
		HWmake make = new HWmake();
		make.setMake(readmake);
		
		HWmake addMake = make;		
		iAddMake = addMake;
	}
}
