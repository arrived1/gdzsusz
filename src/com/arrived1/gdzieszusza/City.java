package com.arrived1.gdzieszusza;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
	private String webPage = "";
	
	City(String name_) {
		this.name = name_;
		
		String urlPage = "http://www.smwroclaw.pl/index.php/gdzie-jest-fotoradar/91-fotoradar/167-gdzie-mozna-spotkac-fotoradar";
		
		StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
		StrictMode.setThreadPolicy(policy); 
		
		try {
			getHtml();
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	 public void getHtml() throws ClientProtocolException, IOException
	 {
	     HttpClient httpClient = new DefaultHttpClient();
	     HttpContext localContext = new BasicHttpContext();
	     HttpGet httpGet = new HttpGet("http://www.smwroclaw.pl/index.php/gdzie-jest-fotoradar/91-fotoradar/167-gdzie-mozna-spotkac-fotoradar");
	     HttpResponse response = httpClient.execute(httpGet, localContext);

	     BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

	     String line = null;
	     while ((line = reader.readLine()) != null) {
	    	 webPage += line + "\n";
	     }
	     System.out.println("DUPA, " + webPage.length());
	     System.out.println("DUPA, " + webPage.toString());
	 }
	 
	 public String getWebPage() {
		 if(webPage.length() < 1)
			 return "Pusto mam!!!";
		 return webPage;
	 }
}
