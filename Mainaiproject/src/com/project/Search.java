package com.project;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;

public class Search extends JFrame implements ActionListener {
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
	
	public Search() {
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
                    
		    	      
		    	    jt.setValueAt(a, 0, 0);
					jt.setValueAt(name, 0, 1);
					jt.setValueAt(age, 0, 2);
					jt.setValueAt(gender, 0, 3);
					JFrame f = new JFrame();
					f.getContentPane();
					f.setTitle("Search result");
					f.setSize(500, 500);
					f.setLayout(new FlowLayout());
					f.add(new JScrollPane(jt));
					f.setVisible(true);
					f.add(submit);
					
					if (jt.getCellEditor() != null) {
						DefaultCellEditor cellEditor = (DefaultCellEditor) jt.getCellEditor();

						String value = ((JTextField) cellEditor.getComponent()).getText();
						int i = jt.getSelectedColumn();
						switch (i) {
						case 0:
							try {

								ps = conn.prepareStatement("UPDATE STUDENT SET regno=? WHERE regno=?");
								ps.setString(1, value);
								ps.setString(2, s);
								ps.executeUpdate();
							} catch (SQLException e1) {
								e1.printStackTrace();
							}
							break;
						case 1:
							try {

								ps = conn.prepareStatement("UPDATE STUDENT SET age=? WHERE regno=?");
								ps.setString(1, value);
								ps.setString(2, s);
								ps.executeUpdate();
							} catch (SQLException e1) {
								e1.printStackTrace();
							}
							break;
						case 2:
							try {

								String m = jt.getValueAt(0, 1).toString();
								ps = conn.prepareStatement("UPDATE STUDENT SET gender=? WHERE REGNO=?");
								ps.setString(1, value);
								ps.setString(2, m);
								ps.executeUpdate();
							} catch (SQLException e1) {
								e1.printStackTrace();
							}
							break;

						

						}

					}

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
                        
			    	      
			    	    jt.setValueAt(a, 0, 0);
						jt.setValueAt(name, 0, 1);
						jt.setValueAt(age, 0, 2);
						jt.setValueAt(gender, 0, 3);
						JFrame f = new JFrame();
						f.getContentPane();
						f.setTitle("Search result");
						f.setSize(500, 500);
						f.setLayout(new FlowLayout());
						f.add(new JScrollPane(jt));
						f.setVisible(true);
						f.add(submit);

		    		}
		    		} 
			}			    		
	            catch (SQLException e1) {
	                e1.printStackTrace();
	            }
		}
			if(ae.getSource()==submit) {
				JOptionPane.showMessageDialog(null,"Update Successfull");
			}
		 
			
			
			
			
		}
		
	}

