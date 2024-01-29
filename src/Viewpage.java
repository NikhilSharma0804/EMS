import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.sql.*;

import javax.swing.*;

import net.proteanit.sql.DbUtils;

public class Viewpage implements ActionListener {
	JFrame frame = new JFrame("Employee Management System");
	JLabel Lab1 = new JLabel("Employee Management System");
	JTable table = new JTable();
	JLabel Search = new JLabel("Search Employee by id:");
	Choice choi;
	JButton search, print, update, back = new JButton();

	public Viewpage()

	{
		frame.setLayout(null);
		frame.setSize(1600, 600);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setBackground(Color.white);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addComponents();
	}

	private void addComponents() {
		// code to add label "Emoployee management System"
		Lab1.setBounds(380, 10, 800, 70);

		Lab1.setFont(new Font("San_serif", Font.BOLD, 50));
		Lab1.setForeground(Color.red);
		frame.add(Lab1);
		// code to search
		Search.setBounds(20, 100, 200, 40);
		frame.add(Search);
		Search.setFont(new Font("Serif", Font.PLAIN, 18));
		// code for choice
		choi = new Choice();
		choi.setBounds(240, 110, 100, 40);
		frame.add(choi);
		// code for search buttons
		search = new JButton("Search");
		search.setBounds(400, 110, 80, 20);
		search.addActionListener(this);
		frame.add(search);
		// code for update buttons
		update = new JButton("Update");
		update.setBounds(500, 110, 80, 20);
		update.addActionListener(this);
		frame.add(update);
		// code for print button
		print = new JButton("Print");
		print.setBounds(600, 110, 80, 20);
		print.addActionListener(this);
		frame.add(print);

		// code for back button
		back = new JButton("Back");
		back.setBounds(700, 110, 80, 20);
		back.addActionListener(this);
		frame.add(back);

		// code for choice enter in empid
		try {
			Conn c = new Conn();
			ResultSet rs = c.s.executeQuery("Select * from employee");

			while (rs.next()) {
				choi.add(rs.getString("Eid"));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		// code to create table
		try {
			Conn c = new Conn();
			ResultSet rs = c.s.executeQuery("Select * from employee");
			table.setModel(DbUtils.resultSetToTableModel(rs));
			while (rs.next()) {
				choi.add(rs.getString("Eid"));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		JScrollPane jsp = new JScrollPane(table);
        table.setCellEditor(null);
		jsp.setBounds(14, 150, 1500, 500);
		frame.add(jsp);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == search) {

			String query = "Select *from employee where Eid ='" + choi.getSelectedItem() + "' ";
			try {
				Conn conn = new Conn();
				ResultSet rs = conn.s.executeQuery(query);
				table.setModel(DbUtils.resultSetToTableModel(rs));

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		} else if (e.getSource() == update) 
		{
             new Updateemployee(choi.getSelectedItem());
             frame.setVisible(false);
		} else if (e.getSource() == print) {
			try {
				table.print();
				frame.setVisible(false);
			} catch (PrinterException e1) {
				
				e1.printStackTrace();
			}

		} else {
			new Home();
			frame.setVisible(false);
			frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		}

	}

	public static void main(String[] args) {
		new Viewpage();
	}
}
