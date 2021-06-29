package org.openjfx;

public class ModelMyChildren {
	String kidname, dob, bloodgroup;

	public ModelMyChildren(String kidname, String dob, String bloodgroup) {
//		super();
		this.kidname = kidname;
		this.dob = dob;
		this.bloodgroup = bloodgroup;
	}

	public String getKidname() {
		return kidname;
	}

	public void setKidname(String kidname) {
		this.kidname = kidname;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getBloodgroup() {
		return bloodgroup;
	}

	public void setBloodgroup(String bloodgroup) {
		this.bloodgroup = bloodgroup;
	}
	
	
	
	
}
