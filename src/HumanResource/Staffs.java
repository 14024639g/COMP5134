package HumanResource;

import java.util.*;

public class Staffs {

	private int ID;
	private String Name;
	private String Password;
	private boolean Director;
	private boolean HR;
	
	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public boolean isDirector() {
		return Director;
	}

	public void setDirector(boolean director) {
		Director = director;
	}
	
	public boolean isHR() {
		return HR;
	}

	public void setHR(boolean hR) {
		HR = hR;
	}

	public Staffs(int ID, String Name, String Password, boolean Director, boolean HR)
	{
		this.ID = ID;
		this.Name = Name;
		this.Password = Password;
		this.Director = Director;
		this.HR = HR;
	}
	
	private static List<Staffs> StaffName = new ArrayList<Staffs>();
	//public static List<String> Password = new ArrayList<String>();
	
	public static void StaffForDemo()
	{
		StaffName.add(new Staffs(1, "HR", "hr", false, true));
		StaffName.add(new Staffs(2, "Michael", "michael", true, false));
		StaffName.add(new Staffs(3, "Joe", "joe", false, false));
		StaffName.add(new Staffs(4, "Peter", "peter", false, false));
	}
	
	public static int CheckInt(String ID)
	{
		int StaffId;
		try
		{
			StaffId = Integer.parseInt(ID);
		}
		catch(Exception e)
		{
			StaffId = 0;
		}
		
		return StaffId;
	}
	
	public static int CreateStaff(String name, String password)
	{
		int StaffID = 1;
		if (StaffName.size() != 0)
			StaffID = StaffName.get(StaffName.size() - 1).getID() + 1;
		StaffName.add(new Staffs(StaffID, name, password, false, false));
		return StaffID;
	}
	
	public static String GetStaffNameByID(int staffid)
	{
		String Name = null;
		for (int i = 0; i < StaffName.size(); i++)
			if (StaffName.get(i).getID() == staffid)
			{
				Name = StaffName.get(i).getName();
				return Name;
			}
		return Name;
	}
	
	public static int CreateDirector(String name, String password)
	{
		int StaffID = 1;
		if (StaffName.size() != 0)
			StaffID = StaffName.get(StaffName.size() - 1).getID() + 1;
		StaffName.add(new Staffs(StaffID, name, password, true, false));
		return StaffID;
	}
	
	public static ArrayList<String> GetAllStaffsWithID ()
	{
		ArrayList<String> AllStaffsWithID = new ArrayList<String>();
		for (int i = 0; i < StaffName.size(); i++)
			if (!StaffName.get(i).isHR())
				AllStaffsWithID.add(StaffName.get(i).getName() + 
						"(" + StaffName.get(i).getID() + ")");
		return AllStaffsWithID;
	}
	
	public static boolean StaffExist(int id)
	{
		for( int i = 0; i < StaffName.size(); i++ )
		{
			if(StaffName.get(i).getID() == id)
				return true;									
		}
		return false;
	}
	
	public static boolean CheckPassword(int staffid, String password)
	{
		for( int i = 0; i < StaffName.size(); i++ )
		{
			if(StaffName.get(i).getID() == staffid)
				if (new String(StaffName.get(i).getPassword()).equals(password))
					return true;
		}
		return false;
	}
	
	public static boolean IsDirector(int id)
	{
		for( int i = 0; i < StaffName.size(); i++ )
		{
			if(StaffName.get(i).getID() == id)
				if (StaffName.get(i).isDirector())
					return true;									
		}
		return false;
	}
	
	public static boolean IsHR(int id)
	{
		for( int i = 0; i < StaffName.size(); i++ )
		{
			if(StaffName.get(i).getID() == id)
				if (StaffName.get(i).isHR())
					return true;									
		}
		return false;
	}
	
	public static void DeleteStaff(String name)
	{
		for( int i = 0; i < StaffName.size(); i++ )
		{
			if(new String(StaffName.get(i).getName() + 
        			"(" + StaffName.get(i).getID() + ")").equals(name))
			{
				StaffName.remove(i);
				return;
			}
		}
	}
	
	public static ArrayList<String> StaffsDoNotHaveSupervios()
	{	
		List<Staffs> StaffRemoveDirectorandHR = new ArrayList<Staffs>();
		// RemoveDirector
		for (int i = 0; i < StaffName.size(); i++)
			if(!StaffName.get(i).isDirector() && !StaffName.get(i).isHR())
				StaffRemoveDirectorandHR.add(StaffName.get(i));
		ArrayList<String> StaffsDoNotHaveSupervios = new ArrayList<String>();
		
		for( int i = 0; i < StaffRemoveDirectorandHR.size(); i++ )
			if (StaffRelationship.FindDirectSuperviosr(StaffRemoveDirectorandHR.get(i).getID()) == 0)
			StaffsDoNotHaveSupervios.add(StaffRemoveDirectorandHR.get(i).Name + 
					"(" + StaffRemoveDirectorandHR.get(i).ID + ")");
		
		return StaffsDoNotHaveSupervios;
	}
}

