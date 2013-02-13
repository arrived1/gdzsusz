package com.arrived1.gdzieszusza;

import java.util.Date;
import java.util.Vector;

public class Parser {
	private Vector<Police> data = new Vector<Police>();
	
	public void parse(String txt) {
		String line = "";
		String[] splitedTxt = txt.split(" ");
		
		boolean reading = false;
		for(int i = 0; i < splitedTxt.length; i++) {
			if(splitedTxt[i].equals("<body>")) {
				reading = true;
				continue;
			}
			if(splitedTxt[i].equals("</body>")) {
				reading = false;
			}
			
			if(reading == true) {
				System.out.println("DUPA, Parser czytam: " + splitedTxt[i]);
				if(splitedTxt[i].equals("<br>")) {
//					analizeLine(line);
					line = "";
					continue;
				}
			
				String tmp = splitedTxt[i] + " ";
				line = line + tmp; 
			}
		}
	}
	
	private void analizeLine(String line) {
		String[] splitedLine = line.split(" ");
		
		String dateString = splitedLine[0];
		String streetString = splitedLine[1];
		
		String[] splitedDateString = dateString.split(".");
		
		String day = splitedDateString[0];
		String month = splitedDateString[1];
		String year = splitedDateString[2];


		Date date = new Date(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
		Police police = new Police(streetString, date);
		
		data.addElement(police);
	}
	
	public Vector<Police> getData() {
		return data;
	}
}
