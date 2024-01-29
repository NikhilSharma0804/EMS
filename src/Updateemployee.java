import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Random;
import javax.swing.*;

public class Updateemployee implements ActionListener {
	Random rd = new Random();
	int number = rd.nextInt(9999);
	JFrame frame = new JFrame("Employee Management System");
	JButton back = new JButton("Back");
	JButton btn = new JButton("Update Employee");
	JLabel Full_name = new JLabel("1) Full name:");
	JLabel fname = new JLabel("2) Father's name:");
	JLabel mname = new JLabel("3) Mother's name:");
	JLabel DOB = new JLabel("4) Dob:");
	JLabel sal = new JLabel("5) Salary:");
	JLabel AD = new JLabel("6) Address:");
	JLabel des = new JLabel("7) Designation:");
	JLabel phone = new JLabel("8) Mobile Number :");
	JLabel email = new JLabel("9) E-mail :");
	JLabel edu = new JLabel("10) Education :");

	JLabel Lab1 = new JLabel("Employee Management System");
	JLabel Lab2 = new JLabel(" Update new Employee ");
	JLabel name = new JLabel();
	JTextField Fname = new JTextField();
	JTextField Mname = new JTextField();
	JTextField salary = new JTextField();
	JTextField desig = new JTextField();
	JTextField address = new JTextField();
	JTextField mobile = new JTextField();
	JLabel mail = new JLabel();
	JLabel dob = new JLabel();
	JTextField edul = new JTextField();
	JLabel En = new JLabel("" + number);
	String Eid;

	public Updateemployee(String Eid)

