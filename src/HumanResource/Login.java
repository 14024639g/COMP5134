package HumanResource;

public class Login {
	
	private static int StaffID;

	public int getStaffID() {
		return StaffID;
	}

	public void setStaffID(int staffID) {
		StaffID = staffID;
	}
	
	public static void CurrentLogin(int staffID) {
		StaffID = staffID;
	} 
	
	public static int getCurrentLogin() {
		return StaffID;
	} 
}
