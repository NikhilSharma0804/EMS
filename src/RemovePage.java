import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.*;

public class RemovePage implements ActionListener {
	JFrame frame = new JFrame("Employee Management System");
	JButton btn = new JButton("Remove");
	JButton back = new JButton("Back");
	JButton search=new JButton("Search");
	JLabel label = new JLabel("Employee Management System");
	JLabel userName = new JLabel("Employee UserName:");
	JLabel Mobile = new JLabel("Employee Mobile Number:");
	JLabel mobile = new JLabel();
	JLabel name = new JLabel();
	JLabel Email = new JLabel();
	JLabel mail = new JLabel("Employee Email:");
	Choice cEID = new Choice();
	JLabel EID = new JLabel("Employee Eid:");
	JLabel LEID = new JLabel();

	public RemovePage()

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
		btn.setBounds(330, 320, 150, 40);
		btn.setFont(new Font("serif", Font.PLAIN, 25));
		btn.setForeground(Color.blue);
	
		back.setBounds(150, 320, 150, 40);
		back.setFont(new Font("serif", Font.PLAIN, 25));
		back.setForeground(Color.blue);
		back.addActionListener(this);
      frame.add(back);
		frame.add(btn);
		// code to add label "Employee Management System
		label.setBounds(50, 40, 700, 60);
		label.setFont(new Font("serif", Font.BOLD, 50));
		label.setForeground(Color.red);

		frame.add(label);
		//// Code to add usrname label
		userName.setBounds(30, 200, 180, 40);
		userName.setFont(new Font("Arial", Font.PLAIN, 18));
		userName.setForeground(Color.black);
		frame.add(userName);
		// for the field
		name.setBounds(280, 200, 200, 40);
		frame.add(name);
		// code to add user password
		Mobile.setBounds(30, 240, 220, 40);
		Mobile.setFont(new Font("Arial", Font.PLAIN, 18));
		Mobile.setForeground(Color.black);
		frame.add(Mobile);
		mobile.setBounds(280, 240, 200, 40);
		frame.add(mobile);
		
            //code for mail

		mail.setBounds(30, 280, 150, 40);
		mail.setFont(new Font("Arial", Font.PLAIN, 18));
		mail.setForeground(Color.black);
		frame.add(mail);
		Email.setBounds(280, 280, 200, 40);
		frame.add(Email);
		// code for employee id
		EID.setBounds(30, 160, 150, 40);
		EID.setFont(new Font("Arial", Font.PLAIN, 18));
		EID.setForeground(Color.black);
		frame.add(EID);
		cEID.setBounds(40,130,100,40);
		frame.add(cEID);
		LEID.setBounds(280, 160, 200, 40);
		frame.add(LEID);
		//code for search button
		search.setBounds(150,130,100,40);
		frame.add(search);
		search.addActionListener(this);
		try {
			Conn c=new Conn();
			String query="Select * from employee";
			ResultSet rs=c.s.executeQuery(query);
			while (rs.next())
			{
			cEID.add(rs.getString("EID"));	
			}
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		
	}

	public void actionPerformed(ActionEvent ae) {
		
		if(ae.getSource()==search) {
			try {
			Conn c=new Conn();
			String query="Select * from employee where EID='"+cEID.getSelectedItem()+"'";
			ResultSet rs=c.s.executeQuery(query);
			while (rs.next())
			{
			  name.setText(rs.getString("Name"));
			  mobile.setText(rs.getString("MobileNumber"));
              Email.setText(rs.getString("Email"));
             LEID.setText(rs.getString("EID"));
			}
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
			
		}else if(ae.getSource()==btn){
		try {
			Conn c = new Conn();
			String query = "Delete from employee where EID='"+cEID.getSelectedItem()+"'";

			 c.s.executeUpdate(query);
				JOptionPane.showMessageDialog(null, "Employee deleted");
               frame.setVisible(false);
               new Home();
			}
		 catch (Exception ex) {

		}
		}else 
		{
			frame.setVisible(false);
			new Home();
			
		}
	}

	public static void main(String[] args) {
		new RemovePage();
	}

}
