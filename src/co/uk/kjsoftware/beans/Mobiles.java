package co.uk.kjsoftware.beans;

public class Mobiles {
	
	private String id;
	private String make;
	private String model;
	private String imei;
	private String m_serial_number;
	private String provider;
	private String s_serial_number;
	private String mobile_number;
	private String first_name;
	private String last_name;
	private String department;
	
	private String id_sim;
	

	public Mobiles() {
		// TODO Auto-generated constructor stub
	}
	public Mobiles(String model) {
		this.model = model;
	}


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

	public String getImei() {
		return imei;
	}

	public void setImei(String imei) {
		this.imei = imei;
	}

	public String getM_serial_number() {
		return m_serial_number;
	}

	public void setM_serial_number(String m_serial_number) {
		this.m_serial_number = m_serial_number;
	}

	public String getProvider() {
		return provider;
	}

	public void setProvider(String provider) {
		this.provider = provider;
	}

	public String getS_serial_number() {
		return s_serial_number;
	}

	public void setS_serial_number(String s_serial_number) {
		this.s_serial_number = s_serial_number;
	}

	public String getMobile_number() {
		return mobile_number;
	}

	public void setMobile_number(String mobile_number) {
		this.mobile_number = mobile_number;
	}

	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	
	public String getLast_name() {
		return last_name;
	}
	
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}


	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}
	
	public String getId_sim() {
		return id_sim;
	}
	public void setId_sim(String id_sim) {
		this.id_sim = id_sim;
	}


}
