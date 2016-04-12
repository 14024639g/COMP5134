package HumanResource;

import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AssignStaff extends JFrame{
	 public AssignStaff() {
	        super("COMP5134 Project");
	        this.setSize(800, 500);
	        this.setLocation(100, 100);

	        JPanel aPanel = new JPanel(new BorderLayout());
	        JPanel topPanel = new JPanel();
	        topPanel.add(new JLabel("COMP5134 Project"));
	        aPanel.add(topPanel, BorderLayout.NORTH);
	        JPanel centerPanel = new JPanel(new GridLayout(10, 3, 5, 10));
	        for (int i = 0; i < 6; i++) {
	            centerPanel.add(new JPanel());
	        }
	        centerPanel.add(new JLabel("Staff", SwingConstants.RIGHT));
	        ArrayList<String> StaffsDoNotHaveSupervios = Staffs.StaffsDoNotHaveSupervios();
	        String[] StaffChoices = StaffsDoNotHaveSupervios.toArray(new String[0]);
	        final JComboBox<String> StaffComboBox = new JComboBox<String>(StaffChoices);
	        centerPanel.add(StaffComboBox);
	        centerPanel.add(new JPanel());
	        centerPanel.add(new JLabel("Supervisor", SwingConstants.RIGHT));
	        String[] Supervisor = Staffs.GetAllStaffsWithID().toArray(new String[0]);
	        final JComboBox<String> SupervisorComboBox = new JComboBox<String>(Supervisor);
	        centerPanel.add(SupervisorComboBox);
	        centerPanel.add(new JPanel());
	        centerPanel.add(new JPanel());
	        JButton Aissgnbutton = new JButton("Aissgn");
	        Aissgnbutton.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	String[] StaffID = StaffComboBox.getSelectedItem().toString().split("[\\(||\\)]");
	        		String[] SupervisorID = SupervisorComboBox.getSelectedItem().toString().split("[\\(||\\)]");
	            	if (Integer.parseInt(StaffID[1]) != Integer.parseInt(SupervisorID[1]))
	            	{
	            		if (StaffRelationship.FindStaffBySuperviosrID(Integer.parseInt(StaffID[1])) != Integer.parseInt(SupervisorID[1]))
	            		{
		            		StaffRelationship.CreateRelationship(Integer.parseInt(StaffID[1]),Integer.parseInt(SupervisorID[1]));
		            		JOptionPane.showMessageDialog(AssignStaff.this, "Aissgned");
		            		new HR();
		            		dispose();
	            		}
	            		else
	            			JOptionPane.showMessageDialog(AssignStaff.this, StaffComboBox.getSelectedItem().toString() + " is the Supervisor of " + SupervisorComboBox.getSelectedItem());
	            	}
	            	else
	            		JOptionPane.showMessageDialog(AssignStaff.this, "Staff and Supervisor cannot be same!");
	            }
	            });
	        centerPanel.add(Aissgnbutton);
	        centerPanel.add(new JPanel());
	        centerPanel.add(new JPanel());
	        JButton Back = new JButton("Back");
	        Back.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	new HR();
	            	dispose();
	            }
	            });
	        centerPanel.add(Back);
	        centerPanel.add(new JPanel());
	        for (int i = 0; i < 9; i++) {
	            centerPanel.add(new JPanel());
	        }
	        aPanel.add(centerPanel, BorderLayout.CENTER);
	        
	        this.add(aPanel);
	        this.setVisible(true);
	 }
}


