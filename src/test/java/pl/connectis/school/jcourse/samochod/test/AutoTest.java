package pl.connectis.school.jcourse.samochod.test;

import static org.junit.Assert.*;

import org.junit.Test;

import pl.connectis.cschool.jcourse.samochod.Ciezarowka;
import pl.connectis.cschool.jcourse.samochod.Opona;
import pl.connectis.cschool.jcourse.samochod.Pojazd;
import pl.connectis.cschool.jcourse.samochod.SamochodOsobowy;
import pl.connectis.cschool.jcourse.samochod.stale.CisnienieWOponach;
import pl.connectis.cschool.jcourse.samochod.stale.DrzwiStan;
import pl.connectis.cschool.jcourse.samochod.stale.OgranicznikPredkosciStan;

public class AutoTest {
	SamochodOsobowy auto = new SamochodOsobowy();
	Ciezarowka ciezarowka = new Ciezarowka();

	// 1
	@Test
	public void ustawCisnieniePrawidloweTest() {
		for (int i = 0; i < 4; i++) {
			auto.getOpony()[i].ustawCisnieniePrawidlowe();
			assertTrue(auto.getOpony()[i].getCisnienie() <= Opona.getCisnieniemax()
					&& auto.getOpony()[i].getCisnienie() >= Opona.getCisnieniemin()
					&& auto.getOpony()[i].getCisnienieOponyStan() == CisnienieWOponach.PRAWIDLOWE);
		}

	}

	// 2
	@Test
	public void okreslStanCisnieniaTest() {
		for (int i = 0; i < 4; i++) {
			if (i % 2 == 0) {
				auto.getOpony()[i].setCisnienie(2.3);
				auto.getOpony()[i].okreslStanCisnienia();
				assertTrue(auto.getOpony()[i].getCisnienieOponyStan() == CisnienieWOponach.PRAWIDLOWE);

			} else {
				auto.getOpony()[i].setCisnienie(1.0);
				auto.getOpony()[i].okreslStanCisnienia();
				assertTrue(auto.getOpony()[i].getCisnienieOponyStan() == CisnienieWOponach.NIEPRAWIDLOWE);

			}

		}
	}

	// 3
	@Test
	public void cisnienieNiezweryfikowaneTest() {
		// stan Ciśnienia przed użyciem okreslStanCisnienia();
		for (int i = 0; i < 4; i++) {
			if (i % 2 == 0) {
				auto.getOpony()[i].setCisnienie(2.3);

			} else {
				auto.getOpony()[i].setCisnienie(1.0);

			}
			assertTrue(auto.getOpony()[i].getCisnienieOponyStan() == CisnienieWOponach.NIEZWERYFIKOWANE);
		}
	}

	// 4
	@Test
	public void ustawOgranicznikPredkosciStanTest() {
		auto.getBiegi().getTempomat().ustawOgranicznikPredkosci(100);
		assertTrue(auto.getBiegi().getTempomat().getOgracznikPredkosciStan() == OgranicznikPredkosciStan.WLACZONY);
	}
	@Test
	public void ustawOgranicznikPredkosciMaxPredTest() {
		auto.getBiegi().getTempomat().ustawOgranicznikPredkosci(100);
		assertEquals(100, auto.getBiegi().getTempomat().getMaxPredkosc(), 0.00001);
	}
	
	@Test
	public void ustawOgranicznikPredkosciMaxPredTestCiezarowka() {
		ciezarowka.getBiegi().getTempomat().ustawOgranicznikPredkosci(121);
		assertEquals(120, ciezarowka.getBiegi().getTempomat().getMaxPredkosc(), 0.00001);
	}
	

	// 5
	@Test
	public void ustawPredkoscWiekszaOgrPredOnTest() {
		auto.getBiegi().getTempomat().ustawOgranicznikPredkosci(100);
		auto.getBiegi().getTempomat().ustawPredkosc(120);
		assertTrue(auto.getBiegi().getTempomat().isPrzekroczonaPredkosc());
	}

	// 6
	@Test
	public void ustawPredkoscMniejszaOgrPredOnTest() {
		auto.getBiegi().getTempomat().ustawOgranicznikPredkosci(100);
		auto.getBiegi().getTempomat().ustawPredkosc(50);
		assertEquals(80, auto.getBiegi().getTempomat().getPredkosc(), 0.00000001);

	}

	// 7
	@Test
	public void ZlikwidujOgranicznikPredkosciTest() {
		auto.getBiegi().getTempomat().zlikwidujOgranicznikPredkosci();
		assertTrue(auto.getBiegi().getTempomat().getOgracznikPredkosciStan() == OgranicznikPredkosciStan.WYLACZONY);

	}

	// 8
	@Test
	public void ustawPredkoscMniejszaFlagaOgrPredOnTest() {
		auto.getBiegi().getTempomat().ustawOgranicznikPredkosci(100);
		auto.getBiegi().getTempomat().ustawPredkosc(50);
		assertFalse(auto.getBiegi().getTempomat().isPrzekroczonaPredkosc());
	}

	// 9
	@Test
	public void otworzDrzwiTest() {
		for (int i = 0; i < 4; i++) {
			auto.getDrzwi()[i].otworz();
			assertTrue(auto.getDrzwi()[i].getDrzwiStan() == DrzwiStan.OTWARTE);
		}

	}

	// 10
	@Test
	public void zamknijDrzwiTest() {
		for (int i = 0; i < 4; i++) {
			auto.getDrzwi()[i].zamknij();
			assertTrue(auto.getDrzwi()[i].getDrzwiStan() == DrzwiStan.ZAMKNIETE);
		}

	}

	// 11
	@Test
	public void ustawBiegTest() {
		auto.getBiegi().getTempomat().ustawPredkosc(54);
		auto.getBiegi().ustawBieg(auto.getBiegi().getTempomat().getPredkosc());
		assertEquals(4, auto.getBiegi().getWartoscBiegu());

	}
	
	// 12
		@Test
		public void ustawBiegTestCiezarowka() {
			ciezarowka.getBiegi().getTempomat().ustawPredkosc(120);
			ciezarowka.getBiegi().ustawBieg(ciezarowka.getBiegi().getTempomat().getPredkosc());
			assertEquals(8, ciezarowka.getBiegi().getWartoscBiegu());

		}

	// 13
	@Test
	public void zmienBiegTestOgrPredOffTest() {
		
		auto.getBiegi().zmienBieg(4);
		assertEquals(80, auto.getBiegi().getTempomat().getPredkosc(), 0.0000000001);

	}
	
	// 14
		@Test
		public void zmienBiegTestOgrPredOffTestCiezarowka() {
			
			ciezarowka.getBiegi().zmienBieg(3);
			assertEquals(45, ciezarowka.getBiegi().getTempomat().getPredkosc(), 0.0000000001);

		}
	
	// 15
		@Test
		public void zmienBiegTestOgrPredOnTest() {
			auto.getBiegi().getTempomat().ustawOgranicznikPredkosci(20);
			auto.getBiegi().zmienBieg(4);
			assertTrue(auto.getBiegi().isBiegiOgranicznik());

		}

}
