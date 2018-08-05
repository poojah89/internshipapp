/**
 * 
 */
package packagePooja;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.*;


/**
 * @author Pooja
 *
 */
public class FrameThree {
	
	JFrame f2=new JFrame("Update");
	public JTextField tf;
	public JTextField tf1;
	public JButton b1;
	public JLabel l1;
	FrameThree()
	{
	tf=new JTextField();
	tf1=new JTextField("yyyy-mm-dd");
	b1=new JButton("Update");
	l1=new JLabel("Event_Name");
	l1.setBounds(0,30,100,30);
	tf.setBounds(110, 30, 200, 30);
	tf1.setBounds(110,70,200,30);
	b1.setBounds(110,120,200,30);
	f2.add(l1);
	f2.add(tf);
	f2.add(tf1);
	f2.add(b1);
	f2.setSize(450,450);
	f2.setLayout(null);
	f2.setVisible(true);
	b1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent evt)
		{
			String str=tf.getText();
			String str1=tf1.getText();
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
				Connection con=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/reminder","root","root");
				PreparedStatement st=(PreparedStatement) con.prepareStatement("select * from event_details where event_name=?");
				System.out.println("Connection Established");
				st.setString(1, str);
				st.setString(2, str1);
				boolean b=st.execute("select * from event_details");
				ResultSet rs=null;
				
				if(b)
				{
					rs=st.getResultSet();
				}
				if(rs!=null)
				{
					while(rs.next())
					{
				int count=st.executeUpdate();
				if(count>0)
				{
					Statement st1=con.createStatement();
					st1.executeUpdate("update event_details set event_date='"+str1+"' where event_name='"+str+"'");
				}
				}
				}
				con.close();
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		}
	});
	}
	
	

	/*@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}*/
}




