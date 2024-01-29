import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.*;

public class SearchPage implements ActionListener {
	JFrame frame = new JFrame("Employee Management System");
	JLabel Fname = new JLabel();
	JLabel Mname = new JLabel();
	JLabel salary = new JLabel();
	JLabel desig = new JLabel();
	JLabel address = new JLabel();
	JLabel Dob=new JLabel();
	JLabel fname = new JLabel("5)Father's name:");
	JLabel mname = new JLabel("6) Mother's name:");
	JLabel DOB = new JLabel("7) Dob:");
	JLabel sal = new JLabel("8) Salary:");
	JLabel AD = new JLabel("9) Address:");
	JLabel des = new JLabel("10) Designation:");
	JButton back = new JButton("Back");
	JButton search=new JButton("Search");
	JLabel label = new JLabel("Employee Management System");
	JLabel userName = new JLabel("2.Employee UserName:");
	JLabel Mobile = new JLabel("3.Employee Mobile Number:");
	JLabel mobile = new JLabel();
	JLabel name = new JLabel();
	JLabel Email = new JLabel();
	JLabel mail = new JLabel("4.Employee Email:");
	Choice cEID = new Choice();
	JLabel EID = new JLabel("1.Employee Eid:");
	JLabel LEID = new JLabel();

	public SearchPage()

	{
		
		frame.setLayout(null);
		frame.setSize(800, 700);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setBackground(Color.white);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addComponents();
	}

	private void addComponents() {
		
		//back button
		back.setBounds(350, 570, 100, 40);
		back.setFont(new Font("serif", Font.PLAIN, 25));
		back.setForeground(Color.blue);
		back.addActionListener(this);
		frame.add(back);
       
		
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
		//Code to add father name
		fname.setBounds(30, 320, 150, 40);
		fname.setFont(new Font("Arial", Font.PLAIN, 18));
		fname.setForeground(Color.black);
		frame.add(fname);
		Fname.setBounds(280, 320, 200, 40);
		frame.add(Fname);
		//cod to add mother name 
		mname.setBounds(30, 360, 150, 40);
		mname.setFont(new Font("Arial", Font.PLAIN, 18));
		mname.setForeground(Color.black);
		frame.add(mname);
		Mname.setBounds(280, 360, 200, 40);
		frame.add(Mname);
		//code to add DOB
		DOB.setBounds(30, 400, 150, 40);
		DOB.setFont(new Font("Arial", Font.PLAIN, 18));
		DOB.setForeground(Color.black);
		frame.add(DOB);
		Dob.setBounds(280, 400, 200, 40);
		frame.add(Dob);
		//code to add salary
		sal.setBounds(30, 440, 150, 40);
		sal.setFont(new Font("Arial", Font.PLAIN, 18));
		sal.setForeground(Color.black);
		frame.add(sal);
		salary.setBounds(280, 440, 200, 40);
		frame.add(salary);
		//code for address
		AD.setBounds(30, 480, 150, 40);
		AD.setFont(new Font("Arial", Font.PLAIN, 18));
		AD.setForeground(Color.black);
		frame.add(AD);
		address.setBounds(280, 480, 200, 40);
		frame.add(address);
		//code for designation
		des.setBounds(30, 520, 150, 40);
		des.setFont(new Font("Arial", Font.PLAIN, 18));
		des.setForeground(Color.black);
		frame.add(des);
		desig.setBounds(280, 520, 200, 40);
		frame.add(desig);
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
		search.setBounds(150,130,100,20);
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
             salary.setText(rs.getString("Salary"));
             address.setText(rs.getString("Address"));
             Dob.setText(rs.getString("DateOfBirth"));
             Fname.setText(rs.getString("FatherName"));
             Mname.setText(rs.getString("MotherName"));
             desig.setText(rs.getString("Designation"));
			}
			
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
			
		
		}else 
		{
			frame.setVisible(false);
			new Home();
			
		}
	}

	public static void main(String[] args) {
		new SearchPage();
	}

}
