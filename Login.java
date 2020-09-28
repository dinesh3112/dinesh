import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.io.*;

public class Login implements ActionListener
{
	JButton b1,b2,b3;
	JTextField jt,jt1;
	Login(String s)
   {
    JFrame f=new JFrame("Login Window");
    
    JTextField jt=new JTextField(s);
    jt.setBounds(200,50,120,50);
    JTextField jt1=new JTextField(s);
    jt1.setBounds(200,150,120,50);
    
    JButton b1=new JButton("Mobile number");
    JButton b2=new JButton("password");
    JButton b3=new JButton("Login");
    b1.setBounds(40,50,120,50);
    b2.setBounds(40,150,120,50);
    b3.setBounds(120,250,120,60);
    
    f.add(b1);
    b1.addActionListener(this);
    f.add(b2);
    b2.addActionListener(this);
    f.add(b3);
    b3.addActionListener(this);
    f.add(jt);
    f.add(jt1);
    
    
    f.setLayout(null);
    f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    f.setSize(500,500);
    f.setVisible(true);    
}
   public void actionPerformed(ActionEvent e)
   {
	    if(e.getSource()==b1)
	    	jt.setText("Mobile number");
	    if(e.getSource()==b2)
	    	jt1.setText("Password");
	    if(e.getSource()==b2)
	    	jt1.setText("Login");
		  try { 
			  Class.forName("com.mysql.jdbc.Driver");
			  Connection c=DriverManager.getConnection("jdbc:mysql://localhost/ducat22","dinesh","dinesh");
			   Statement s1=c.createStatement();
			   ResultSet result1=s1.executeQuery("select * from user");
			   while(result1.next())
			   {
			    System.out.println(result1.getInt("Name")+"="+result1.getString(2));
				}
			   }catch(SQLException e1)
			   { 
			    System.out.println(e1);
				}
				catch(Exception i)
				{
				 System.out.println(i);
				 } 

			  if(e.getActionCommand().equals("Login"));
			  {
				 // new LoginUser();
				  System.out.println("WELCOME");	
			  }
			 
   }
   
   public static void main(String... ss)
   {
	    new Login(" ");
	 //   new Sframe1("swing frame");
   }
}



















