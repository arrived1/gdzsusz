package com.arrived1.gdzieszusza;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import com.viewpagerindicator.TabPageIndicator;


public class ActivityRunner extends Activity {
    
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.runner_activity); 
        
        Bundle extras = getIntent().getExtras();
		String cityName = extras.getString("CITY_NAME");
        
        GiloAdapter mAdapter = new GiloAdapter(this, this, cityName);   

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
	        case R.id.city_list:
	        	Intent myIntentCityList = new Intent(ActivityRunner.this, ActivityCityList.class);
	            startActivity(myIntentCityList);
	            return true;
	        case R.id.about_program:
	        	Intent myIntentAboutPtogram = new Intent(ActivityRunner.this, ActivityAboutProgram.class);
	            startActivity(myIntentAboutPtogram);
	            return true;
	        case R.id.menu_item_share:
	        	Intent sendIntent = new Intent();
	        	sendIntent.setAction(Intent.ACTION_SEND);
	        	sendIntent.setType("text/plain");
	        	sendIntent.putExtra(Intent.EXTRA_TEXT, "Gdzie Suszą: unikaj fotoradarów i Straży Miejskiej! Sprawdź aplikację!"); //TODO: add Fecbook itp!!!
	        	sendIntent.putExtra("image_url", R.drawable.ic_launcher);
	        	startActivity(Intent.createChooser(sendIntent, "Podziel się aplikacją!"));
	        default:
	            return super.onOptionsItemSelected(item);
	    }
	}
}