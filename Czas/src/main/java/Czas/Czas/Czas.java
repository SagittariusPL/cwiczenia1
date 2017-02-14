package Czas.Czas;

import java.util.Arrays;

public class Czas {
	
	private  int godz;
	
	public int getGodz(){
		return godz;
	}
	public void setGodz(int Godz){
		this.godz= Godz;
	}
	
	private int minuty;
	
	public int getMinuty(){
		return minuty;
	}
	public void setMinuty(int Minuty){
		this.godz= Minuty;
	}
	
	
	public Czas(int Godziny, int Minuty)
	{
		godz= Godziny;
		minuty = Minuty;
	}

	public void Czas(String A)
	{
		String a = A;
	}

	public String toString(){
		
		StringBuilder tekst = new StringBuilder();
		
		tekst.append(godz + "h " + minuty + " min");
		return tekst.toString();
	}

	
	public Czas dodaj(Czas q){
		
		godz=godz+q.getGodz();
		
		minuty= minuty+q.getMinuty();
		int z=0;
		while(minuty>=60){
			
			minuty=minuty-60;
			z++;
		}
		
		godz=godz+z;
		return new Czas(godz,minuty );
		
	}
	
public Czas odejmij(Czas q){
		
		godz=godz-q.getGodz();
		
		 minuty= minuty-q.getMinuty();
		
		int z=0;
		if(minuty<0){
			
			minuty=60+minuty;
			z++;
			
			
		}
	
		godz= godz-z;
		if(godz<0 || minuty<0){
			System.out.println("Nie mozna odiac tych czasow - wartosc ujemna");
			return null;
		}
		return new Czas(godz,minuty );
}
		public Czas pomnoz(int ile){
			
			if(godz<0 || minuty<0){
				System.out.println("Nie mozna pomnozyc tego czasu- wartosc ujemna");
				return null;
			}
			godz= godz*ile;
			minuty=minuty*ile;
			
			int z=0;
			while(minuty>=60){
				
				minuty=minuty-60;
				z++;
			}
			godz=godz+z;
			return new Czas(godz, minuty);
		}
		
		static Czas sumuj(Czas [] tab, int n){
			int b=0;
			int newgodz=0;
			
			for(int i=0; i<tab.length; i++){
				newgodz= newgodz+ tab[i].getGodz();
				
			}
			for(int j=0; j<tab.length; j++){
				b=b+ tab[j].minuty;
				
			}
			int z = 0;
			while(b>=60){
				
				b=b-60;
				z++;
			}
			newgodz=newgodz+z;
			return new Czas(newgodz, b);
			
			
			
		
			
		}
	
    public static void main( String[] args )
    {
    	Czas a= new Czas(6, 15);
    	Czas b= new Czas(2, 30);
    	Czas c= new Czas(4, 40);
    	System.out.println("Czas a = "+a);
    	System.out.println("Czas b = "+b);
    	System.out.println("Czas c = "+c);
    	System.out.println("Suma a + b = " + a.dodaj(b));
    	System.out.println("Odejmij a - c = " + a.odejmij(c));
    	System.out.println("a*3 " + a.pomnoz(3));
    	Czas [] tab = { a, b, c };
    	System.out.println(Arrays.toString(tab));
    	System.out.println(Czas.sumuj(tab, 3));
    	
        }
}
