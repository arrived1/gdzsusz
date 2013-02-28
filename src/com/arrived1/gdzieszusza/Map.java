package com.arrived1.gdzieszusza;

import java.util.List;
import java.util.Locale;

import android.app.Activity;
import android.app.AlertDialog;
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

//	@Override
//	public void onCreate(Bundle savedInstanceState) {
//		 super.onCreate(savedInstanceState);
//		 setContentView(R.layout.map);
//	}
	
//	 static final LatLng HAMBURG = new LatLng(53.558, 9.927);
//	  static final LatLng KIEL = new LatLng(53.551, 9.993);
	  private GoogleMap map;

	  @Override
	  protected void onCreate(Bundle savedInstanceState) {
//	    super.onCreate(savedInstanceState);
//	    setContentView(R.layout.map);
//	    map = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();
//	    
//	    Marker hamburg = map.addMarker(new MarkerOptions().position(HAMBURG).title("Hamburg"));
//	    Marker kiel = map.addMarker(new MarkerOptions()
//	        .position(KIEL)
//	        .title("Kiel")
//	        .snippet("Kiel is cool")
//	        .icon(BitmapDescriptorFactory
//	        .fromResource(R.drawable.ic_launcher)));
//
//	    // Move the camera instantly to hamburg with a zoom of 15.
//	    map.moveCamera(CameraUpdateFactory.newLatLngZoom(HAMBURG, 15));
//
//	    // Zoom in, animating the camera.
//	    map.animateCamera(CameraUpdateFactory.zoomTo(10), 2000, null);
		  
		  LatLng coordinates = new LatLng(gp.getLatitudeE6(), gp.getLongitudeE6());
		  Marker street = map.addMarker(new MarkerOptions().position(coordinates).title("DUPA"));
		  
		  map.moveCamera(CameraUpdateFactory.newLatLngZoom(coordinates, 15));
		  map.animateCamera(CameraUpdateFactory.zoomTo(10), 2000, null);
		  
		  
		  
//		  map.animateTo(gp);
//		  map.setZoom(12);
//
//          MapOverlay mapOverlay = new MapOverlay();
//        List<Overlay> listOfOverlays = map.getOverlays();
//        listOfOverlays.clear();
//        listOfOverlays.add(mapOverlay);
//
//          map.invalidate();
//          txtsearch.setText(""); 
	    
	    
	    
//	      Geocoder geoCoder = new Geocoder(context, Locale.getDefault());
//	      List<Address> addresses = geoCoder.getFromLocationName("Traugutta",5);
//	
//	      if(addresses.size() > 0)
//	      {
//	    	  GeoPoint p = new GeoPoint( (int) (addresses.get(0).getLatitude() * 1E6), 
//	                            (int) (addresses.get(0).getLongitude() * 1E6));
//	
//	             controller.animateTo(p);
//	             controller.setZoom(12);
//	
//	             MapOverlay mapOverlay = new MapOverlay();
//	           List<Overlay> listOfOverlays = map.getOverlays();
//	           listOfOverlays.clear();
//	           listOfOverlays.add(mapOverlay);
//	
//	             map.invalidate();
//	             txtsearch.setText("");
//	      }
//	      else
//	      {
//	              AlertDialog.Builder adb = new AlertDialog.Builder(GoogleMap.this);
//	              adb.setTitle("Google Map");
//	              adb.setMessage("Please Provide the Proper Place");
//	              adb.setPositiveButton("Close",null);
//	              adb.show();
//	      }
	    
	    
	    
	  }

//	  @Override
//	  public boolean onCreateOptionsMenu(Menu menu) {
//	    getMenuInflater().inflate(R.menu.activity_main, menu);
//	    return true;
//	  }
	  

//	  List<Address> addresses = geoCoder.getFromLocationName(txtsearch.getText().toString(),5);
//
//      if(addresses.size() > 0)
//      {
//           p = new GeoPoint( (int) (addresses.get(0).getLatitude() * 1E6), 
//                            (int) (addresses.get(0).getLongitude() * 1E6));
//
//             controller.animateTo(p);
//             controller.setZoom(12);
//
//             MapOverlay mapOverlay = new MapOverlay();
//           List<Overlay> listOfOverlays = map.getOverlays();
//           listOfOverlays.clear();
//           listOfOverlays.add(mapOverlay);
//
//             map.invalidate();
//             txtsearch.setText("");
//      }
//      else
//      {
//              AlertDialog.Builder adb = new AlertDialog.Builder(GoogleMap.this);
//              adb.setTitle("Google Map");
//              adb.setMessage("Please Provide the Proper Place");
//              adb.setPositiveButton("Close",null);
//              adb.show();
//      }
}