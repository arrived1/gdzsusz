package com.arrived1.gdzieszusza;

import android.app.Activity;
import android.content.Context;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

class GiloAdapter extends PagerAdapter {
	final String[] page_titles = new String[]{"Dzisiaj", "Jutro", "Pełna wersja"};
	private Context context;
	private City city;

	public GiloAdapter(Context context_){
		this.context = context_;
		
		city = new City();
	}
	
	public GiloAdapter(Context context_, Activity activity_, String cityName){
		this.context = context_;

		GetCityData getCityData = new GetCityData(cityName, activity_);
		this.city = getCityData.getCity();
	}

	@Override
	public int getCount() {
		//This is the number of pages -- 5
		return page_titles.length;
	}

	//This is the title of the page that will apppear on the "tab"
	public CharSequence getPageTitle(int position) {
        return page_titles[position];
    }

	//This is where all the magic happen
	public Object instantiateItem(View pager, int position) {
		final LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		
		View view;
		TextView title;
		TextView description;
		
		switch (position)
        {
        case 0:
        	Today firstPage = new Today(inflater, R.layout.today, city, context);
        	view = firstPage.getView();
            break;
        case 1:
        	OtherDays secondPage = new OtherDays(inflater, R.layout.other_days, city);
        	view = secondPage.getView();
            break;	
        case 2:
        	FullVersion fullVersion = new FullVersion(inflater, R.layout.full_version);
        	view = fullVersion.getView();
        	break;
        default:
        	final String[] desc = new String[]{"Ups cos sie zepsulo :("};
        	
        	view = inflater.inflate(R.layout.page, null, false);

    		title = (TextView)view.findViewById(R.id.tvTitle);
    		description = (TextView)view.findViewById(R.id.tvdesc);

    		title.setText(page_titles[position]);
    		description.setText(desc[position]);
        }

		((ViewPager)pager).addView(view, 0);
		return view;
	}
	
	@Override
	public boolean isViewFromObject(View v, Object o) {
		return v.equals(o);
	}

	@Override
	public void destroyItem(View pager, int position, Object view) {
		((ViewPager) pager).removeView((View) view);
	}

	@Override
	public void finishUpdate(View view) {
	}

	@Override
	public void restoreState(Parcelable p, ClassLoader c) {
	}

	@Override
	public Parcelable saveState() {
		return null;
	}

	@Override
	public void startUpdate(View view) {
	}
}