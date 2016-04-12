package HumanResource;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

public class HomePage extends JFrame {

    public HomePage() {
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
        centerPanel.add(new JLabel("UserID", SwingConstants.RIGHT));
        final JTextField usernameTextField = new JTextField("", 20);
        centerPanel.add(usernameTextField);
        centerPanel.add(new JPanel());
        centerPanel.add(new JLabel("Password", SwingConstants.RIGHT));
        final JTextField passwordTextField = new JTextField("", 20);
        centerPanel.add(passwordTextField);
        centerPanel.add(new JPanel());
        centerPanel.add(new JPanel());
        JButton Loginbutton = new JButton("Login");
        Loginbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int userid = Staffs.CheckInt(usernameTextField.getText());
                if (userid == 0)
                	JOptionPane.showMessageDialog(HomePage.this, "UserId must be Integer!");
                else if (Staffs.StaffExist(userid))
                {
                	if(Staffs.CheckPassword(userid, passwordTextField.getText()))
                	{
                		if(Staffs.IsHR(userid))
                		{
                			new HR();
                			dispose();
                		}
                		else
                		{
		                	Login.CurrentLogin(Integer.parseInt(usernameTextField.getText()));
		                	new Deault();
		                	dispose();
                		}
                	}
                	else
                		JOptionPane.showMessageDialog(HomePage.this, "Wrong username or password!");
                }
                else
                	JOptionPane.showMessageDialog(HomePage.this, "User do not exist!");
            }
        });
        centerPanel.add(Loginbutton);
        centerPanel.add(new JPanel());
        for (int i = 0; i < 9; i++) {
            centerPanel.add(new JPanel());
        }
        aPanel.add(centerPanel, BorderLayout.CENTER);

        this.add(aPanel);
        this.setVisible(true);
    }
}