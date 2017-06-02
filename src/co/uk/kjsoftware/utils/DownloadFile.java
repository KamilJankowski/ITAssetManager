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

	public DownloadFile() throws IOException {

		try {

			Connection conn = MySQLConnUtils.getMySQLConnection();
			ResultSet rs = DBUtils.queryMobilesResult(conn);
			File downloadMobilesCSV = new File("c:\\share\\file.csv");
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
}
