package q1;

import java.util.Date;

public class Appointment {
	private Date appDate;
	private int noOfPatients;
	
	// Constructor
	public Appointment() {
	}
	
	public Appointment(Date appDate, int noOfPatients) {
		this.appDate = appDate;
		this.noOfPatients = noOfPatients;
	}

	// Getters
	public Date getAppDate() {
		return appDate;
	}
	
	public int getNoOfPatients() {
		return noOfPatients;
	}
	
	// Setters
	public void setAppDate(Date appDate) {
		this.appDate = appDate;
	}
	
	public void setNoOfPatients(int noOfPatients) throws InvalidDataException {
		// noOfPatients must be between 1 to 15
		if (noOfPatients < 1 || noOfPatients > 15) {
			throw new InvalidDataException("Invalid Data. Number of patients must be between 1 to 15");
		}
		this.noOfPatients = noOfPatients;
	}
	
	// toString
	@Override
	public String toString() {
		return "Appointment " + "{" + "\n"
				+"\t" + "appDate: " + appDate + "\n"
				+"\t" + "noOfPatients: " + noOfPatients + "\n"
				+ "}";
	}
}
