package com.arrived1.gdzieszusza;

import android.view.LayoutInflater;
import android.widget.TextView;

public class FullVersion extends Tab {

	public FullVersion(LayoutInflater inflater_, int layout) {
		super(inflater_, layout);
		
		TextView fullVerTitle = (TextView)view.findViewById(R.id.appFullVersionName);
		fullVerTitle.setText("Gdzie Suszą+");
		
		TextView fullVerString = (TextView)view.findViewById(R.id.availableOptions);
		fullVerString.setText("Pełna wersja zawiera:");
		
		String txt = "- ostrzega przed fotoradarami na ulicy gdzie prawdopodobnie jest fotoradar,\n" +
				     "- ostrzega o przekroczeniu prędkości na ulicy gdzie jest fotoradar,\n" +
				     "- aplikacja może działać w tle,\n" +
					 "- szereg opcji konfiguracyjnych aplikację,\n" +
					 "- więcej dni z planem ustawienia fotoradarów,\n" +
					 "- możliwość segregowania wyników(po nazwie ulicy lub dacie),\n" + 
					 "- po wybraniu ulicy, aplikacja otwiera mapę,\n" +
					 "- aplikacja oszczędza baterię\n";
		
		TextView fullVerDescribtion = (TextView)view.findViewById(R.id.availableOptionsList);
		fullVerDescribtion.setText(txt);
	}
}
