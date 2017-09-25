package pl.connectis.cschool.jcourse.samochod;

public class Ciezarowka extends Pojazd {

	public Ciezarowka() {
		super(2, 6);
		biegi = new BiegiCiezarowka();
		System.out.println("Jestem ciezarowka");
	}

}
