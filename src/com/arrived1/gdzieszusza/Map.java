package com.arrived1.gdzieszusza;

import android.app.Activity;
import android.os.Bundle;

import com.google.ads.AdRequest;
import com.google.ads.AdView;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
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
	    
	    addAdView();
	    
		map = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();
		 
		Bundle extras = getIntent().getExtras();
		latitude = extras.getDouble("GEO_POINT_LATITUDE");
	    longitude = extras.getDouble("GEO_POINT_LONGITUDE");
	
	    LatLng coordinates = new LatLng(latitude, longitude);
	    
	    MarkerOptions markOpt = new MarkerOptions();
	    markOpt.position(coordinates);
	  	markOpt.title("Title");
	  	markOpt.snippet("Snippet");
	  	markOpt.icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_launcher));
		map.addMarker(markOpt);
	
		map.moveCamera(CameraUpdateFactory.newLatLngZoom(coordinates, 15));
		map.animateCamera(CameraUpdateFactory.zoomTo(15), 2000, null);  
	}
	
	private void addAdView() {
		AdView ad = (AdView)findViewById(R.id.adView1);
		ad.loadAd(new AdRequest());
	}
}