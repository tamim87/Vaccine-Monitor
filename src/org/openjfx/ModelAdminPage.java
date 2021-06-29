package org.openjfx;

public class ModelAdminPage {
	String username, kidname, vaccinename ,dateofbirth ;

	public ModelAdminPage(String usernmae, String kidname, String vaccinename, String dateofbirth) {
//		super();
		this.username = usernmae;
		this.kidname = kidname;
		this.vaccinename = vaccinename;
		this.dateofbirth = dateofbirth;
	}

	public String getUsernmae() {
		return username;
	}

	public void setUsernmae(String usernmae) {
		this.username = usernmae;
	}

	public String getKidname() {
		return kidname;
	}

	public void setKidname(String kidname) {
		this.kidname = kidname;
	}

	public String getVaccinename() {
		return vaccinename;
	}

	public void setVaccinename(String vaccinename) {
		this.vaccinename = vaccinename;
	}

	public String getDateofbirth() {
		return dateofbirth;
	}

	public void setDateofbirth(String dateofbirth) {
		this.dateofbirth = dateofbirth;
	}
	
}
