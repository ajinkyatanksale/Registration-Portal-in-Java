package com.project;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

public class Texteditor extends JFrame implements ItemListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JMenuBar mb;
	JMenu file,font;
	JMenuItem save,open,new1,quit;
	JRadioButtonMenuItem arial,monospace,serif;
	JCheckBoxMenuItem bold,italic;
	JToolBar tb;
	JTextArea ta;
	JScrollPane sc;
	JButton btnopen,btnsave,btnnew;
	Container contentpane;
	public Texteditor()
	{
		//menu bar
		Font f = new Font("monospace", Font.PLAIN, 18);
		UIManager.put("Menu.font", f);
		UIManager.put("MenuItem.font", f);
		mb=new JMenuBar();
		contentpane=this.getContentPane();
		contentpane.setLayout(new BorderLayout());
		mb.setBackground(new Color(255,255,204));
		setJMenuBar(mb);
		
		//menus
		file=new JMenu("File");
		file.setMnemonic('F');
		font=new JMenu("Font");
		save=new JMenuItem("Save");
		open=new JMenuItem("Open");
		quit=new JMenuItem("Quit");
		new1=new JMenuItem("New");
		bold=new JCheckBoxMenuItem("Bold");
		italic=new JCheckBoxMenuItem("Italic");
		arial=new JRadioButtonMenuItem("Arial");
		serif=new JRadioButtonMenuItem("Serif");
		monospace=new JRadioButtonMenuItem("monospaced");
		
		//tool bar
		tb=new JToolBar(JToolBar.VERTICAL);
		tb.setBackground(new Color(255,255,153));
		btnopen=new JButton(new ImageIcon("folder.gif"));
		btnsave=new JButton(new ImageIcon("patch.gif"));
		btnnew=new JButton(new ImageIcon("generic.gif"));
		
		//text area
		ta=new JTextArea();
		
		//scroll bar
		sc=new JScrollPane(ta,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		contentpane.add(BorderLayout.CENTER,sc);
		
		//adding everything to content pane
		mb.add(file);
		mb.add(font);
		file.add(new1);
		file.add(open);
		file.add(save);
		file.add(quit);
		font.add(bold);
		font.add(italic);font.add(serif);font.add(monospace);
		font.add(arial);
		
		//making the radio buttons single select
		ButtonGroup bg=new ButtonGroup();
		bg.add(monospace);
		bg.add(arial);
		bg.add(serif);
		
		//adding the tool bar to the content pane
		contentpane.add(BorderLayout.WEST,tb);
		tb.add(btnnew);
		btnnew.setToolTipText("new");
		tb.add(btnopen);
		btnopen.setToolTipText("open");
		tb.add(btnsave);
		btnsave.setToolTipText("save");
		
		ta.setFont(new Font("NEW ROMAN",Font.PLAIN, 18));
		
		//adding action to open menu
		
		open.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					open();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		//adding action to save menu
		save.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					save();
				} catch (Exception e) {
					
					e.printStackTrace();
				}
			}
		});
		
		//adding action to open button
		btnopen.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					open();
				} catch (Exception e) {
					
					e.printStackTrace();
				}
			}
		});
		
		//adding action to save button
		btnsave.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					save();
				} catch (Exception e) {
					
					e.printStackTrace();
				}
			}
		});
		
		//adding action to new button
		btnnew.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					newf();
				} catch (Exception e) {
					
					e.printStackTrace();
				}
			}
		});
		
		//adding action to new menu
		new1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					newf();
				} catch (Exception e) {
					
					e.printStackTrace();
				}
			}
		});
		
		//adding action to quit menu
		quit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				System.exit(0);
			}
		});
		
		bold.addItemListener(this);
		italic.addItemListener(this);
		
		//adding action to serif radio button
		serif.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				ta.setFont(new Font("SERIF",Font.PLAIN, 25));
				
			}
		});

		
		//adding action to monospace radio button
		monospace.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				ta.setFont(new Font("MONOSPACE",Font.PLAIN, 25));
				
			}
		});

		//adding action to arial radio button
		arial.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				ta.setFont(new Font("ARIAL",Font.PLAIN, 25));
				
			}
		});

	}
	
		//defining function for open 
		public void open()throws Exception
	{
		JFileChooser fc=new JFileChooser(".");
		int i=fc.showOpenDialog(this);
				if(i==JFileChooser.APPROVE_OPTION)
		{
			File f=fc.getSelectedFile();
			//String filepath=f.getPath();
			
			BufferedReader br = new BufferedReader(new FileReader(f));
			String c,b;
			c = br.readLine();
			while((b = br.readLine()) != null) {
				c = c+"\n"+b;
			}
			br.close();
			ta.setText(c);
		}
				
	}
		
		//defining function for save 
		public void save() throws Exception
		{
			JFileChooser fc=new JFileChooser(".");
			
			int i=fc.showSaveDialog(this);
			
			if(i==JFileChooser.APPROVE_OPTION)
			{
				File f=fc.getSelectedFile();
				BufferedWriter bw = new BufferedWriter(new FileWriter(f));
				bw.write(ta.getText());
				bw.flush();
				bw.close();
			}
		}
		
		//defining function for new 
		public void newf() {
			ta.setText("  ");
		}
		
		//adding action for bold and italic
		
		@Override
		public void itemStateChanged(ItemEvent e) {
			if(bold.isSelected())
			{
			ta.setFont(new Font ("",Font.BOLD,20));
			}else {ta.setFont(new Font ("",Font.PLAIN,20));}


			if(bold.isSelected())
			{
			ta.setFont(new Font ("",Font.BOLD,20));
			if(italic.isSelected())
			ta.setFont(new Font ("",Font.BOLD+Font.ITALIC,20));
			else if(bold.isSelected())
			{
			ta.setFont(new Font("",Font.BOLD,20));
			if(italic.isSelected())
			ta.setFont(new Font("",Font.ITALIC,20));
			}

			else {ta.setFont(new Font ("",Font.PLAIN,20));}
			}
			else if(italic.isSelected())
			{
			ta.setFont(new Font ("",Font.ITALIC,20));
			if(bold.isSelected())
			ta.setFont(new Font ("",Font.BOLD+Font.ITALIC,20));

			else if(italic.isSelected())
			{
			ta.setFont(new Font("",Font.ITALIC,20));
			if(bold.isSelected())
			ta.setFont(new Font("",Font.BOLD,20));
			}

			else {ta.setFont(new Font ("",Font.PLAIN,20));}
			}
				
		}
}


