package com.arrived1.gdzieszusza;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
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
				if(splitedTxt[i].equals("<br>")) {
					analizeLine(line);
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
		
		//TODO: dirtyHack for additional space in first element on the first call of the function
		if(splitedLine.length > 2) {
			dateString = splitedLine[1];
			streetString = splitedLine[2];
		}
		
		String[] splitedDateString = dateString.split("\\.");

		String day = splitedDateString[0];
		String month = splitedDateString[1];
		String year = splitedDateString[2];
		
		//TODO: month - 1, dirty hack b-cos months in GregorianCalendar are counted from 0 to 11....
		GregorianCalendar date = new GregorianCalendar(Integer.parseInt(year), Integer.parseInt(month) - 1, Integer.parseInt(day));
		Police police = new Police(streetString, date);
		
		data.addElement(police);
	}
	
	public Vector<Police> getData() {
		return data;
	}
}
