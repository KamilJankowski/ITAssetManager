package co.uk.kjsoftware.beans;

public class Printers {
	private String id;
	private String make;
	private String model;
	private String hostname;
	private String ip_address;
	private String serial_number;
	private String department;

	public Printers() {
		// TODO Auto-generated constructor stub
	}
	/*
	 * public Printers(String make, String model, String hostname, String
	 * ip_address, String serial_number, String department ) { this.make = make;
	 * this.model = model; this.hostname = hostname; this.ip_address =
	 * ip_address; this.serial_number = serial_number; this.department =
	 * department; }
	 */

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getHostname() {
		return hostname;
	}

	public void setHostname(String hostname) {
		this.hostname = hostname;
	}

	public String getIp_address() {
		return ip_address;
	}

	public void setIp_address(String ip_address) {
		this.ip_address = ip_address;
	}

	public String getSerial_number() {
		return serial_number;
	}

	public void setSerial_number(String serial_number) {
		this.serial_number = serial_number;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

}
