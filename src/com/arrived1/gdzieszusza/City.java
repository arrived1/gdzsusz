package com.arrived1.gdzieszusza;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.GregorianCalendar;
import java.util.Vector;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;

import android.os.StrictMode;


public class City {
	private String name = "";
	private String webPageAdress = "";
	private String webPageBuffor = "";
	private Vector<Police> data = new Vector<Police>();
	private Parser parser = new Parser();
	
	
	City() {
		this.name = "Nieobsługiwane misto";
		this.webPageAdress = "http://www.apteka-zwycieska.pl/gdzieSusza/empty.html";
	}
	
	City(String name_, String webPageAdress_) {
		this.name = name_;
		this.webPageAdress = webPageAdress_;
		
		StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
		StrictMode.setThreadPolicy(policy); 
	
		try {
			getHtml();
			parser.parse(webPageBuffor);
			data = parser.getData();
		} 
		catch(ClientProtocolException e) {
			e.printStackTrace();
		} 
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	private void getHtml() throws ClientProtocolException, IOException
	{
	    HttpClient httpClient = new DefaultHttpClient();
	    HttpContext localContext = new BasicHttpContext();
	    HttpGet httpGet = new HttpGet(webPageAdress);
	    
	    //TODO when url do not exist it produce unknown exception !!!
	    HttpResponse response = httpClient.execute(httpGet, localContext);
        
	    BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        
	    String line = null;
	    while ((line = reader.readLine()) != null) {
	    	webPageBuffor += line + " ";
	    }
	}
	 
	public String getName() {
		return name;
	}
	
	public Vector<Police> getData() {
		return data;
	}
	
	public Vector<Police> getTodayData() {
		//TODO: its working correctly, remmember about dirtyhack with months
		Vector<Police> currentPolice = new Vector<Police>();
//		GregorianCalendar currentDate = new GregorianCalendar(2013, 2 - 1, 3); //TODO: only for tests, uncomment line below
		GregorianCalendar currentDateTmp = new GregorianCalendar();
		GregorianCalendar currentDate = new GregorianCalendar(
				currentDateTmp.get(currentDateTmp.YEAR), 
				currentDateTmp.get(currentDateTmp.MONTH), 
				currentDateTmp.get(currentDateTmp.DAY_OF_MONTH));
		
		for(int i = 0; i < data.size(); i++) {
			if(data.elementAt(i).date.getTimeInMillis() == currentDate.getTimeInMillis())
				currentPolice.addElement(data.elementAt(i));
		}
		return currentPolice;
	}
	
	public Vector<Police> getOtherDaysData() {
		//TODO: its working correctly, remmember about dirtyhack with months
		Vector<Police> currentPolice = new Vector<Police>();
//		GregorianCalendar tomorrowDate = new GregorianCalendar(2013, 2 - 1, 3 + 1); //TODO: only for tests, uncomment line below
		GregorianCalendar currentDate = new GregorianCalendar();
		GregorianCalendar tomorrowDate = new GregorianCalendar(
				currentDate.get(currentDate.YEAR), 
				currentDate.get(currentDate.MONTH), 
				currentDate.get(currentDate.DAY_OF_MONTH) + 1);
		
		for(int i = 0; i < data.size(); i++) {
			if(data.elementAt(i).date.getTimeInMillis() == tomorrowDate.getTimeInMillis())
				currentPolice.addElement(data.elementAt(i));
		}
		return currentPolice;
		
	}
}
