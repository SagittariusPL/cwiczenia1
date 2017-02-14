package pl.SagittariusPL.Moj_program2;

import java.io.*;
import java.nio.Buffer;

public class Zamowienie implements Serializable {
	private int ileDanych;
	private int maksRozmiar;
	Pozycja[] pozycje = new Pozycja[10];
	private int indeks;

	public int setIleDanych() {
		return ileDanych;
	}

	public void getIleDanych(int ileDanych) {
		this.ileDanych = ileDanych;

	}

	public int setMaksRozmiar() {
		return maksRozmiar;
	}

	public void getMaksRozmiar(int maksRozmiar) {
		this.maksRozmiar = maksRozmiar;

	}

	public int getIndeks() {
		return indeks;
	}

	public void setIndeks(int indeks) {
		this.indeks = indeks;
	}

	public int maksRozmiar()

	{

		return maksRozmiar = 10;
	}

	public int ilePozycji(int maksRozmiar) {
		return maksRozmiar;
	}

	public void dodajPozycje(Pozycja p) {

		boolean dodajpoz = false;
		for (int k = 0; k < ileDanych; k++) {
			if (pozycje[k].getNazwaTowaru() == p.getNazwaTowaru()) {
				pozycje[k].setIleSztuk(pozycje[k].getIleSztuk() + p.getIleSztuk());
				// p.ileSztuk=0;
				// p.cena=0;
				// .nazwaTowaru="Zamiana";
				dodajpoz = true;
			}

		}

		if (dodajpoz == false) {
			pozycje[ileDanych] = p;
			ileDanych = ileDanych + 1;

		}

	}

	public double obliczWartosc() {
		double suma = 0;
		for (int i = 0; i < ileDanych; i++) {

			suma += pozycje[i].obliczWartosc();

		}
		return suma;
	}

	public double obliczWartoscZRabatem() {
		double suma2 = 0;
		for (int i = 0; i < ileDanych; i++) {

			suma2 += pozycje[i].obliczWartoscZRabatem();

		}
		return suma2;
	}

	public String toString() {

		StringBuilder tekst = new StringBuilder();

		tekst.append(String.format("%-20s %-15s %-15s %-15s %-15s %-15s ", "Zamowienie :", "cena", "ilosc sztuk",
				"cena normalna", "rabat w %", "Cena po rabacie"));
		for (int j = 0; j < ileDanych; j++)

		{

			tekst.append("\n" + pozycje[j]);

		}

		tekst.append("\nCena bez rabatu :" + obliczWartosc() + " zl");
		tekst.append("\nCena po rabacie :" + obliczWartoscZRabatem() + " zl");

		return tekst.toString();

	}

	public void usunPozycje(int indeks) /// implementacja usuwania pozycji z
										/// listy zamownienia

	{
		for (int k = indeks; k < ileDanych; k++) {
			pozycje[k] = pozycje[k + 1];

		}
		ileDanych = ileDanych - 1;
	}

	public void edytujPozycje(int indeks, String nazwatowaru, int iloscsztuk, double cena) {

		pozycje[indeks] = new Pozycja(nazwatowaru, iloscsztuk, cena);

	}
	
	private String nazwaPliku = "plik";
	
	//public String getNazwaPliku(){
		//return nazwaPliku;
	//}

	//public void serNazwaPliku(String nazwaPliku){
	///	nazwaPliku= "C://Users//SagittariusPL//Documents//Git//cwiczenia1//zamowienie.ser";
		//this.nazwaPliku=nazwaPliku;
	//}
	public static void zapisDoPliku(Zamowienie z,String nazwaPliku) {
		try {
			FileOutputStream fileOut = new FileOutputStream(
					nazwaPliku);
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(z);
			out.close();
			fileOut.close();
			System.out.printf(
					"Serialized data is saved in C://Users//SagittariusPL//Documents//Git//cwiczenia1//zamowienie.ser");
		} catch (IOException i) {
			i.printStackTrace();
		}

	}
	public static void odczytZPliku(String nazwaPliku){
		Zamowienie z = null;
		 try {
	         FileInputStream fileIn = new FileInputStream(nazwaPliku);
	         ObjectInputStream in = new ObjectInputStream(fileIn);
	         z = (Zamowienie) in.readObject();
	         in.close();
	         fileIn.close();
	         System.out.printf(
						"\nDeserializing data is readed C://Users//SagittariusPL//Documents//Git//cwiczenia1//zamowienie.ser");
	      }catch(IOException i) {
	         i.printStackTrace();
	         return;
	      }catch(ClassNotFoundException c) {
	         System.out.println("pozycje class not found");
	         c.printStackTrace();
	         return;
	      }
	}
}