package com.arrived1.gdzieszusza;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class InternetAcces {
	private Context context;
	
	public InternetAcces(Context context_) {
		this.context = context_;
	}
	
	public boolean isOnline() {
		ConnectivityManager cm = (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo netInfoWifi = cm.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
		NetworkInfo netInfoMobile = cm.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);

		if (netInfoWifi != null && netInfoWifi.isConnectedOrConnecting() &&
			netInfoMobile != null && netInfoMobile.isConnectedOrConnecting()) {
			return true;
		}
		return false;
	}
}
