package com.project;

import java.io.IOException;
import java.sql.SQLException;

import javax.swing.JFrame;


public class Maineditor {
	public static void main(String args[]) throws IOException, SQLException {
		Texteditor l = new Texteditor();
		l.setVisible(true);
		l.setSize(1400,800);
		l.setTitle("AT Editor");
		l.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
