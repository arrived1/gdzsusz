package com.arrived1.gdzieszusza;

import java.util.List;
import java.util.Locale;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.maps.GeoPoint;

public class Map extends Activity {
	public GeoPoint gp;
	public double latitude = 0;
	public double longitude = 0;
	private GoogleMap map;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	    setContentView(R.layout.map);
		map = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();
		 
		Bundle extras = getIntent().getExtras();
		latitude = extras.getDouble("GEO_POINT_LATITUDE");
	    longitude = extras.getDouble("GEO_POINT_LONGITUDE");
	
	    System.out.println("DUPA Map przesylam geopoint, putExtra!!! latitude: " + latitude);
	    System.out.println("DUPA Map przesylam geopoint, putExtra!!! longitude: " + longitude);
	
	    LatLng coordinates = new LatLng(latitude, longitude);
		Marker street = map.addMarker(
				  new MarkerOptions()
				  	.position(coordinates)
				  	.title("DUPA")
				  	.snippet("Kiel is cool")
				  	.icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_launcher))
				  	);
	
		map.moveCamera(CameraUpdateFactory.newLatLngZoom(coordinates, 15));
		map.animateCamera(CameraUpdateFactory.zoomTo(10), 2000, null);  
  }
}