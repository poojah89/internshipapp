/**
 * 
 */
package packagePooja;
import java.util.*;
import java.util.Date;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

//import com.mysql.jdbc.PreparedStatement;

import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;

/**
 * @author Pooja
 *
 */
public class Firstdisplay1 implements ActionListener{
	
	
	

	
			
			JFrame f=new JFrame();
			JButton b,b1,b2;
			JLabel l;
			static JTextField tf;
			static JTextField tf1;
			DefaultTableModel model=new DefaultTableModel(new String[] {"Event-Name","Event-date"},0);
			Firstdisplay1()
			{
				//f.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				f=new JFrame("Reminder Tool");
				 b=new JButton("Add_Reminder");
				 b1=new JButton("View_Reminder");
				 b2=new JButton("Update_Reminder");
				l=new JLabel("REMINDER");
				l.setBounds(120,10,100,200);
				b.setBounds(50, 150, 200, 30);
				//b.addActionListener((ActionListener) this);
				b1.setBounds(50, 200, 200, 30);
				b2.setBounds(50,250,200,30);
				f.add(l);
				f.getContentPane().add(b);
				f.add(b1);
				f.add(b2);
				f.setSize(450,450);
				f.setLayout(null);
				f.setVisible(true);
				final JTable table = new JTable();
				table.setModel(model);
				table.setBounds(30,40,200,300);
				JScrollPane sp=new JScrollPane(table);
				b.addActionListener(this);
				b1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt)
					{
						try
						{
							Class.forName("com.mysql.jdbc.Driver");
							Connection con=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/reminder","root","root");
							Statement st=con.createStatement();
							System.out.println("Connection Established");
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
								String e=rs.getString("event_name");
								String d=rs.getString("event_date");
								model.addRow(new Object[] {e,d});
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
				b1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt)
					{
						//f.add(sp);
						JOptionPane.showMessageDialog(null,new JScrollPane(table));
						//f.setVisible(true);
					}
				});
				b2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt)
					{
						f.dispose();
						new FrameThree();
					}
				});
			}
			public void actionPerformed(ActionEvent evt)
			{
				f.dispose();
				FrameTwo sf=new FrameTwo();
				Date date=new Date();
				SimpleDateFormat dateFormat=new SimpleDateFormat("dd/MM/yyyy");
				String strdate=dateFormat.format(date);
			}
				
				
				
			public static void main(String args[])
			{
				
			new Firstdisplay1();
			
			}
			/*@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
			}*/
			
	}




