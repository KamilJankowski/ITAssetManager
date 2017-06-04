package co.uk.kjsoftware.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import co.uk.kjsoftware.beans.HWmake;
import co.uk.kjsoftware.beans.HWmodel;
import co.uk.kjsoftware.beans.Mobiles;
import co.uk.kjsoftware.beans.Pcs;
import co.uk.kjsoftware.beans.Printers;
import co.uk.kjsoftware.beans.SIM;
import co.uk.kjsoftware.beans.Users;
import co.uk.kjsoftware.servlet.MobilesServlet;



public class DBUtils {

	//Select query to display mobiles table	
	public static List<Mobiles> queryMobiles(Connection conn) throws SQLException {

		String sql = "select  id_mobile, make, model, IMEI, mobiles.serial_number, provider, sim_cards.serial_number, mobile_number, users.first_name, users.last_name, department_name"
				+ " from mobiles" + " left join sim_cards" + " on mobiles.id_sim_cards = sim_cards.id_sim_cards"
				+ " left join hardware_make" + " on mobiles.id_hardware_make = hardware_make.id_hardware_make"
				+ " left join hardware_model" + " on mobiles.id_hardware_model = hardware_model.id_hardware_model"
				+ " left join users" + " on mobiles.id_users = users.id_users" + " left join departments"
				+ " on mobiles.id_departments = departments.id_departments";

		PreparedStatement pstm = conn.prepareStatement(sql);

		ResultSet rs = pstm.executeQuery();
		List<Mobiles> list = new ArrayList<Mobiles>();

		while (rs.next()) {
			String id = rs.getString("id_mobile");
			String make = rs.getString("make");
			String model = rs.getString("model");
			String imei = rs.getString("IMEI");
			String m_serial_number = rs.getString("mobiles.serial_number");
			String provider = rs.getString("provider");
			String s_serial_number = rs.getString("sim_cards.serial_number");
			String mobile_number = rs.getString("mobile_number");
			String first_name = rs.getString("first_name");
			String last_name = rs.getString("last_name");
			String department_name = rs.getString("department_name");

			Mobiles mobile = new Mobiles();

			mobile.setId(id);
			mobile.setMake(make);
			mobile.setModel(model);
			mobile.setImei(imei);
			mobile.setM_serial_number(m_serial_number);
			mobile.setProvider(provider);
			mobile.setS_serial_number(s_serial_number);
			mobile.setMobile_number(mobile_number);
			mobile.setFirst_name(first_name);
			mobile.setLast_name(last_name);
			mobile.setDepartment(department_name);

			list.add(mobile);
		}
		return list;
	}
	
	//ResultSet 
	public static ResultSet queryMobilesResult(Connection conn) throws SQLException {

		String sql = "select  make, model, IMEI, mobiles.serial_number, provider, sim_cards.serial_number, mobile_number, users.first_name, users.last_name, department_name"
				+ " from mobiles" + " left join sim_cards" + " on mobiles.id_sim_cards = sim_cards.id_sim_cards"
				+ " left join hardware_make" + " on mobiles.id_hardware_make = hardware_make.id_hardware_make"
				+ " left join hardware_model" + " on mobiles.id_hardware_model = hardware_model.id_hardware_model"
				+ " left join users" + " on mobiles.id_users = users.id_users" + " left join departments"
				+ " on mobiles.id_departments = departments.id_departments";

		PreparedStatement pstm = conn.prepareStatement(sql);

		ResultSet rs = pstm.executeQuery();

		return rs;
	}
	
	//List of ids from mobiles table
	public static List<Mobiles> queryIdMobile(Connection conn) throws SQLException {
		String sql = "select id_mobile from mobiles";
		
		PreparedStatement pstm = conn.prepareStatement(sql);
		ResultSet rs = pstm.executeQuery();
		List<Mobiles> list = new ArrayList<Mobiles>();
		while(rs.next()) {
			String id = rs.getString("id_mobile");
			
			Mobiles mobile = new Mobiles();
			mobile.setId(id);
			
			list.add(mobile);
			
					
		}
		
		return list;
		
	}
	
	public static boolean removeIdMobile(Connection conn, String idMobiles) throws SQLException {
		
		String sql = "delete from mobiles where id_mobile=" + idMobiles + "";
		
		 PreparedStatement pstm = conn.prepareStatement(sql);
			
		 pstm.executeUpdate();
		 
		 
		 return true;

		
	}

	public static List<Pcs> queryPcs(Connection conn) throws SQLException {

		String sql = "select  make, model, hostname, ip_address,  serial_number, concat(first_name, ' ',  last_name)  AS user, department_name"
				+ " from pcs  left join hardware_make" + " on pcs.id_hardware_make = hardware_make.id_hardware_make"
				+ " left join hardware_model" + " on pcs.id_hardware_model = hardware_model.id_hardware_model"
				+ " left join users" + " on pcs.id_users = users.id_users" + " left join departments"
				+ " on pcs.id_departments = departments.id_departments";
		PreparedStatement pstm = conn.prepareStatement(sql);

		ResultSet rs = pstm.executeQuery();
		List<Pcs> list = new ArrayList<Pcs>();

		while (rs.next()) {

			String make = rs.getString("make");
			String model = rs.getString("model");
			String hostname = rs.getString("hostname");
			String ip_address = rs.getString("ip_address");
			String serial_number = rs.getString("serial_number");
			String user = rs.getString("user");
			String department_name = rs.getString("department_name");

			Pcs pc = new Pcs();

			pc.setMake(make);
			pc.setModel(model);
			pc.setHostname(hostname);
			pc.setIp_address(ip_address);
			pc.setSerial_number(serial_number);
			pc.setUser(user);
			pc.setDepartment(department_name);

			list.add(pc);
		}
		return list;

	}

