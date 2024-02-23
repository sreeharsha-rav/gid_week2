package q1;

import java.util.ArrayList;

public class Doctor {
	private String docId;
	private String docName;
	private ArrayList<Appointment> apptList;
	
	// Constructor
	public Doctor(String docId, String docName) {
		this.docId = docId;
		this.docName = docName;
		apptList = new ArrayList<Appointment>();
	}
	
	// Getters
	public String getDocId() {
		return docId;
	}
	
	public String getDocName() {
		return docName;
	}
	
	public ArrayList<Appointment> getApptList() {
		return apptList;
	}
	
	// Setters
	public void setDocId(String docId) {
		this.docId = docId;
	}
	
	public void setDocName(String docName) {
		this.docName = docName;
	}
	
	// Add appointment to the list
	public void addAppointment(Appointment appt) {
		apptList.add(appt);
	}
	
	// Print appointment list
	public void printAppointment() {
		for (Appointment appt : apptList) {
			System.out.println(appt);
		}
	}
	
	// toString
	@Override
	public String toString() {
		return "Doctor " + "{" + "\n" 
				+ "\t" + "docId: " + docId + "\n" 
				+ "\t" + "docName: " + docName + "\n" 
				+ "\t" + "apptList: " + apptList + "\n" 
				+ "}";
	}
}
