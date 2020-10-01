import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.io.*;

public class LoginUser implements ActionListener 
{
	JLabel b1,b2,b3,l;
	JButton b4;
	JTextField jt1,jt2;
	JPanel panel;
	LoginUser(String s)
   {
    JFrame f=new JFrame(s);
    
    JLabel l=new  JLabel("1000");
    l.setBounds(200,50,120,50);
    JTextField jt1=new JTextField(s);
    jt1.setBounds(200,150,120,50);
    JTextField jt2=new JTextField(s);
    jt2.setBounds(200,250,120,50);
    
    
    JLabel b1=new JLabel("Wallet");
    JLabel b2=new JLabel("TransferMoney");
    JLabel b3=new JLabel("Mobile_Number");
    JButton b4=new JButton("View_Statement");
    b1.setBounds(40,50,120,50);
    b2.setBounds(40,150,120,50);
    b3.setBounds(40,250,120,50);
    b4.setBounds(120,250,120,60);
    
    panel=new JPanel(new GridLayout(3,1));
    panel.add(b1);
    panel.add(b2);
    panel.add(b3);
    panel.add(b4);
    b4.add(panel,BorderLayout.CENTER);
    b4.addActionListener(this);
    
    
    f.add(b1); 
    f.add(b2);
    f.add(b3);
    f.add(b4);
    b4.addActionListener(this);
    f.add(l);
    f.add(jt1);
    f.add(jt2);
    f.add(panel);
    
    
    f.setLayout(null);
    f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    f.setSize(500,500);
    f.setVisible(true);    
}
   public void actionPerformed(ActionEvent e)
   {
	    if(e.getSource()==b4)
		  try { 
			  Class.forName("oracle.jdbc.driver.OracleDriver");
			   Connection c=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","p.w:manager");
			   Statement s=c.createStatement();
			
			   PreparedStatement ps =c.prepareStatement("insert into user values(?,?)");  
               ps.setString(1,jt1.getText());  
               ps.setString(2,jt2.getText());  
               int x=ps.executeUpdate();  
               if(e.getActionCommand().equals("View_Statement"));
 			  {
               ps=c.prepareStatement("select * from user");
               ResultSet result1=ps.executeQuery();
			   while(result1.next())
			   {
				   System.out.println("Mobile_Number" +result1.getInt(1));
				   System.out.println("password" +result1.getString(2));
				}
 			  }
 			  ps.close();
 			  c.close();
			   }catch(SQLException e1)
			   { 
			    System.out.println(e1);
				}
				catch(Exception i)
				{
				 System.out.println(i);
				 } 

			  if(e.getActionCommand().equals("View_Statement"));
			  {
	              
			  }
		
   }
   
   public static void main(String... ss)
   {
	    new Login(" ");
	 //   new Sframe1("swing frame");
   }
}
