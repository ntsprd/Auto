package pl.connectis.cschool.jcourse.samochod;

import java.text.DecimalFormat;
import java.util.Random;

import pl.connectis.cschool.jcourse.samochod.stale.CisnienieWOponach;

public class Opona {

	private double cisnienieOpona;
	final static double cisnienieMin = 2.2;
	final static double cisnienieMax = 2.5;

	private CisnienieWOponach cisnienieOponyStan = CisnienieWOponach.NIEZWERYFIKOWANE;

	public Opona(double cisnienie) {
		this.cisnienieOpona = cisnienie;

	}

	public double getCisnienie() {
		return cisnienieOpona;
	}

	public void setCisnienie(double cisnienie) {
		this.cisnienieOpona = cisnienie;
	}

	public void okreslStanCisnienia() {
		if (getCisnienie() <= cisnienieMax && getCisnienie() >= cisnienieMin) {
			setCisnienieOponyStan(CisnienieWOponach.PRAWIDLOWE);
		} else {
			setCisnienieOponyStan(CisnienieWOponach.NIEPRAWIDLOWE);
		}
	}

	public void ustawCisnieniePrawidlowe() {
		Random rand = new Random();
		DecimalFormat df = new DecimalFormat("0.00");
		double wylosowanaLiczba = rand.nextDouble() * (cisnienieMax - cisnienieMin) + cisnienieMin;
		Double cisnieniePrawidlowe = Double.parseDouble((df.format(wylosowanaLiczba)).replace(",", "."));
		setCisnienie(cisnieniePrawidlowe);
		setCisnienieOponyStan(CisnienieWOponach.PRAWIDLOWE);
	}

	public CisnienieWOponach getCisnienieOponyStan() {
		return cisnienieOponyStan;
	}

	public void setCisnienieOponyStan(CisnienieWOponach cisnienieOponyStan) {
		this.cisnienieOponyStan = cisnienieOponyStan;
	}

	public static double getCisnieniemin() {
		return cisnienieMin;
	}

	public static double getCisnieniemax() {
		return cisnienieMax;
	}
	

}
