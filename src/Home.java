import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Home implements ActionListener {
	JFrame frame = new JFrame("Employee Management System");
	JButton btn_add = new JButton("ADD EMPLOYEE");
	JButton btn_remove = new JButton("REMOVE EMPLOYEE");
	JButton btn_search = new JButton("SEARCH EMPLOYEE");
	JButton btn_view = new JButton("VIEW EMPLOYEE");
	JButton btn_update = new JButton("UPDATE EMPLOYEE");
	JLabel Lab1 = new JLabel("Employee Management System");

	public Home()

	{

		frame.setLayout(null);
		frame.setSize(800, 630);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setBackground(Color.white);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addComponents();
	}

	private void addComponents() {

		// code to add label "Employee management System"
		Lab1.setBounds(10, 10, 800, 70);
		Lab1.setFont(new Font("Raleway", Font.BOLD, 50));
		Lab1.setForeground(Color.red);
		frame.add(Lab1);

		// code for buttons font
		btn_add.setFont(new Font("serif", Font.PLAIN, 20));
		btn_search.setFont(new Font("serif", Font.PLAIN, 20));
		btn_view.setFont(new Font("serif", Font.PLAIN, 20));
		btn_update.setFont(new Font("serif", Font.PLAIN, 20));
		btn_remove.setFont(new Font("serif", Font.PLAIN, 20));
		// code for add buttons
		btn_add.setBounds(10, 150, 380, 80);
		frame.add(btn_add);
		btn_add.addActionListener(this);
		// code for search buttons
		btn_search.setBounds(10, 250, 380, 80);
		frame.add(btn_search);
		btn_search.addActionListener(this);
		// code for view
		btn_view.setBounds(10, 350, 380, 80);
		frame.add(btn_view);
		btn_view.addActionListener(this);
		// code for update
		btn_update.setBounds(400, 150, 380, 80);
		frame.add(btn_update);
		btn_update.addActionListener(this);
		// code for remove
		btn_remove.setBounds(400, 250, 380, 80);
		frame.add(btn_remove);
		btn_remove.addActionListener(this);

	}

	public void actionPerformed(ActionEvent e) 
	{
       if(e.getSource()==btn_add) 
       {
    	   frame.setVisible(false);
    	   frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    	   new Add_employee();
       }
       else if(e.getSource()==btn_view) {
    	   frame.setVisible(false);
    	   frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);;
    	   new Viewpage();
    	   
       }else if(e.getSource()==btn_search) 
       {
    	   
       }else if(e.getSource()==btn_update)
       {
    	   new Viewpage();
    	   frame.setVisible(false);
       
    	   
       }
       else
       {
    	   frame.setVisible(false);
    	   new RemovePage();
       }
       
	}

	public static void main(String[] args) {
		new Home();
	}

}
