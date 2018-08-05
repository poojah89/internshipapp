package packagePooja;
import com.mysql.*;
import com.mysql.cj.jdbc.PreparedStatementWrapper;
//import com.mysql.jdbc.PreparedStatement;

import packagePooja.FrameTwo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class FrameTwo implements ActionListener {
	
	JFrame f1=new JFrame("Add");
	public JTextField tf;
	public JTextField tf1;
	public JButton b4;
	public JButton b5;
	public JLabel l3;
	public JLabel l4;
	public FrameTwo()
	{
	
	tf=new JTextField();
	tf1=new JTextField("yyyy-mm-dd");
	b4=new JButton("Submit");
	b5=new JButton("Add_Another");
	b4.addActionListener(this);
	l3=new JLabel("Event_Name");
	l4=new JLabel("Event_Date");
	tf.setBounds(110, 30, 200, 30);
	tf1.setBounds(110,70,200,30);
	b4.setBounds(110,120,200,30);
	b5.setBounds(110,150,200,30);
	l3.setBounds(0,30,100,30);
	l4.setBounds(50,70,100,30);
	b5.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent evt)
		{
			f1.dispose();
			new FrameTwo();
		}
	});
	
	f1.add(tf);
	f1.add(tf1);
	f1.add(b4);
	f1.add(b5);
	f1.add(l3);
	f1.add(l4);
	f1.setSize(400,400);
	f1.setVisible(true);
	
}
	public void actionPerformed(ActionEvent evt) {
		String str=tf.getText();
		String str1=tf1.getText();
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/reminder","root","root");
			java.sql.PreparedStatement st=(PreparedStatementWrapper) con.prepareStatement("insert into event_details values(?,?)");
			System.out.println("Connection Established");
			st.setString(1, str);
			st.setString(2, str1);
			int count=st.executeUpdate();
			if(count>0)
			{
				JOptionPane.showMessageDialog(f1,"Added Successfully");
			}
			con.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
	}
	
}




