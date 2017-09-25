package pl.connectis.cschool.jcourse.samochod;

import pl.connectis.cschool.jcourse.samochod.stale.OgranicznikPredkosciStan;

public class Tempomat {
	private float predkosc = 0;
	private float maxPredkosc;
	boolean przekroczonaPredkosc = false;
	OgranicznikPredkosciStan ogracznikPredkosciStan = OgranicznikPredkosciStan.WYLACZONY;

	public float getPredkosc() {
		return predkosc;
	}

	public void setPredkosc(float predkosc) {
		this.predkosc = predkosc;
	}
	

	public boolean isPrzekroczonaPredkosc() {
		return przekroczonaPredkosc;
	}

	public OgranicznikPredkosciStan getOgracznikPredkosciStan() {
		return ogracznikPredkosciStan;
	}

	public void setOgracznikPredkosciStan(OgranicznikPredkosciStan ogracznikPredkosciStan) {
		this.ogracznikPredkosciStan = ogracznikPredkosciStan;
	}

	public float getMaxPredkosc() {
		return maxPredkosc;
	}

	public void setMaxPredkosc(float maxPredkosc) {
		this.maxPredkosc = maxPredkosc;
	}

	public void ustawPredkosc(float oczekiwaniaPredkosc) {
		if (ogracznikPredkosciStan == OgranicznikPredkosciStan.WLACZONY) {
			if (oczekiwaniaPredkosc < maxPredkosc) {
				setPredkosc(oczekiwaniaPredkosc);
			} else {
				System.out.println("Masz ustawiony ogranicznik predkosci na: " + maxPredkosc);
				przekroczonaPredkosc = true;
			}
		} else {
			setPredkosc(oczekiwaniaPredkosc);
		}
	}

	public void ustawOgranicznikPredkosci(float maxPredkosc) {
		setOgracznikPredkosciStan(OgranicznikPredkosciStan.WLACZONY);
		if(maxPredkosc > 120){
			setMaxPredkosc(120);
		} else {
		setMaxPredkosc(maxPredkosc);
		}
	}

	public void zlikwidujOgranicznikPredkosci() {
		setOgracznikPredkosciStan(OgranicznikPredkosciStan.WYLACZONY);
	}
	
	

}
