package pl.connectis.cschool.jcourse.samochod;

import pl.connectis.cschool.jcourse.samochod.stale.DrzwiStan;

public class Drzwi {
	private DrzwiStan drzwiStan = DrzwiStan.OTWARTE;
	
	public void otworz(){
		drzwiStan = DrzwiStan.OTWARTE;
	}
	
	public void zamknij(){
		drzwiStan = DrzwiStan.ZAMKNIETE;
	}

	public DrzwiStan getDrzwiStan() {
		return drzwiStan;
	}

}
