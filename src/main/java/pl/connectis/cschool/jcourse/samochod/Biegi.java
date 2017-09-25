package pl.connectis.cschool.jcourse.samochod;

import pl.connectis.cschool.jcourse.samochod.stale.OgranicznikPredkosciStan;

public class Biegi {

	Tempomat tempomat = new Tempomat();

	private int wartoscBiegu;
	protected boolean biegiOgranicznik = false;

	public int getWartoscBiegu() {
		return wartoscBiegu;
	}

	public void setWartoscBiegu(int wartoscBiegu) {
		this.wartoscBiegu = wartoscBiegu;
	}

	public Tempomat getTempomat() {
		return tempomat;
	}
	

	public boolean isBiegiOgranicznik() {
		return biegiOgranicznik;
	}

	public void ustawBieg(float predkosc) {
		int bieg = (int) predkosc / 20;
		if (bieg > 6) {
			setWartoscBiegu(6);
		} else if (bieg == 0) {
			setWartoscBiegu(1);
		} else {
			setWartoscBiegu(bieg);
		}

	}

	public void zmienBieg(int bieg) {
		if (bieg > 6 || bieg < 0) {
			System.out.println("Nieprawidlowa wartosc biegu. Wpisz liczbe z przedziału 0 - 6!");

		} else if (bieg == 0) {
			getTempomat().setPredkosc(0);
		} else {
			if (getTempomat().ogracznikPredkosciStan == OgranicznikPredkosciStan.WLACZONY) {

				if (getTempomat().getMaxPredkosc() < (bieg * 20)) {
					System.out.println("zmniejsz bieg");
					biegiOgranicznik = true;
					
				} else {
					getTempomat().setPredkosc(bieg * 20);
				}

			} else {
				getTempomat().setPredkosc(bieg * 20);
			}
		}
	}

}
