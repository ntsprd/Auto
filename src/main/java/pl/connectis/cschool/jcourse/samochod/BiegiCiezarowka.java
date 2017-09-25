package pl.connectis.cschool.jcourse.samochod;

import pl.connectis.cschool.jcourse.samochod.stale.OgranicznikPredkosciStan;

public class BiegiCiezarowka extends Biegi {
	@Override
	public void ustawBieg(float predkosc) {
		int bieg = (int) predkosc / 15;
		if (bieg > 8) {
			setWartoscBiegu(8);
		} else if (bieg == 0) {
			setWartoscBiegu(1);
		} else {
			setWartoscBiegu(bieg);
		}

	}
@Override
public void zmienBieg(int bieg) {
	if (bieg > 8 || bieg < 0) {
		System.out.println("Nieprawidlowa wartosc biegu. Wpisz liczbe z przedziału 0 - 8!");

	} else if (bieg == 0) {
		getTempomat().setPredkosc(0);
	} else {
		if (getTempomat().ogracznikPredkosciStan == OgranicznikPredkosciStan.WLACZONY) {

			if (getTempomat().getMaxPredkosc() < (bieg * 15)) {
				System.out.println("zmniejsz bieg");
				biegiOgranicznik = true;
				
			} else {
				getTempomat().setPredkosc(bieg * 15);
			}

		} else {
			getTempomat().setPredkosc(bieg * 15);
		}
	}

}
}
