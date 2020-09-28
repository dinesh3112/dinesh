import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.io.*;

public class SignUp implements ActionListener
{
	
	JButton b,b1,b2,b3;
	JTextField jt,jt1,jt2;
	SignUp(String s)
   {
    JFrame f=new JFrame("SignUp Window");
    
    JTextField jt=new JTextField(s);
    jt.setBounds(200,50,120,50);
    JTextField jt1=new JTextField(s);
    jt1.setBounds(200,150,120,50);
    JTextField jt2=new JTextField(s);
    jt2.setBounds(200,250,120,50);
    
    JButton b=new JButton("Full_Name");
    JButton b1=new JButton("Mobile_Number");
    JButton b2=new JButton("password");
    JButton b3=new JButton("Submit");
    b.setBounds(40,50,120,50);
    b1.setBounds(40,150,120,50);
    b2.setBounds(40,250,120,50);
    b3.setBounds(120,350,120,60);
    
    f.add(b);
    b.addActionListener(this);
    f.add(b1);
    b1.addActionListener(this);
    f.add(b2);
    b2.addActionListener(this);
    f.add(b3);
    b3.addActionListener(this);
    f.add(jt);
    f.add(jt1);
    f.add(jt2);
    
    
    f.setLayout(null);
    f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    f.setSize(500,500);
    f.setVisible(true);    
}
   public void actionPerformed(ActionEvent e)
   { 
	   if(e.getSource()==b3	)
	   {
     
		  try {
			  Class.forName("oracle.jdbc.driver.OracleDriver");
              Connection c=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","p.w:manager");
			   Statement s=c.createStatement();
			   s.executeUpdate("create table SignUp(Full_Name varchar(20),Mobile_Number int(10),password varchar(10))");
			   s.close();
			   PreparedStatement ps = c.prepareStatement("insert into SignUp values(?,?,?)");  
               ps.setString(1,jt.getText());  
               ps.setString(2,jt1.getText());  
               ps.setString(3,jt2.getText()); 
               
               
               int x=ps.executeUpdate();  
               ps.close();
               ps=c.prepareStatement("select * from user");
               ResultSet result1=ps.executeQuery();
               while(result1.next())																	   
               {
                System.out.println("Full_Name" +result1.getString(1));
                System.out.println("Mobile_Number" +result1.getInt(2));
                System.out.println("password" +result1.getString(3));
                }
		         
               if (x > 0)   
               {  
                   JOptionPane.showMessageDialog(b3, "Registration Successfully");  
               }  
           }  
           catch (Exception ex)   
           {  
               System.out.println(ex);  
           }  
       }         
			  if(e.getActionCommand().equals("Submit"));
			  {   
				  
					new Login(null);
					  System.out.println("WELCOME");
			  }
   }
   public static void main(String... ss)
   {
	    new SignUp("");
	 //   new Sframe1("swing frame");
   }
}
    
   
   
   
   
   
   


   
   
   
   
   
   
   
   
   
   
