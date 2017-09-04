package co.uk.kjsoftware.utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.opencsv.*;

import co.uk.kjsoftware.conn.MySQLConnUtils;

public class DownloadFile {
	
	//Download data from mobiles table to c:\share\file.csv
	public void DownloadFileMobiles() throws IOException {

		try {

			Connection conn = MySQLConnUtils.getMySQLConnection();
			ResultSet rs = DBUtils.queryMobilesResult(conn);
			File downloadMobilesCSV = new File("c:\\share\\exportMobiles.csv");
			if (!(downloadMobilesCSV.exists())) {
				downloadMobilesCSV.createNewFile();
				System.out.println("File is created!");
			}
			CSVWriter writer = new CSVWriter(new FileWriter(downloadMobilesCSV), ',');
			// feed in your array (or convert your data to an array)
			// String[] entries = "first#second#third".split("#");
			boolean headers = true;
			writer.writeAll(rs, headers);
			writer.close();

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}

	}
	
	//Download data from pcs table to c:\share\exportPCs.csv
	public void DownloadFilePCs() throws IOException {

		try {

			Connection conn = MySQLConnUtils.getMySQLConnection();
			ResultSet rs = DBUtils.queryPCsResult(conn);
			File downloadPCsCSV = new File("c:\\share\\exportPCs.csv");
			if (!(downloadPCsCSV.exists())) {
				downloadPCsCSV.createNewFile();
				System.out.println("File is created!");
			}
			CSVWriter writer = new CSVWriter(new FileWriter(downloadPCsCSV), ',');
			// feed in your array (or convert your data to an array)
			// String[] entries = "first#second#third".split("#");
			boolean headers = true;
			writer.writeAll(rs, headers);
			writer.close();

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}

	}
	
	//Download data from printers table to c:\share\exportPrinters.csv
	public void DownloadFilePrinters() throws IOException {

		try {

			Connection conn = MySQLConnUtils.getMySQLConnection();
			ResultSet rs = DBUtils.queryPrintersResult(conn);
			File downloadPrintersCSV = new File("c:\\share\\exportPrinters.csv");
			if (!(downloadPrintersCSV.exists())) {
				downloadPrintersCSV.createNewFile();
				System.out.println("File is created!");
			}
			CSVWriter writer = new CSVWriter(new FileWriter(downloadPrintersCSV), ',');
			// feed in your array (or convert your data to an array)
			// String[] entries = "first#second#third".split("#");
			boolean headers = true;
			writer.writeAll(rs, headers);
			writer.close();

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}

	}
}