	{
		this.Eid = Eid;
		btn.addActionListener(this);
		frame.setSize(1200, 600);
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setBackground(Color.white);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addComponents();
		// code to get data from viewpage
		try {
			Conn c = new Conn();
			String query = "Select *from employee where Eid='" + Eid + "'";
			ResultSet rs = c.s.executeQuery(query);
			while (rs.next()) {
				name.setText(rs.getString("Name"));
				dob.setText(rs.getString("DateOfBirth"));
				Fname.setText(rs.getString("FatherName"));
				Mname.setText(rs.getString("MotherName"));
				salary.setText(rs.getString("Salary"));
				desig.setText(rs.getString("Designation"));
				address.setText(rs.getString("Address"));
				mobile.setText(rs.getString("MobileNumber"));
				mail.setText(rs.getString("Email"));
				edul.setText(rs.getString("Education"));
				En.setText(rs.getString("Eid"));

			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private void addComponents() {
		// code for employee id
		JLabel EID = new JLabel("Employee id:");
		EID.setBounds(20, 100, 150, 30);
		EID.setFont(new Font("Serif", Font.BOLD, 18));
		frame.add(EID);

		En.setBounds(170, 100, 150, 30);
		En.setFont(new Font("Serif", Font.BOLD, 18));
		frame.add(En);

		// code for label "Employee Management System"
		Lab1.setBounds(230, 10, 800, 70);
		Lab1.setFont(new Font("San_serif", Font.BOLD, 50));
		Lab1.setForeground(Color.red);
		frame.add(Lab1);
		// code to add label2
		Lab2.setBounds(450, 90, 400, 40);
		Lab2.setFont(new Font("San_serif", Font.BOLD, 30));
		Lab2.setForeground(Color.blue);
		frame.add(Lab2);
		// code for btn
		btn.setBounds(490, 460, 150, 30);
		btn.setFont(new Font("raleway", Font.PLAIN, 18));
		btn.setForeground(Color.blue);
		btn.addActionListener(this);
		frame.add(btn);

		back.setBounds(280, 460, 150, 30);
		back.setFont(new Font("Serif", Font.BOLD, 18));
		back.setForeground(Color.blue);
		back.addActionListener(this);
		frame.add(back);
		// code to add label add
		Full_name.setBounds(10, 180, 150, 40);
		Full_name.setFont(new Font("Arial", Font.PLAIN, 20));
		frame.add(Full_name);
		name.setBounds(180, 180, 250, 40);
		name.setFont(new Font("San_serif", Font.BOLD, 18));
		frame.add(name);
		// code to write father name
		Fname.setBounds(180, 230, 250, 40);
		Fname.setFont(new Font("San_serif", Font.BOLD, 18));
		frame.add(Fname);
		fname.setBounds(10, 230, 200, 40);
		fname.setFont(new Font("Arial", Font.PLAIN, 20));
		frame.add(fname);

		// code to write mothr name
		Mname.setBounds(180, 280, 250, 40);
		Mname.setFont(new Font("San_serif", Font.BOLD, 18));
		frame.add(Mname);
		mname.setBounds(10, 280, 250, 40);
		mname.setFont(new Font("Arial", Font.PLAIN, 20));
		frame.add(mname);
		// code for dob
		dob.setBounds(180, 330, 250, 40);
		dob.setFont(new Font("San_serif", Font.BOLD, 18));
		frame.add(dob);
		DOB.setBounds(10, 330, 250, 40);
		DOB.setFont(new Font("Arial", Font.PLAIN, 20));
		frame.add(DOB);
		// code to add salary
		salary.setBounds(180, 380, 250, 40);
		salary.setFont(new Font("San_serif", Font.BOLD, 18));
		frame.add(salary);
		sal.setBounds(10, 380, 250, 40);
		sal.setFont(new Font("Arial", Font.PLAIN, 20));
		frame.add(sal);
		// code to add address
		address.setBounds(850, 180, 250, 40);
		address.setFont(new Font("San_serif", Font.BOLD, 18));
		frame.add(address);
		AD.setBounds(650, 180, 250, 40);
		AD.setFont(new Font("Arial", Font.PLAIN, 22));
		frame.add(AD);
//code to add designantion
		desig.setBounds(850, 230, 250, 40);
		desig.setFont(new Font("San_serif", Font.BOLD, 18));
		frame.add(desig);
		des.setBounds(650, 230, 250, 40);
		des.setFont(new Font("Arial", Font.PLAIN, 22));
		frame.add(des);
		// code to add mobile numbr
		mobile.setBounds(850, 280, 250, 40);
		mobile.setFont(new Font("San_serif", Font.BOLD, 18));
		frame.add(mobile);
		phone.setBounds(650, 280, 250, 40);
		phone.setFont(new Font("Arial", Font.PLAIN, 22));
		frame.add(phone);
///code to add email
		mail.setBounds(850, 330, 250, 40);
		mail.setFont(new Font("San_serif", Font.BOLD, 18));
		frame.add(mail);
		email.setBounds(650, 330, 250, 40);
		email.setFont(new Font("Arial", Font.PLAIN, 22));
		frame.add(email);
		// code to add education
		JLabel edu = new JLabel("10) Education :");

		edu.setBounds(650, 380, 250, 40);
		edu.setFont(new Font("Arial", Font.PLAIN, 22));
		frame.add(edu);

		edul.setFont(new Font("San_serif", Font.BOLD, 18));
		edul.setBounds(850, 380, 250, 40);
		frame.add(edul);

	}

	public void actionPerformed(ActionEvent ae) {

		if (ae.getSource() == btn) {

			String phone = mobile.getText();
			String addres = address.getText();
			String gmail = mail.getText();
			String fname = Fname.getText();
			String mname = Mname.getText();
			String educ = edul.getText();
			String design = desig.getText();
			String salar = salary.getText();
			String Eid=En.getText();

			try {
				Conn conn = new Conn();
				String query = "update employee set FatherName='" + fname + "',MotherName='" + mname
						+ "',Education='" + educ + "',Designation='" + design + "',Salary='" + salar + "',MobileNumber='" + phone + "',Address='" + addres + "',Email='" + gmail
						+ "' where Eid='"+Eid+"'";

				conn.s.executeUpdate(query);
				JOptionPane.showMessageDialog(null, "Updated Successfully");
				frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				
				frame.setVisible(false);
				
				
				
			} catch (Exception ex) {
				ex.printStackTrace();
			}

		} else {
			new Home();
			frame.setVisible(false);

		}
		

	}

	public static void main(String[] args) {
		new Updateemployee("");
	}

}
