package HumanResource;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;


public class Deault extends JFrame
{
	public Deault() 
	{
        super("COMP5134 Project");
        this.setSize(800, 500);
        this.setLocation(100, 100);

        JPanel aPanel = new JPanel(new BorderLayout());
        JPanel topPanel = new JPanel();
        topPanel.add(new JLabel("COMP5134 Project"));
        aPanel.add(topPanel, BorderLayout.NORTH);
        JPanel centerPanel = new JPanel(new GridLayout(10, 3, 5, 10));
        int staffid = Login.getCurrentLogin();
        if(Staffs.IsDirector(staffid))
        {
        	for (int i = 0; i < 12; i++) {
	            centerPanel.add(new JPanel());
	        }
        	centerPanel.add(new JPanel());
        }
        else
        {
	        for (int i = 0; i < 6; i++) {
	            centerPanel.add(new JPanel());
	        }
	        centerPanel.add(new JLabel("FromDate", SwingConstants.RIGHT));
	        final JTextField FromDateText = new JTextField("", 20);
	        centerPanel.add(FromDateText);
	        centerPanel.add(new JPanel());
	        centerPanel.add(new JLabel("ToDate", SwingConstants.RIGHT));
	        final JTextField ToDateText = new JTextField("", 20);
	        centerPanel.add(ToDateText);
	        centerPanel.add(new JPanel());
	        centerPanel.add(new JPanel());
	        JButton Application = new JButton("Apply Leave");
	        Application.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	Date FromDate = LeaveApplication.StringtoDateTime(FromDateText.getText());
	            	Date ToDate = LeaveApplication.StringtoDateTime(ToDateText.getText());
	                if (FromDate == null || ToDate == null)
	                	JOptionPane.showMessageDialog(Deault.this, "Please enter valid Date.");
	                else if (FromDate.after(ToDate)) 
	                	JOptionPane.showMessageDialog(Deault.this, "FromDate must be equal or smaller than ToDate.");
	                else
	                {
	                	int ID = LeaveApplication.ApplyLeave(staffid, StaffRelationship.FindDirectSuperviosr(staffid), FromDate, ToDate);
	                	JOptionPane.showMessageDialog(Deault.this, "Application ID = " + ID + " Submitted!");
	                }
	                	
	            }
	        });
	        centerPanel.add(Application);
	        centerPanel.add(new JPanel());
	        centerPanel.add(new JPanel());
	        JButton ApplicationResult = new JButton("Application Result");
	        ApplicationResult.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	List<String> Result = new ArrayList<String>();
	            	Result = LeaveApplication.NotfiyApplier(staffid);
	            	if (Result.size() != 0)
	            	{
		            	for (int i = 0; i < Result.size(); i++)
		            		JOptionPane.showMessageDialog(Deault.this, Result.get(i));
	            	}
	            	else
	            		JOptionPane.showMessageDialog(Deault.this, "You have not apply leave or the application is pending.");
	            }
	        });
	        centerPanel.add(ApplicationResult);
	        centerPanel.add(new JPanel());
	        centerPanel.add(new JPanel());
        }
        JButton PendingApplication = new JButton("Pending Application");
        PendingApplication.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	Object[] options = {"endorse", "decline"};
            	List<String> Pending = new ArrayList<String>();
            	Pending = LeaveApplication.GetApplication(staffid);
            	if (Pending.size() != 0)
            		for (int i = 0; i < Pending.size(); i = i + 2)
            		{
            			int result = JOptionPane.showOptionDialog(Deault.this, Pending.get(i), "Pending Application",
            					JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
            			if (result == 0)
            				LeaveApplication.ProcessApplication(Integer.parseInt(Pending.get(i + 1)),staffid ,true);
            			else
            				LeaveApplication.ProcessApplication(Integer.parseInt(Pending.get(i + 1)),staffid ,false);
            		}
            	else
            		JOptionPane.showMessageDialog(Deault.this, "You do not have any application to approve!");
            }
        });
        centerPanel.add(PendingApplication);
        centerPanel.add(new JPanel());
        centerPanel.add(new JPanel());
        JButton Loginoff = new JButton("Login off");
        Loginoff.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	new HomePage();
            	dispose();
            }
            });
        centerPanel.add(Loginoff);
        centerPanel.add(new JPanel());
        for (int i = 0; i < 6; i++) {
            centerPanel.add(new JPanel());
        }
        
        aPanel.add(centerPanel, BorderLayout.CENTER);
        
        this.add(aPanel);
        this.setVisible(true);
	}

}
