package co.uk.kjsoftware.utils;

import javax.swing.JFileChooser;

import java.awt.Container;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.*;

import co.uk.kjsoftware.beans.Departments;
import co.uk.kjsoftware.beans.HWmake;
import co.uk.kjsoftware.beans.HWmodel;
import co.uk.kjsoftware.beans.Mobiles;
import co.uk.kjsoftware.beans.Pcs;
import co.uk.kjsoftware.beans.Printers;
import co.uk.kjsoftware.beans.SIM;
import co.uk.kjsoftware.beans.Users;

import javax.swing.*;

public class FileChooser {
	public static List<HWmake> makeList;
	public static List<HWmodel> modelList;
	public static List<Users> usersList;
	public static List<Mobiles> mobilesList;
	public static List<Pcs> pcsList;
	public static List<Printers> printersList;
	public static List<Departments> departmentList;
	public static List<SIM> simList;

	public FileChooser() {

	}

	// swing - choose my CSV file
	public File chooseCSV() {
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
		int result = fileChooser.showOpenDialog(null);

		File selectedFile = fileChooser.getSelectedFile();

		System.out.println("Selected file: " + selectedFile);
		return selectedFile;

	}
	
	// read mobiles columns from CSV file
	public void importCSVMobiles(File iCSV) {
		importCSVMake(iCSV);
		importCSVModel(iCSV);
		importCSVSIM(iCSV);
		importCSVUsers(iCSV);
		try {
			
			CSVReader creadear = new CSVReader(new FileReader(iCSV));
			String[] nextline;
			List<Mobiles> ilist = new ArrayList<Mobiles>();
			while ((nextline = creadear.readNext()) != null) {
				String first_name = nextline[0];
				String last_name =nextline[1];
				String make = nextline[2];
				String model = nextline[3];
				String serial_number = nextline[4];
				String imei = nextline[5];
				String provider = nextline[6];
				String s_serial_number = nextline[7];
				String mobile_number = nextline[8];
				
				
				
				
				first_name = first_name.trim();
				last_name = last_name.trim();
				make = make.trim();
				model = model.trim();
				serial_number = serial_number.trim();
				imei = imei.trim();
				provider = provider.trim();
				s_serial_number = s_serial_number.trim();
				mobile_number = mobile_number.trim();
				
				
				
				
				Mobiles mobiles = new Mobiles();
				mobiles.setFirst_name(first_name);
				mobiles.setLast_name(last_name);
				mobiles.setMake(make);
				mobiles.setModel(model);
				mobiles.setM_serial_number(serial_number);
				mobiles.setImei(imei);
				mobiles.setProvider(provider);
				mobiles.setS_serial_number(s_serial_number);
				mobiles.setMobile_number(mobile_number);
				

				ilist.add(mobiles);
				mobilesList = ilist;

			}

			creadear.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	
	
	// read pcs columns from CSV file
		public void importCSVPcs(File iCSV) {
			importCSVMake(iCSV);
			importCSVModel(iCSV);
			
			importCSVUsers(iCSV);
			importCSVDepartment(iCSV);
			try {
				
				CSVReader creadear = new CSVReader(new FileReader(iCSV));
				String[] nextline;
				List<Pcs> ilist = new ArrayList<Pcs>();
				while ((nextline = creadear.readNext()) != null) {
					String first_name = nextline[0];
					String last_name =nextline[1];
					String make = nextline[2];
					String model = nextline[3];
					String serial_number = nextline[4];
					String hostname = nextline[5];
					String ip_address = nextline[6];
					String department = nextline[7];
					
					
					
					
					first_name = first_name.trim();
					last_name = last_name.trim();
					make = make.trim();
					model = model.trim();
					serial_number = serial_number.trim();
					hostname = hostname.trim();
					ip_address = ip_address.trim();
					department = department.trim();
					
					
					
					
					Pcs pc = new Pcs();
					pc.setFirst_name(first_name);
					pc.setLast_name(last_name);
					pc.setMake(make);
					pc.setModel(model);
					pc.setSerial_number(serial_number);
					pc.setHostname(hostname);
					pc.setIp_address(ip_address);
					pc.setDepartment(department);
										

					ilist.add(pc);
					pcsList = ilist;

				}

				creadear.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

		// read printers columns from CSV file
				public void importCSVPrinters(File iCSV) {
					importCSVMakePrinter(iCSV);
					importCSVModelPrinter(iCSV);
					
					importCSVDepartmentPrinters(iCSV);
					try {
						
						CSVReader creadear = new CSVReader(new FileReader(iCSV));
						String[] nextline;
						List<Printers> ilist = new ArrayList<Printers>();
						while ((nextline = creadear.readNext()) != null) {
							
							String make = nextline[0];
							String model = nextline[1];
							String serial_number = nextline[2];
							String hostname = nextline[3];
							String ip_address = nextline[4];
							String department = nextline[5];
							
							
							
							
						
							make = make.trim();
							model = model.trim();
							serial_number = serial_number.trim();
							hostname = hostname.trim();
							ip_address = ip_address.trim();
							department = department.trim();
							
							
							
							
							Printers printer = new Printers();
						
							printer.setMake(make);
							printer.setModel(model);
							printer.setSerial_number(serial_number);
							printer.setHostname(hostname);
							printer.setIp_address(ip_address);
							printer.setDepartment(department);
												

							ilist.add(printer);
							printersList = ilist;

						}

						creadear.close();
					} catch (IOException e) {
						e.printStackTrace();
					}

				}
		
	// read users column from CSV file
	public void importCSVUsers(File iCSV) {

		try {
			CSVReader creadear = new CSVReader(new FileReader(iCSV));
			String[] nextline;
			List<Users> ilist = new ArrayList<Users>();
			// List<Users> ilist1 = new ArrayList<Users>();
			while ((nextline = creadear.readNext()) != null) {

				String first_name = nextline[0];
				String last_name = nextline[1];
				first_name = first_name.trim();
				last_name = last_name.trim();
				Users users = new Users();
				users.setFirst_name(first_name);
				users.setLast_name(last_name);

				ilist.add(users);

				usersList = ilist;

			}

			creadear.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	// read make column from CSV file
	public void importCSVMake(File iCSV) {
		//importCSVModel(iCSV);
		try {
			CSVReader creadear = new CSVReader(new FileReader(iCSV));
			String[] nextline;
			List<HWmake> ilist = new ArrayList<HWmake>();
			while ((nextline = creadear.readNext()) != null) {

				String make = nextline[2];
				make = make.trim();
				HWmake hwmake = new HWmake();
				hwmake.setMake(make);

				ilist.add(hwmake);
				makeList = ilist;

			}

			creadear.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	// read make column from CSV file
		public void importCSVMakePrinter(File iCSV) {
			//importCSVModel(iCSV);
			try {
				CSVReader creadear = new CSVReader(new FileReader(iCSV));
				String[] nextline;
				List<HWmake> ilist = new ArrayList<HWmake>();
				while ((nextline = creadear.readNext()) != null) {

					String make = nextline[0];
					make = make.trim();
					HWmake hwmake = new HWmake();
					hwmake.setMake(make);

					ilist.add(hwmake);
					makeList = ilist;

				}

				creadear.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

	// read model column from CSV file
	public void importCSVModel(File iCSV) {
		
		try {
			
			CSVReader creadear = new CSVReader(new FileReader(iCSV));
			String[] nextline;
			List<HWmodel> ilist = new ArrayList<HWmodel>();
			while ((nextline = creadear.readNext()) != null) {

				String model = nextline[3];
				model = model.trim();
				HWmodel hwmodel = new HWmodel();
				hwmodel.setModel(model);

				ilist.add(hwmodel);
				modelList = ilist;

			}

			creadear.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	// read model column from CSV file
		public void importCSVModelPrinter(File iCSV) {
			
			try {
				
				CSVReader creadear = new CSVReader(new FileReader(iCSV));
				String[] nextline;
				List<HWmodel> ilist = new ArrayList<HWmodel>();
				while ((nextline = creadear.readNext()) != null) {

					String model = nextline[1];
					model = model.trim();
					HWmodel hwmodel = new HWmodel();
					hwmodel.setModel(model);

					ilist.add(hwmodel);
					modelList = ilist;

				}

				creadear.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

	// read sim columns from CSV file
	public void importCSVSIM(File iCSV) {

		try {
			CSVReader creadear = new CSVReader(new FileReader(iCSV));
			String[] nextline;
			List<SIM> ilist = new ArrayList<SIM>();
			while ((nextline = creadear.readNext()) != null) {

				String provider = nextline[6];
				String serial_number = nextline[7];
				String mobile_number = nextline[8];
				provider = provider.trim();
				serial_number = serial_number.trim();
				mobile_number = mobile_number.trim();
				SIM sim = new SIM();
				sim.setProvider(provider);
				sim.setSerial_number(serial_number);
				sim.setMobile_number(mobile_number);

				ilist.add(sim);
				simList = ilist;

			}

			creadear.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public void importCSVDepartment(File iCSV) {

		try {
			CSVReader creadear = new CSVReader(new FileReader(iCSV));
			String[] nextline;
			List<Departments> ilist = new ArrayList<Departments>();
			while ((nextline = creadear.readNext()) != null) {

				String department_name = nextline[7];
				
				department_name = department_name.trim();
				
				Departments department = new Departments();
				department.setDepartment_name(department_name);
				

				ilist.add(department);
				departmentList = ilist;

			}

			creadear.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public void importCSVDepartmentPrinters(File iCSV) {

		try {
			CSVReader creadear = new CSVReader(new FileReader(iCSV));
			String[] nextline;
			List<Departments> ilist = new ArrayList<Departments>();
			while ((nextline = creadear.readNext()) != null) {

				String department_name = nextline[5];
				
				department_name = department_name.trim();
				
				Departments department = new Departments();
				department.setDepartment_name(department_name);
				

				ilist.add(department);
				departmentList = ilist;

			}

			creadear.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	


}
