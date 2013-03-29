package com.arrived1.gdzieszusza;

import java.text.SimpleDateFormat;
import java.util.Vector;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class AdapterTodayList extends ArrayAdapter<Police> {
    private final Context context;
	private final Vector<Police> values;
	private int txtSize;
 
	public AdapterTodayList(Context context, Vector<Police> values) {
		super(context, R.layout.listview_layout, values);
		this.context = context;
		this.values = values;
		this.txtSize = checkStreetNameSize();
	}
 
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View rowView = inflater.inflate(R.layout.listview_layout, parent, false);
		
		TextView textView1 = (TextView)rowView.findViewById(R.id.txt);
		String street = " " + values.elementAt(position).street;
		
		if(txtSize > 16)
			textView1.setTextSize(15.f);
		
		textView1.setText(street);
		
		TextView textView2 = (TextView)rowView.findViewById(R.id.date);
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
		textView2.setText(" " + dateFormat.format(values.elementAt(position).date.getTime()));
		
		ImageView imageView = (ImageView)rowView.findViewById(R.id.flag);
		imageView.setImageResource(R.drawable.ic);
 
		return rowView;
	}
	
	private int checkStreetNameSize() {
		int size = 0;
		for(int i = 0; i < values.size(); ++i) {
			int streetSize = values.elementAt(i).street.length();
			if(streetSize > size)
				size = streetSize;
		}
		return size;
	}
}
