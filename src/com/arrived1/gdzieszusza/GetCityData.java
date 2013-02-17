package com.arrived1.gdzieszusza;

public class GetCityData {
	private City city = null;
	
	public GetCityData(String cityName) {
		if(cityName.equals("Wrocław"))
			this.city = new City(cityName, "http://www.apteka-zwycieska.pl/gdzieSusza/wroclaw.html");
		else {
			//TODO: wrog city close aplication
			this.city = new City("", "");
		}
	}
	
	public City getCity() {
		return city;
	}
}
