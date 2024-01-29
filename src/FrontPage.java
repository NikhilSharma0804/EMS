import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class FrontPage implements ActionListener {
	JFrame frame = new JFrame("Employee Management System");
	JButton btn = new JButton("Click to Continue!");
	JLabel label = new JLabel("Employee Management System");

	public FrontPage()

	{
		frame.setLayout(null);
		frame.setSize(800, 600);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setBackground(Color.white);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addComponents();
	}

	private void addComponents() {
		btn.setBounds(180, 260, 400, 100);
		btn.setFont(new Font("serif", Font.PLAIN, 30));
		btn.setForeground(Color.blue);
		btn.addActionListener(this);
		frame.add(btn);
		
		label.setBounds(50, 40, 700, 60);
		label.setFont(new Font("serif", Font.BOLD, 50));
		label.setForeground(Color.red);

		frame.add(label);
		blinkLabel();
	}

	private void blinkLabel() {
		while (true) {
		
			try {

				Thread.sleep(5);
			} catch (Exception ex) {

			}

			label.setVisible(true);
		}
	}

	public void actionPerformed(ActionEvent e) 
	{
             frame.setVisible(false);
             new Login_page();
	}

	public static void main(String[] args) {
		new FrontPage();
	}
}