	public static List<Printers> queryPrinters(Connection conn) throws SQLException {

		String sql = "select  make, model, hostname, ip_address,  serial_number, department_name"
				+ " from printers  left join hardware_make"
				+ " on printers.id_hardware_make = hardware_make.id_hardware_make" + " left join hardware_model"
				+ " on printers.id_hardware_model = hardware_model.id_hardware_model" + " left join departments"
				+ " on printers.id_departments = departments.id_departments";
		PreparedStatement pstm = conn.prepareStatement(sql);

		ResultSet rs = pstm.executeQuery();
		List<Printers> list = new ArrayList<Printers>();

		while (rs.next()) {

			String make = rs.getString("make");
			String model = rs.getString("model");
			String hostname = rs.getString("hostname");
			String ip_address = rs.getString("ip_address");
			String serial_number = rs.getString("serial_number");
			String department_name = rs.getString("department_name");

			Printers printer = new Printers();

			printer.setMake(make);
			printer.setModel(model);
			printer.setHostname(hostname);
			printer.setIp_address(ip_address);
			printer.setSerial_number(serial_number);
			printer.setDepartment(department_name);

			list.add(printer);
		}
		return list;

	}

	//Add new mobile to mobiles table
	public static void insertMobiles(Connection conn) throws SQLException {
		insertUsers(conn);
		insertMake(conn);
		
		insertModel(conn);
		insertSIM(conn);

		List<Mobiles> fcList = FileChooser.mobilesList;
		for (Mobiles lineFclist : fcList) {
			String valFclistFn = lineFclist.getFirst_name();
			String valFclistLn = lineFclist.getLast_name();
			String valFclistMa = lineFclist.getMake();
			String valFclistMo = lineFclist.getModel();
			String valFclistI = lineFclist.getImei();
			String valFclistMs = lineFclist.getM_serial_number();
			String valFclistPro = lineFclist.getProvider();
			String valFclistSSn = lineFclist.getS_serial_number();
			String valFclistMon = lineFclist.getMobile_number();

			

			 String sql = "insert into mobiles(id_hardware_make, id_hardware_model, IMEI, serial_number, id_sim_cards, id_users) values((SELECT id_hardware_make FROM hardware_make WHERE make ='"+ valFclistMa +"'),(SELECT id_hardware_model FROM hardware_model WHERE model ='"+ valFclistMo +"'),'"+ valFclistI + "', '"+ valFclistMs + "', (SELECT id_sim_cards FROM sim_cards WHERE provider ='"+ valFclistPro +"' AND serial_number ='"+ valFclistSSn +"' AND mobile_number = '"+ valFclistMon +"'), (SELECT id_users FROM users WHERE first_name ='"+ valFclistFn +"' AND last_name ='"+ valFclistLn +"'))";
			
			 PreparedStatement pstm = conn.prepareStatement(sql);
			
			 pstm.executeUpdate();

		}

	}

	// insert data from csv file to users
	public static void insertUsers(Connection conn) throws SQLException {

		try {

			List<Users> fcList = FileChooser.usersList;

			for (Users lineFclist : fcList) {

				String valFclistFn = lineFclist.getFirst_name();
				String valFclistLn = lineFclist.getLast_name();

				if (!(valFclistFn.isEmpty())) {

					String sql = "insert ignore into users(first_name, last_name) values('" + valFclistFn + "', '"
							+ valFclistLn + "')";

					PreparedStatement pstm = conn.prepareStatement(sql);

					pstm.executeUpdate();
				}

			}

			System.out.println("Users table updated successfully.");

		} catch (SQLException e) {
			System.out.println(e);
		}

	}

	// insert data from csv file to hardware_make
	public static void insertMake(Connection conn) throws SQLException {

		try {

			List<HWmake> fcList = FileChooser.makeList;

			for (HWmake lineFclist : fcList) {

				String valFclist = lineFclist.getMake();

				if (!(valFclist.isEmpty())) {

					String sql = "insert ignore into hardware_make(make) values('" + valFclist + "')";

					PreparedStatement pstm = conn.prepareStatement(sql);

					pstm.executeUpdate();
				}

			}
			System.out.println("Hardware_make table updated successfully.");

		} catch (SQLException e) {
			System.out.println(e);
		}

	}

	// insert data from csv file to hardware_model
	public static void insertModel(Connection conn) throws SQLException {

		try {

			List<HWmodel> fcList = FileChooser.modelList;

			for (HWmodel lineFclist : fcList) {

				String valFclist = lineFclist.getModel();

				if (!(valFclist.isEmpty())) {

					String sql = "insert ignore into hardware_model(model) values('" + valFclist + "')";

					PreparedStatement pstm = conn.prepareStatement(sql);

					pstm.executeUpdate();
				}

				System.out.println("Hardware_model table updated successfully.");

			}
		} catch (SQLException e) {
			System.out.println(e);
		}

	}

	// insert data from csv file to users
	public static void insertSIM(Connection conn) throws SQLException {

		try {

			List<SIM> fcList = FileChooser.simList;

			for (SIM lineFclist : fcList) {

				String valFclistP = lineFclist.getProvider();
				String valFclistSn = lineFclist.getSerial_number();
				String valFclistMn = lineFclist.getMobile_number();

				if (!(valFclistSn.isEmpty())) {

					String sql = "insert ignore into sim_cards(provider, serial_number, mobile_number) values('"
							+ valFclistP + "', '" + valFclistSn + "', '" + valFclistMn + "')";

					PreparedStatement pstm = conn.prepareStatement(sql);

					pstm.executeUpdate();
				}

			}

			System.out.println("sim_cards table updated successfully.");

		} catch (SQLException e) {
			System.out.println(e);
		}

	}
}
