package HumanResource;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HR extends JFrame{
	public HR() {
        super("COMP5134 Project");
        this.setSize(800, 500);
        this.setLocation(100, 100);

        JPanel aPanel = new JPanel(new BorderLayout());
        JPanel topPanel = new JPanel();
        topPanel.add(new JLabel("COMP5134 Project"));
        aPanel.add(topPanel, BorderLayout.NORTH);
        JPanel centerPanel = new JPanel(new GridLayout(10, 3, 5, 10));
        for (int i = 0; i < 4; i++) {
            centerPanel.add(new JPanel());
        }
        JButton Createbutton = new JButton("Create Staff");      
        Createbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	new CreateStaff();
            	dispose();
            }
            });
        centerPanel.add(Createbutton);
        centerPanel.add(new JPanel());
        centerPanel.add(new JPanel());
        JButton Detelebutton = new JButton("Detele Staff");      
        Detelebutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	new DeleteStaff();
            	dispose();
            }
            });
        centerPanel.add(Detelebutton);
        centerPanel.add(new JPanel());
        centerPanel.add(new JPanel());
        JButton Aissgnbutton = new JButton("Aissgn Staff to Supervisor");
        Aissgnbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	new AssignStaff();
            	dispose();
            }
            });
        centerPanel.add(Aissgnbutton);
        centerPanel.add(new JPanel());
        
        centerPanel.add(new JPanel());
        JButton Loginoff = new JButton("Login off");
        Loginoff.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	if(Staffs.StaffsDoNotHaveSupervios().size() == 0)
            	{
	            	new HomePage();
	            	dispose();
            	}
            	else
            		JOptionPane.showMessageDialog(HR.this, "All Staffs must have Supervisor");
            }
            });
        centerPanel.add(Loginoff);
        centerPanel.add(new JPanel());
        for (int i = 0; i < 9; i++) {
            centerPanel.add(new JPanel());
        }
        
        aPanel.add(centerPanel, BorderLayout.CENTER);
        
        this.add(aPanel);
        this.setVisible(true);
	}
}
