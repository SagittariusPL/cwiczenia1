package pl.SagittariusPL.Moj_program2;

import java.io.File;
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.Scanner;

public class ClassMain 
{
	
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) throws Exception
	{
		
		
		Pozycja p1= new Pozycja("Mleko",  5, 7);
		//System.out.println(p1);
		Pozycja p2= new Pozycja("Chleb",  6, 4);
		//System.out.println(p2);
		Pozycja p3= new Pozycja("Margaryna",  30, 4.);
		//System.out.println(p3);
		Pozycja p4= new Pozycja("Bagietka",  11, 4);
		//System.out.println(p4);
		//System.out.println(p1.obliczWartoscZRabatem());
		//System.out.println(p2.obliczWartoscZRabatem());
		//System.out.println(p3.obliczWartoscZRabatem());
		//System.out.println(p4.obliczWartoscZRabatem());
		Zamowienie z= new Zamowienie();
		
		z.dodajPozycje(p1);
		z.dodajPozycje(p2);
		z.dodajPozycje(p3);
		z.dodajPozycje(p4);
		//z.usunPozycje(1);
		//z.edytujPozycje(0, "Maslo",4, 7);;
		System.out.println(z);
		
		//z.zapiszZamowienie( z.toString());
		//z.wczytajZamowienie("plik");
		z.zapisDoPliku();
		z.odczytZPliku();
		
	
	}
		
		
}
