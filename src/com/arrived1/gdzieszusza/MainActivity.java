package com.arrived1.gdzieszusza;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ShareActionProvider;

import com.viewpagerindicator.TabPageIndicator;

//System.out.println("DUPA ");


public class MainActivity extends Activity{
	private ShareActionProvider myShareActionProvider;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); 
        
        InternetAcces internetAcces = new InternetAcces(this);
        boolean hasInternet = internetAcces.isOnline();
        GiloAdapter mAdapter = null;

        if(hasInternet) {
        	NetworkGeolocalization networkGeolocalization = new NetworkGeolocalization(this);
        	mAdapter = new GiloAdapter(this, this, networkGeolocalization.getCurrentCityName());
        }
        else {
        	String title = "Błąd połaczcenia z internetem";
        	String msg = "Aplikacja wymaga połącznia z internetem w celu pobrania lub uaktualnienia danych. " +
        			     "Włącz internet i uruchom aplikację ponownie!";
        	
        	WarningDialog dialog = new WarningDialog(this);
        	dialog.buildRestartDialog(title, msg);
        	
        	mAdapter = new GiloAdapter(this);
        }

        //instantiate the Views
        ViewPager mPager = (ViewPager)findViewById(R.id.pager);
        mPager.setAdapter(mAdapter);

        TabPageIndicator mIndicator = (TabPageIndicator)findViewById(R.id.indicator);
        mIndicator.setViewPager(mPager);
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
    	MenuInflater inflater = getMenuInflater();
	    inflater.inflate(R.menu.activity_main, menu);
	    return true;
    }
    
    @Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    switch (item.getItemId()) {
	        case R.id.about_program:
	        	Intent myIntentAboutPtogram = new Intent(MainActivity.this, AboutProgram.class);
	            startActivity(myIntentAboutPtogram);
	            return true;
	        case R.id.menu_item_share:
//	    		myShareActionProvider = (ShareActionProvider)item.getActionProvider();
//	    		myShareActionProvider.setShareHistoryFileName(ShareActionProvider.DEFAULT_SHARE_HISTORY_FILE_NAME);
//	    		myShareActionProvider.setShareIntent(createShareIntent());
//	    		return true;
	        	Intent sendIntent = new Intent();
	        	sendIntent.setAction(Intent.ACTION_SEND);
	        	sendIntent.putExtra(Intent.EXTRA_TEXT, "This is my text to send.");
	        	sendIntent.setType("text/plain");
	        	startActivity(Intent.createChooser(sendIntent, "An error has occurred! Send an error report?"));
	        default:
	            return super.onOptionsItemSelected(item);
	    }
	}
    
    
//    public boolean onCreateOptionsMenu(Menu menu) {
//    	getMenuInflater().inflate(R.menu.menu, menu);
//		MenuItem item = menu.findItem(R.id.menu_item_share);
//		myShareActionProvider = (ShareActionProvider)item.getActionProvider();
//		myShareActionProvider.setShareHistoryFileName(ShareActionProvider.DEFAULT_SHARE_HISTORY_FILE_NAME);
//		myShareActionProvider.setShareIntent(createShareIntent());
//		return true;
//    }
    
    private Intent createShareIntent() {
    	Intent shareIntent = new Intent(Intent.ACTION_SEND);
    	shareIntent.setType("text/plain");
    	shareIntent.putExtra(Intent.EXTRA_TEXT, "http://android-er.blogspot.com/");
    	return shareIntent;
    }
}