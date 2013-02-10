package com.arrived1.gdzieszusza;

import android.content.Context;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

class GiloAdapter extends PagerAdapter {
	//these are the titles that will appear on the "tabs"
	final String[] page_titles = new String[]{"Dzisiaj", "Kolejne dni", "Pe³na wersja", "Android", "About"};
	//this will go the description TextView
	final String[] desc = new String[]{
		"This is the homepage the first one you will see.",
		"I'm pretty much me for now I run this really cool blog you should check it out at mycodeandlife.wordpress.com",
		"I build appps mostly for fun. If you ever want an app just holla",
		"This is the android section",
		"This blog is my journal through life in code and development"};
	
	private Context context;

	public GiloAdapter(Context c){
		this.context = c;
	}

	//This is the number of pages -- 5
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
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
        	Today firstPage = new Today(inflater, "Pierwsza strona", R.layout.today);
        	view = firstPage.getView();
            break;
        case 1:
        	OtherDays secondPage = new OtherDays(inflater, "Druga strona", R.layout.today);
        	view = secondPage.getView();
            break;	
        case 3:
        	FullVersion fullVersion = new FullVersion(inflater, "Druga strona", R.layout.today);
        	view = fullVersion.getView();
        	break;
        default:
        	view = inflater.inflate(R.layout.page, null, false);

    		title = (TextView)view.findViewById(R.id.tvTitle);
    		description = (TextView)view.findViewById(R.id.tvdesc);

    		title.setText(page_titles[position]);
    		description.setText(desc[position]);
        }

		//This is very important
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