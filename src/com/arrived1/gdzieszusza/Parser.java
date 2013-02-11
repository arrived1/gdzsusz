package com.arrived1.gdzieszusza;

import java.util.Vector;

public class Parser {
	private Vector<Police> data = new Vector<Police>();
	
	public void parse(String txt) {
		String line = "";
		String[] dataLines;
		String[] splitedTxt = txt.split(" ");
		
		boolean reading = false;
		for(int i = 0; i < splitedTxt.length; i++) {
			if(splitedTxt[i] == "<body>")
				reading = true;
			if(splitedTxt[i] == "</body>")
				reading = false;
			
			if(reading) {
				if(splitedTxt[i] == "<br>") {
					analizeLine(line);
					line = "";
				}
				
				line += splitedTxt[i] + " ";
			}
		}
	}
	
	private void analizeLine(String line) {
		
	}
	
	public Vector<Police> getData() {
		return data;
	}
}
