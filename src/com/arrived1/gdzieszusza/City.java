package com.arrived1.gdzieszusza;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
	private Vector<Police> data;
	private Parser parser = new Parser();
	
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
	    HttpResponse response = httpClient.execute(httpGet, localContext);
        BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

	    String line = null;
	    while ((line = reader.readLine()) != null) {
	    	webPageBuffor += line + "\n";
	    }
//	     System.out.println("DUPA, " + webPage.length());
//	     System.out.println("DUPA, " + webPage.toString());
	}
	 
	public String getWebPage() {
		if(webPageBuffor.length() < 1)
			return "Pusto mam!!!";
		return webPageBuffor;
	}
	 
	public String getName() {
		return name;
	}
}