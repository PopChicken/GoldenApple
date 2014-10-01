package com.GoldenApple.UI.dialogue;

import javax.swing.JOptionPane;

import com.GoldenApple.UI.UI;

public class Error implements UI{
	
	public Error(int errorLevel, String title, String ms){
		this.log(errorLevel, title, ms);
	}

	private void log(int errorLevel, String title, String ms) {
		JOptionPane.showMessageDialog(null, ms, title, JOptionPane.ERROR_MESSAGE);
	}

}