package pl.SagittariusPL.Moj_program2;

import java.io.Serializable;

public  class Pozycja implements Serializable
{

	private String nazwaTowaru;
	
	private int ileSztuk;
	
	private double cena;
	
	public String getNazwaTowaru() {
		return nazwaTowaru;
	}

	public void setNazwaTowaru(String NazwaTowaru)
	{
		this.nazwaTowaru=NazwaTowaru;
	}
	
	public int getIleSztuk() {
		return ileSztuk;
	}

	public void setIleSztuk(int IleSztuk)
	{
		this.ileSztuk=IleSztuk;
	}
	
	public double getCena() {
		return cena;
	}

	public void setCena(double cena)
	{
		this.cena=cena;
	}
	
		
	public Pozycja(String nazwatowaru, int iloscsztuk, double cenatowaru)
	{
		nazwaTowaru=nazwatowaru;
		ileSztuk=iloscsztuk;
		cena=cenatowaru;
	}
	
	public double obliczWartosc()
	{
		double wartosc;
		return  wartosc=ileSztuk*cena;
		
		
	}

	
	double obliczWartoscZRabatem()
	{
		double p;
		
		p=obliczWartosc();
		
		if(ileSztuk>=5&& ileSztuk<10)
		{
			p=p*0.95;
			
		}
		
		else if(ileSztuk>=10&& ileSztuk<=20)
		{
			p=p*0.9;
			
		}
		
		
		else if(ileSztuk>20)
		{
			p=p*0.85;
			
		}
		//p=Math.round(p);
		return p;
	}
	
	public double wartoscUpustu(){
		
		double a= obliczWartoscZRabatem()/obliczWartosc();
		double b=  (1-a)*100;
		
		b=Math.round(b);
		return b;
	}
	public String toString()
	{
		
		
		return String.format("%-20s %-15s %-15s %-15s %-15s %-15s", nazwaTowaru,cena+" z³ ",ileSztuk+" szt. ",obliczWartosc()+" z³ ",wartoscUpustu(),obliczWartoscZRabatem()+"zl");
		
		
	}

	
	
	

	
}