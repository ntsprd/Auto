package pl.connectis.cschool.jcourse.samochod;

import java.util.Random;


import java.text.DecimalFormat;

public class SamochodOsobowy extends Pojazd{

	public SamochodOsobowy() {
		super(4, 4);
		getBiegi().tempomat = new SuperTempomat();
		System.out.println("Jestem osobowka");
	}
	
	
	

}

