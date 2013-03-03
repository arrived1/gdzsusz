package com.arrived1.gdzieszusza;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import android.app.Activity;
import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
//import java.io.InputStream;
//import org.apache.http.HttpEntity;
//import org.apache.http.HttpResponse;
//import org.apache.http.client.ClientProtocolException;
//import org.apache.http.client.HttpClient;
//import org.apache.http.client.methods.HttpGet;
//import org.apache.http.impl.client.DefaultHttpClient;
//import org.json.JSONArray;
//import org.json.JSONException;
//import org.json.JSONObject;
//import com.google.android.maps.GeoPoint;

public class NetworkGeolocalizationCity {
	private String cityName = "Nieznane misto";
	
	public NetworkGeolocalizationCity(Context context, Activity activity) {
		
		List<Address> addresses = null;
		
		try {
			LocationListener listeneer = new LocationListenerMy();
			LocationManager locMgr = (LocationManager)context.getSystemService(Context.LOCATION_SERVICE);
			locMgr.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 20000, 1, listeneer);
			
			Location loc = locMgr.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
			Geocoder gcd = new Geocoder(context, Locale.getDefault());
			
			addresses = gcd.getFromLocation(loc.getLatitude(), loc.getLongitude(), 1);
			cityName = addresses.get(0).getLocality();
		} 
		catch (IOException e) {
			System.out.println("DUPA wyjatek");
			cityName = "Nieznane misto";
			e.printStackTrace();
		}
	}
	
	public String getCurrentCityName() {
			return cityName;
	}
	
//	public static JSONObject getLocationInfo(String address) {
//
//		HttpGet httpGet = new HttpGet("http://maps.google."
//				+ "com/maps/api/geocode/json?address=" + address
//				+ "ka&sensor=false");
//		HttpClient client = new DefaultHttpClient();
//		HttpResponse response;
//		StringBuilder stringBuilder = new StringBuilder();
//
//		try {
//			response = client.execute(httpGet);
//			HttpEntity entity = response.getEntity();
//			InputStream stream = entity.getContent();
//			int b;
//			while ((b = stream.read()) != -1) {
//				stringBuilder.append((char) b);
//			}
//		} catch (ClientProtocolException e) {
//		} catch (IOException e) {
//		}
//
//		JSONObject jsonObject = new JSONObject();
//		try {
//			jsonObject = new JSONObject(stringBuilder.toString());
//		} catch (JSONException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		return jsonObject;
//	}
//	
//	public static GeoPoint getGeoPoint(JSONObject jsonObject) {
//		Double lon = new Double(0);
//		Double lat = new Double(0);
//
//		try {
//
//			lon = ((JSONArray)jsonObject.get("results")).getJSONObject(0)
//				.getJSONObject("geometry").getJSONObject("location")
//				.getDouble("lng");
//
//			lat = ((JSONArray)jsonObject.get("results")).getJSONObject(0)
//				.getJSONObject("geometry").getJSONObject("location")
//				.getDouble("lat");
//
//		} catch (JSONException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		return new GeoPoint((int) (lat * 1E6), (int) (lon * 1E6));
//
//	}

}
