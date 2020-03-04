package com.project;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Register extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	JMenuBar mb;
	JMenu master,help;
	JMenuItem nstudent, search, help1, about, update ;
	JLabel label;
	

 	Container ctp;
	public Register() {
		ctp = this.getContentPane();
		
		label = new JLabel("Registration");
		Font f2 = new Font("arial", Font.BOLD, 22);
		label.setFont(f2);
		label.setBounds(115,20,150,30);
		
		
		
		Font f = new Font("calibri", Font.PLAIN, 18);
		UIManager.put("Menu.font", f);
		UIManager.put("MenuItem.font", f);
		mb=new JMenuBar();
		ctp.setLayout(new BorderLayout());
		mb.setBackground(new Color(255,255,204));
		setJMenuBar(mb);
		
		master=new JMenu("Master");
		master.setMnemonic('M');
		help=new JMenu("Help");
		nstudent=new JMenuItem("New Student");
		search=new JMenuItem("Search");
		help1=new JMenuItem("Help");
		about=new JMenuItem("About us");
		update = new JMenuItem("Update");
		ctp.add(label);
		mb.add(master);
		mb.add(help);
		master.add(nstudent);
		master.add(search);
		master.add(update);
		help.add(help1);
		help.add(about);
		
		ctp.setLayout(null);
		
		nstudent.addActionListener(this);
		search.addActionListener(this);
		help1.addActionListener(this);
		about.addActionListener(this);
		update.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == nstudent) {
			
			 Newstudent nw = new Newstudent();
			 nw.setVisible(true);
			 nw.setSize(400,600);
			 nw.setTitle("New Registration");
			

   		}
		
		if(ae.getSource() == search) {
			
			Search nw = new Search();
			nw.setVisible(true);
			nw.setSize(400,500);
			nw.setTitle("Search");
			
		
		}
		
		if(ae.getSource() == help1) {
			help hp = new help();
			hp.setVisible(true);
			hp.setSize(400,200);
			hp.setTitle("Help");
		}

		if(ae.getSource() == about) {
			about ab = new about();
			ab.setVisible(true);
			ab.setSize(400,200);
			ab.setTitle("About Us");
			
		}
		
		if(ae.getSource() == update) {
			Search1 s1;
				s1 = new Search1();
				s1.setSize(400, 600);
				s1.setLocationRelativeTo(null);
				s1.setVisible(true);
			
			
			
			
			
		
		}

		
	}
	
	public static void main(String args[]) throws IOException, SQLException {
		Register l = new Register();
		l.setVisible(true);
		l.setSize(400,200);
		l.setTitle("Registration System");
		l.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
}
 class about extends JFrame{
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel a;
	 Container cmp;
	 public about() {
		cmp = this.getContentPane();
		a = new JLabel("This is our information");
		
		a.setBounds(50,60,150,30);
		cmp.add(a);
		cmp.setLayout(null);
	 }
 }
 
 class help extends JFrame{
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel a;
	 Container cmp;
	 public help() {
		cmp = this.getContentPane();
		a = new JLabel("You can reffer for help here");
		
		a.setBounds(50,60,150,30);
		cmp.add(a);
		cmp.setLayout(null);
	 }
 }
 
  class Search1 extends JFrame implements ActionListener {
 	/**
 	 * 
 	 */
 	private static final long serialVersionUID = 1L;
 	Container cpt2;
 	JLabel ent;
 	JTextField name;
 	JRadioButton sbn, sbr;
 	JButton search;
 	JButton submit;
 	JTable jt;
 	String column[] = { "Reg No.", "Name", "Age", "Gender" };
 	String row[][] = new String[1][column.length];
 	String name1, reg, dept, s;
 	
 	public Search1() {
 		cpt2 = this.getContentPane();
 		ent = new JLabel("Enter the name or registration No.");
 		name = new JTextField(40);
 		sbn = new JRadioButton("Search By Name");
 		sbr = new JRadioButton("Search By Reg. No.");
 		search = new JButton("Search");
 		submit = new JButton("Submit");
 		jt = new JTable(row, column);		
 		ent.setBounds(50,20,200,30);
 		name.setBounds(50,60,150,30);
 		sbn.setBounds(50,100,150,30);
 	    sbr.setBounds(50,140,150,30);
 	    search.setBounds(50,180,100,30);
 	    
 	    cpt2.add(ent);
 	    cpt2.add(name);
 	    cpt2.add(sbn);
 	    cpt2.add(sbr);
 	    cpt2.add(search);
 	    jt.add(submit);
 	    
 		cpt2.setLayout(null);
 		search.addActionListener(this);
 		submit.addActionListener(this);
 		

 		
 	}

 	

 	@Override
 	public void actionPerformed(ActionEvent ae) {
 		if(ae.getSource()==search) {
 			try {
 				
 	            Connection conn = null;
 	    		PreparedStatement ps = null;
 	    		ResultSet rs = null;
 	    		
 	    		String url = "jdbc:mysql://localhost:3306/ajinkya1db";
 	    		String user = "root";
 	    		String pass = "";
 	    		DriverManager.registerDriver(new com.mysql.jdbc.Driver());
 	    		
 	    		conn = DriverManager.getConnection(url, user, pass);
 	    		if(sbn.isSelected()==true) {
 	    		
 	    		ps = conn.prepareStatement("SELECT regno, age, gender FROM STUDENT WHERE name = ?");
 	    		String a = name.getText();
 	    		ps.setString(1, name.getText());
 	    	
 	    		rs = ps.executeQuery();
 	    		
 	    		while(rs.next()) {
 	    			String name=rs.getString(1);
 		    	    String age=rs.getString(2);
 		    	    String gender=rs.getString(3);
                     
 		    	      
 		    	    
 					
 					Update u = new Update();
 					u.setSize(400, 600);
 					u.setLocationRelativeTo(null);
 					u.setVisible(true);

 					
 					}

 	    		}
 	    		
 	    		
 	    		if(sbr.isSelected()==true) {
 		    		
 		    		ps = conn.prepareStatement("SELECT name, age, gender FROM STUDENT WHERE regno = ?");
 		    		String a = name.getText();
 		    		ps.setString(1, name.getText());
 		    	
 		    		rs = ps.executeQuery();
 		    		
 		    		while(rs.next()) {
 		    			String name=rs.getString(1);
 			    	    String age=rs.getString(2);
 			    	    String gender=rs.getString(3);
                         
 			    	      
 			    	    
 						
 						
 						Update u = new Update();
 	 					u.setSize(400, 600);
 	 					u.setLocationRelativeTo(null);
 	 					u.setVisible(true);


 		    		}
 		    		} 
 			}			    		
 	            catch (SQLException e1) {
 	                e1.printStackTrace();
 	            }
 		 
 			}
 			
 			
 			
 		}
 		
 	}

