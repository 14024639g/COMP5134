package HumanResource;

import java.util.*;
import javax.swing.*;


public class StaffRelationship {
	
	private int StaffID;
	private int SuperviosrID;
	
	public int getStaffID() {
		return StaffID;
	}

	public void setStaffID(int staffID) {
		StaffID = staffID;
	}

	public int getSuperviosrID() {
		return SuperviosrID;
	}

	public void setSuperviosrID(int superviosrID) {
		SuperviosrID = superviosrID;
	}
	
	public StaffRelationship(int StaffID, int SuperviosrID)
	{
		this.StaffID = StaffID;
		this.SuperviosrID = SuperviosrID;
	}
	
	private static List<StaffRelationship> StaffRelationshipTable = new ArrayList<StaffRelationship>();
	
	public static void CreateRelationship(int ID, int SuperviosrID)
	{
		StaffRelationshipTable.add(new StaffRelationship(ID, SuperviosrID));
	}
	
	public static int FindDirectSuperviosr(int staffid)
	{
		int SuperviosrID = 0;
		for (int i = 0; i < StaffRelationshipTable.size(); i++)
			if(StaffRelationshipTable.get(i).getStaffID() == staffid)
				SuperviosrID = StaffRelationshipTable.get(i).getSuperviosrID();
		
		return SuperviosrID;
	}
	
	public static int FindStaffBySuperviosrID(int superviosrid)
	{
		int StaffID = 0;
		for (int i = 0; i < StaffRelationshipTable.size(); i++)
			if(StaffRelationshipTable.get(i).getSuperviosrID() == superviosrid)
				StaffID = StaffRelationshipTable.get(i).getStaffID();
		
		return StaffID;
	}
	
	public static List<Integer> FindStaffWhohasSupervisor()
	{
		List<Integer> StaffWhohasSupervisor = new ArrayList<Integer>();
		for (int i = 0; i < StaffRelationshipTable.size(); i++)
			StaffWhohasSupervisor.add(StaffRelationshipTable.get(i).getStaffID());
		
		return StaffWhohasSupervisor;
	}


	
}
