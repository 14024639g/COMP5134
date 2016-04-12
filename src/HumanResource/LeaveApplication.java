package HumanResource;

import java.util.*;
import java.text.*;

public class LeaveApplication {

	private int ApplicationID;
	private int StaffID;
	private int SupervisorID;
	private Date FromDate;
	private Date ToDate;
	private boolean Approved;
	private boolean Completed;
	private boolean NotfiyApplier;
	
	final static String DATE_FORMAT = "dd/MM/yyyy";
	
	public int getApplicationID() {
		return ApplicationID;
	}

	public void setApplicationID(int applicationID) {
		ApplicationID = applicationID;
	}

	public int getStaffID() {
		return StaffID;
	}

	public void setStaffID(int staffID) {
		StaffID = staffID;
	}

	public int getSupervisorID() {
		return SupervisorID;
	}

	public void setSupervisorID(int supervisorID) {
		SupervisorID = supervisorID;
	}

	public Date getFromDate() {
		return FromDate;
	}

	public void setFromDate(Date fromDate) {
		FromDate = fromDate;
	}

	public Date getToDate() {
		return ToDate;
	}

	public void setToDate(Date toDate) {
		ToDate = toDate;
	}

	public boolean isApproved() {
		return Approved;
	}

	public void setApproved(boolean approved) {
		Approved = approved;
	}

	public boolean isCompleted() {
		return Completed;
	}

	public void setCompleted(boolean completed) {
		Completed = completed;
	}

	public boolean isNotfiyApplier() {
		return NotfiyApplier;
	}

	public void setNotfiyApplier(boolean notfiyApplier) {
		NotfiyApplier = notfiyApplier;
	}
	
	public static Date StringtoDateTime(String date) 
	{
		DateFormat format = new SimpleDateFormat(DATE_FORMAT);
		format.setLenient(false);
        try
        {
        	Date DateTime = format.parse(date);
	        return DateTime;
        }
        catch (ParseException e)
        {
            return null;
        }
	}

	public LeaveApplication(int ApplicationID, int StaffID, int SupervisorID, Date FromDate,
			Date ToDate, boolean Approved, boolean Completed, boolean NotfiyApplier)
	{
		this.ApplicationID = ApplicationID;
		this.StaffID = StaffID;
		this.SupervisorID = SupervisorID;
		this.FromDate = FromDate;
		this.ToDate = ToDate;
		this.Approved = Approved;
		this.Completed = Completed;
		this.NotfiyApplier = NotfiyApplier;
	}

	public static List<LeaveApplication> LeaveApplicationTable = new ArrayList<LeaveApplication>();
	
	public static int ApplyLeave(int staffid, int supervisorid,
			Date FromDate, Date ToDate)
	{
		int ApplicationID = 1;
		if (LeaveApplicationTable.size() != 0)
			ApplicationID = LeaveApplicationTable.get(LeaveApplicationTable.size() - 1).getApplicationID() + 1;
		LeaveApplicationTable.add(new LeaveApplication(ApplicationID, staffid, supervisorid,
				FromDate, ToDate, false, false, false));
		return ApplicationID;
	}
	
	public static void ProcessApplication(int applicationid, int staffid, boolean approve)
	{
		for(int i = 0; i < LeaveApplicationTable.size(); i++)
		{
			if (LeaveApplicationTable.get(i).getApplicationID() == applicationid)
			{
				if (approve)
				{
					if (StaffRelationship.FindDirectSuperviosr(staffid) == 0)
					{
						LeaveApplicationTable.get(i).setApproved(true);
						LeaveApplicationTable.get(i).setCompleted(true);
					}
					else
					{
						LeaveApplicationTable.get(i).setSupervisorID(StaffRelationship.FindDirectSuperviosr(staffid));
					}
				}
				else
					LeaveApplicationTable.get(i).setCompleted(true);
				return;
			}
		}
	}
	
	public static List<String> GetApplication(int supervisorid)
	{
		List<String> NotfiySupervisor = new ArrayList<String>(); 
		DateFormat format = new SimpleDateFormat("MMMM dd yyyy", Locale.ENGLISH);
		
		for(int i = 0; i < LeaveApplicationTable.size(); i++)
		{
			if (LeaveApplicationTable.get(i).getSupervisorID() == supervisorid
					&& LeaveApplicationTable.get(i).isCompleted() == false)
			{
				NotfiySupervisor.add("StaffName(ID) = " + Staffs.GetStaffNameByID(LeaveApplicationTable.get(i).getStaffID())
				+ "(" + LeaveApplicationTable.get(i).getStaffID() + ")" + " want to take leave from " + format.format(LeaveApplicationTable.get(i).FromDate)
				+ " To " + format.format(LeaveApplicationTable.get(i).ToDate));
				NotfiySupervisor.add(Integer.toString(LeaveApplicationTable.get(i).getApplicationID()));
			}
		}
		
		return NotfiySupervisor;
	}
	
	public static List<String> NotfiyApplier(int staffid)
	{
		List<String> NotfiyApplier = new ArrayList<String>(); 
		
		for(int i = 0; i < LeaveApplicationTable.size(); i++)
		{
			if (LeaveApplicationTable.get(i).getStaffID() == staffid
					&& LeaveApplicationTable.get(i).isCompleted() == true
					&& LeaveApplicationTable.get(i).isNotfiyApplier() == false)
			{
				if(LeaveApplicationTable.get(i).isApproved())
					NotfiyApplier.add("Your Application ID = " + LeaveApplicationTable.get(i).getApplicationID() + " is approved");
				else
					NotfiyApplier.add("Your Application ID = " + LeaveApplicationTable.get(i).getApplicationID() + " is rejected");
				
				LeaveApplicationTable.get(i).setNotfiyApplier(true);
			}
		}	
		return NotfiyApplier;
	}
	
	public static void Notfied(int ApplicationID)
	{	
		for(int i = 0; i < LeaveApplicationTable.size(); i++)
		{
			if (LeaveApplicationTable.get(i).getApplicationID() == ApplicationID)
			{
				LeaveApplicationTable.get(i).setNotfiyApplier(true);
				return;
			}
		}
	}
	
}
