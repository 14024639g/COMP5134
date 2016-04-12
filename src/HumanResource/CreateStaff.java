package HumanResource;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class CreateStaff extends JFrame{
	 public CreateStaff() {
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
	        centerPanel.add(new JLabel("StaffName", SwingConstants.RIGHT));
	        final JTextField usernameTextField = new JTextField("", 20);
	        centerPanel.add(usernameTextField);
	        centerPanel.add(new JPanel());
	        centerPanel.add(new JLabel("Password", SwingConstants.RIGHT));
	        final JTextField passwordTextField = new JTextField("", 20);
	        centerPanel.add(passwordTextField);   
	        centerPanel.add(new JPanel());
	        centerPanel.add(new JPanel());
	        JCheckBox checkBox = new JCheckBox("Director");
	        centerPanel.add(checkBox);   
	        centerPanel.add(new JPanel());
	        centerPanel.add(new JPanel());
	        JButton Createbutton = new JButton("Create");
	        Createbutton.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	if (usernameTextField.getText().length() != 0 && passwordTextField.getText().length() != 0)
	            	{
	            		int StaffID;
	            		if (checkBox.isSelected())
	            			StaffID = Staffs.CreateDirector(usernameTextField.getText(),passwordTextField.getText());
	            		else
	            			StaffID = Staffs.CreateStaff(usernameTextField.getText(),passwordTextField.getText());
	            		
	            		JOptionPane.showMessageDialog(CreateStaff.this, usernameTextField.getText() + " Created! "
	            				+ "StaffID = " + "(" + StaffID + ")");
	            		new HR();
		            	dispose();
	            	}
	            	else
	            		JOptionPane.showMessageDialog(CreateStaff.this, "Please input the StaffName and Password!");
	            }
	            });
	        centerPanel.add(Createbutton);
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
