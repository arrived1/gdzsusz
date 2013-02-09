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
	final String[] page_titles = new String[]{"Home", "Me", "Apps", "Android", "About"};
	//this will go the description TextView
	final String[] desc = new String[]{
		"This is the homepage the first one you will see.",
		"I'm pretty much me for now I run this really cool blog you should check it out at mycodeandlife.wordpress.com",
		"I build appps mostly for fun. If you ever want an app just holla",
		"This is the android section",
		"This blog is my journal through life in code and development"};
	
	Context context;

	public GiloAdapter(Context c){
		this.context = c;
	}

	//This is the number of pages -- 5
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return page_titles.length;
	}

	@Override
	public boolean isViewFromObject(View v, Object o) {
		// TODO Auto-generated method stub
		return v.equals(o);
	}

	//This is the title of the page that will apppear on the "tab"
	public CharSequence getPageTitle(int position) {
        return page_titles[position];
    }

	//This is where all the magic happen
	public Object instantiateItem(View pager, int position) {
		final LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View v = inflater.inflate(R.layout.page, null, false);

		TextView title = (TextView)v.findViewById(R.id.tvTitle);
		TextView description = (TextView)v.findViewById(R.id.tvdesc);

		title.setText(page_titles[position]);
		description.setText(desc[position]);

		//This is very important
		((ViewPager)pager).addView(v, 0);

		return v;
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