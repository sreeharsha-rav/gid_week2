package q1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class TestClinic {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Doctor[] doctors = new Doctor[2];	// Array of 2 doctors
		
		// Input details for 2 doctors from user
		System.out.println("Enter details for 2 doctors: ");
		for (int i = 0; i < doctors.length; i++) {
            System.out.println("Enter doctor ID: ");
            String docId = sc.nextLine();
            System.out.println("Enter doctor name: ");
            String docName = sc.nextLine();
            doctors[i] = new Doctor(docId, docName);
        }
		System.out.println("Doctors added successfully!\n");
		
		// Add 2 appointments for each doctor
		System.out.println("Add 2 appointments for each doctor: ");
		for (int i = 0; i < doctors.length; i++) {
			int j = 0;
			while (j < 2){
				System.out.println("Enter details for appointment " + (j+1) + " for doctor " + doctors[i].getDocName());
				System.out.println("Enter appointment date (yyyy-mm-dd): ");
				String dateString = sc.nextLine();
				System.out.println("Enter number of patients: ");
				int noOfPatients = sc.nextInt();
				sc.nextLine();
				
				// Convert string to date
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				Date appDate = null;
				try {
					appDate = sdf.parse(dateString);
                } catch (ParseException e) {
                    e.printStackTrace();
				}
				
				// Create appointment object
				Appointment appt = new Appointment();
				try {
					appt.setAppDate(appDate);
					appt.setNoOfPatients(noOfPatients);
					doctors[i].addAppointment(appt);
					j++;
				} catch (Exception e) {
					System.out.println(e.getMessage());
					System.out.println("Please enter valid data again!");
				}
			}
		}
		
		// Accept doctor ID from user and print appointments
		System.out.println("Enter doctor ID to print appointments: ");
		String docId = sc.nextLine();
		boolean found = false;
		for (Doctor doctor : doctors) {
			if (doctor.getDocId().equals(docId)) {
				found = true;
				doctor.printAppointment();
				break;
			}
		}
		if (!found) {
			System.out.println("Doctor ID does not exist!");
		}
		sc.close();
	}
}
