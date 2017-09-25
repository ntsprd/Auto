package pl.connectis.cschool.jcourse.samochod;

import pl.connectis.cschool.jcourse.samochod.stale.OgranicznikPredkosciStan;

public class SuperTempomat extends Tempomat {
	@Override
	public void ustawPredkosc(float oczekiwaniaPredkosc) {
		super.ustawPredkosc(oczekiwaniaPredkosc + 30);
	}
	@Override
	public void ustawOgranicznikPredkosci(float maxPredkosc) {
		setOgracznikPredkosciStan(OgranicznikPredkosciStan.WLACZONY);
		setMaxPredkosc(maxPredkosc);
	}
}
