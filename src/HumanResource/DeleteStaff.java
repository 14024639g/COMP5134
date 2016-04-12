package HumanResource;

import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteStaff extends JFrame{
	 public DeleteStaff() {
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
	        centerPanel.add(new JPanel());
	        String[] StaffChoices = Staffs.GetAllStaffsWithID().toArray(new String[0]);
	        final JComboBox<String> StaffComboBox = new JComboBox<String>(StaffChoices);
	        centerPanel.add(StaffComboBox);
	        centerPanel.add(new JPanel());
	        centerPanel.add(new JPanel());
	        JButton Deletebutton = new JButton("Delete");
	        Deletebutton.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	Staffs.DeleteStaff(StaffComboBox.getSelectedItem().toString());
	            	JOptionPane.showMessageDialog(DeleteStaff.this, "Deleted!");
            		new HR();
	            	dispose();
	            }
	            });
	        centerPanel.add(Deletebutton);
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
