package pl.connectis.cschool.jcourse.samochod;

import java.text.DecimalFormat;
import java.util.Random;

public abstract class Pojazd {
	DecimalFormat df = new DecimalFormat("0.00");
	Double cisnienie;
	
	
	private Opona[] oponyTab;
	private Drzwi[] drzwi;
	protected Biegi biegi = new Biegi();

	
		public Pojazd(int iloscDrzwi, int opony) {
			oponyTab = new Opona[opony];
			drzwi = new Drzwi[iloscDrzwi];
		for(int i = 0; i < opony ; i++){
			Random rand = new Random();
			cisnienie = Double.parseDouble((df.format((rand.nextDouble())+2)).replace(",", "."));	
			oponyTab[i] = new Opona(cisnienie);
		}
		for(int i = 0; i < iloscDrzwi; i++){
			drzwi[i] = new Drzwi();
		}
	}



		public Biegi getBiegi() {
			return biegi;
		}



		public Opona[] getOpony() {
			return oponyTab;
		}

		



		public Drzwi[] getDrzwi() {
			return drzwi;
		}



		

		
	
}
