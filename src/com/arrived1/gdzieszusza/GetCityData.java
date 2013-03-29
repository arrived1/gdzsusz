package com.arrived1.gdzieszusza;

import android.app.Activity;

public class GetCityData {
	private City city = null;
	
	public GetCityData(String cityName, Activity activity_) {
		if(cityName.equals("Wrocław"))
			this.city = new City(cityName, "http://www.apteka-zwycieska.pl/gdzieSusza/wroclaw.html");
		else if(cityName.equals("Poznań"))
			this.city = new City(cityName, "http://www.apteka-zwycieska.pl/gdzieSusza/poznan.html");
		else if(cityName.equals("Toruń"))
			this.city = new City(cityName, "http://www.apteka-zwycieska.pl/gdzieSusza/torun.html");
		else {
			String title = "Błąd lokalizacji";
        	String msg = "Aplikacja nie wspiera jeszcze wyszukiwania fotoradarów w mieście: " + cityName
        				+ " Napisz do nas, aby dodać Twoje miasto w pierwszej kolejności!";
        	DialogBuilder dialog = new DialogBuilder(activity_);
        	dialog.buildRestartDialog(title, msg);
//			DialogBuilder dialog = new DialogBuilder(activity_);
//			dialog.buildeChooseCityDialog(title);
        	
			this.city = new City();
		}
	}
	
	public City getCity() {
		return city;
	}
}
