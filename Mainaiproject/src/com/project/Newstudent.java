package com.project;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
public class Newstudent extends JFrame implements ActionListener {
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Container cpt1;
	 JTextField name;
	 JTextField age;
	 JTextField regno;
	 JRadioButton male, female;
	 JLabel ulabel;
	 JLabel plabel;
	 JLabel reglabel;
	 JLabel glabel;
	 JButton btnlogin;
	 JButton btnreset;

	public Newstudent() {
	   
		cpt1 = this.getContentPane();
		ulabel = new JLabel("Name: ");
		name = new JTextField(20);
		plabel =new JLabel("Age: ");
		reglabel = new JLabel("Reg. No.: ");
		glabel = new JLabel("gender: ");
		regno = new JTextField(20);
		male = new JRadioButton("male");
		female = new JRadioButton("female");
		
		age = new JTextField(20);
		btnlogin = new JButton("Login>>");
		btnreset = new JButton("Reset>>");
		ulabel.setBounds(50,70,100,30);
	    plabel.setBounds(50,110,100,30);
	    reglabel.setBounds(50,150,100,30);
	    glabel.setBounds(50,190,100,30);
	    name.setBounds(150,70,150,30);
	    age.setBounds(150,110,150,30);
	    regno.setBounds(150,150,150,30);
	    male.setBounds(150,190,150,30);
	    female.setBounds(150,210,150,30);
	    btnlogin.setBounds(50,250,100,30);
	    btnreset.setBounds(200,250,100,30);
	   
	    cpt1.add(ulabel);
	    cpt1.add(name);
	    cpt1.add(plabel);		
	    cpt1.add(age);
	    cpt1.add(reglabel);
	    cpt1.add(glabel);
	    cpt1.add(regno);
	    cpt1.add(male);
	    cpt1.add(female);
	    cpt1.add(btnlogin);
	    cpt1.add(btnreset);
	    
	    cpt1.setLayout(null);
	    
	    btnlogin.addActionListener(this);
	    btnreset.addActionListener(this);
	}
			

	@Override
	public void actionPerformed(ActionEvent ae) {
			
			if(ae.getSource() == btnlogin) { 
				
		
		try {
				String gender=null;
				if(male.isSelected()==true) {
				gender = "male";
				}
				else if(female.isSelected()==true) {
				gender = "female";
				}
	            Connection conn = null;
	    		PreparedStatement ps = null;
	    		
	    		String url = "jdbc:mysql://localhost:3306/ajinkya1db";
	    		String user = "root";
	    		String pass = "";
	    		DriverManager.registerDriver(new com.mysql.jdbc.Driver());
	    		
	    		conn = DriverManager.getConnection(url, user, pass);
	    		ps = conn.prepareStatement("INSERT INTO STUDENT VALUES(?,?,?,?)");
	    		ps.setString(1, regno.getText());
	    		ps.setString(2, name.getText());
	    		ps.setString(3, age.getText());
	    		ps.setString(4, gender);
	    		int i = ps.executeUpdate();
	    		
	    		 
	    		if(i!=0)
	    		{
	    		JOptionPane.showMessageDialog(null,"Successfully Registered");
	    		 
	    		}
	    		else
	    		{
	    		JOptionPane.showMessageDialog(null, "Not Registered");
	    		}
	    		}
	            catch (SQLException e1) {
	                e1.printStackTrace();
	            }
		 
			}
			else if (ae.getSource() == btnreset) {
	            name.setText(null);
	            age.setText(null);
	            regno.setText(null);
	            
	        }
		
	
	
	}
			
}