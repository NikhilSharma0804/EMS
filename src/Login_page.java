import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.*;

public class Login_page implements ActionListener {
	JFrame frame = new JFrame("Employee Management System");
	JButton btn = new JButton("Login");
	JLabel label = new JLabel("Employee Management System");
	JLabel userName = new JLabel("Employee UserName:");
	JLabel UsrPassword = new JLabel("Employee Password:");
	JTextField name = new JTextField();
	JTextField pass = new JTextField();

	public Login_page()

	{
		btn.addActionListener(this);
		frame.setLayout(null);
		frame.setSize(800, 600);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setBackground(Color.white);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addComponents();
	}

	private void addComponents() {
		// Adding Login button
		btn.setBounds(280, 260, 200, 40);
		btn.setFont(new Font("serif", Font.PLAIN, 30));
		btn.setForeground(Color.blue);

		frame.add(btn);
		// code to add label "Employee Management System
		label.setBounds(50, 40, 700, 60);
		label.setFont(new Font("serif", Font.BOLD, 50));
		label.setForeground(Color.red);

		frame.add(label);
		//// Code to add usrname label
		userName.setBounds(30, 160, 250, 40);
		userName.setFont(new Font("Arial", Font.BOLD, 20));
		userName.setForeground(Color.black);
		frame.add(userName);
		// for the field
		name.setBounds(280, 160, 200, 40);
		frame.add(name);
		// code to add user password
		UsrPassword.setBounds(30, 200, 250, 40);
		UsrPassword.setFont(new Font("Arial", Font.BOLD, 20));
		UsrPassword.setForeground(Color.black);
		frame.add(UsrPassword);

		// for the pass field
		pass.setBounds(280, 200, 200, 40);
		frame.add(pass);

	}

	public void actionPerformed(ActionEvent ae) {
		try 
		{
			Conn c= new Conn();
			String username = name.getText();
			String password = pass.getText();
			String query = "select * from login where username='" + username + "' and  password ='" + password + "'";
             
			ResultSet rs=c.s.executeQuery(query);
			if(rs.next()) 
			{
				frame.setVisible(false);
				new Home();
			}else 
			{
            JOptionPane.showMessageDialog(null, "Invalid id and password");				
			
			}
		} catch (Exception ex) {
			
		}

	}

	public static void main(String[] args) {
		new Login_page();
	}

}
