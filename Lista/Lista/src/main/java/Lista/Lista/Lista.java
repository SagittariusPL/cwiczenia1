package Lista.Lista;
//import static org.junit.Assert.assertEquals;

//import org.junit.Test;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;




public class Lista implements Serializable{

	private int[] liczby;

	public int[] getLiczby() {
		return liczby;
	}

	public void setLiczby(int[] liczby) {
		this.liczby = liczby;
	}

	private int pojemnosc;

	public int getPojemnosc() {
		return pojemnosc;
	}

	public void setPojemnosc(int pojemnosc) {
		this.pojemnosc = pojemnosc;
	}

	private int rozmiar;

	public int getRozmiar() {
		return rozmiar;
	}

	public void setRozmiar(int rozmiar) {
		this.rozmiar = rozmiar;
	}

	public Lista(int Pojemnosc) {

		pojemnosc = Pojemnosc;
		liczby = new int[Pojemnosc];

	}

	public void dodajElement(int b) {

		if (rozmiar < pojemnosc) {

			liczby[rozmiar] = b;
			rozmiar += 1;

		} else {
			System.out.println("Tablica przepełniona,nie można dodać więcej jak: " + pojemnosc + " elementow.");
		}

	}

	public void znajdz(int wpiszWartoscSzukana) {
		int pozycja = -1;
		int wartoscSzukana = wpiszWartoscSzukana;

		for (int i = 0; i <= pojemnosc - 1; i++) {
			if (liczby[i] == wartoscSzukana) {
				pozycja = i;
				System.out.println(pozycja);
			}

		}
		if (pozycja < 0) {
			System.out.println(pozycja + " \nNie znaleziono takiej liczby");
		}

	}

	public void pisz() {
		System.out.println("Pojemnosc: " + pojemnosc);
		System.out.println("Rozmiar: " + rozmiar);

		StringBuffer result = new StringBuffer();
		for (int i = 0; i < rozmiar; i++) {
			result.append(liczby[i]);
			result.append(" ");
		}
		String mynewstring = result.toString();
		System.out.println(mynewstring);
	}

	public void usunPierwszy(int elementDoUsuniecia) {

		for (int i = 0; i < pojemnosc - 1; i++) {
			if (liczby[i] == elementDoUsuniecia) {
				for (int k = i; k < pojemnosc - 1; k++) {
					liczby[k] = liczby[k + 1];

				}
				break;

			}

		}
		liczby[rozmiar - 1] = 0;

		StringBuffer result = new StringBuffer();
		for (int i = 0; i < rozmiar - 1; i++) {
			result.append(liczby[i]);
			result.append(" ");
		}
		String mynewstring = result.toString();
		System.out.println(mynewstring);

	}

	public void usunPowtorzenia() {
		int[] tab = new int[pojemnosc];
		int indexWTabTab = 0;

		for (int i = 0; i < rozmiar - 1; i++) {

			boolean czyMaElement = maElement(tab, liczby[i]);

			if (czyMaElement == false) {

				tab[indexWTabTab] = liczby[i];
				indexWTabTab++;
				//System.out.println("przypisano");

			}
		}
		liczby = tab;
		rozmiar=indexWTabTab;
		// System.out.println("\nPokazanie całej tablicy po uzyciu
		// usunPowturzenia");
		//System.out.println(Arrays.toString(liczby));
		// System.out.println(Arrays.toString(tab2));
		// System.out.println("\nLista po wykonaniu metody usunPowtorzenia i
		// prawidlowym wypisaniu");
		StringBuffer result = new StringBuffer();
		for (int i = 0; i <indexWTabTab; i++) {

			result.append(liczby[i]);
			result.append(" ");
		}
		String mynewstring = result.toString();
		System.out.println(mynewstring);

	}

	private boolean maElement(int[] tab, int i) {
		boolean booleanFlag=false; 
		for (int j = 0; j < rozmiar - 1; j++) {
			if (tab[j] == i) {
				booleanFlag = true;
				//System.out.println("nieprzypisano");
				break;
			}

		}
		return booleanFlag;
	}

	public void odrwoc() {
		// System.out.println(Arrays.toString(liczby));
		StringBuffer result = new StringBuffer();
		for (int i = rozmiar-1; i >= 0; --i) {

			result.append(liczby[i]);
			result.append(" ");
		}
		String mynewstring2 = result.toString();
		System.out.println(mynewstring2);

	}
	public static void zapisDoPliku(Lista a,String nazwaPliku) {
		try {
			FileOutputStream fileOut = new FileOutputStream(
					nazwaPliku);
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(a);
			out.close();
			fileOut.close();
			System.out.printf(
					"Serialized data is saved in C://Users//SagittariusPL//Documents//Git//cwiczenia1//Lista.ser");
		} catch (IOException i) {
			i.printStackTrace();
		}
		
	}
	public static void main(String[] args) {

		Lista a = new Lista(15);

		a.dodajElement(2);
		a.dodajElement(2);
		a.dodajElement(16);
		a.dodajElement(26);
		a.dodajElement(35);
		a.dodajElement(45);
		a.dodajElement(55);
		a.dodajElement(64);
		a.dodajElement(74);
		a.dodajElement(82);
		// a.dodajElement(1);
		// a.dodajElement(1);
		// a.dodajElement(1);
		// System.out.println(Arrays.toString(a.liczby));
		// a.znajdz(30);
		System.out.println("Wypisanie danych tablicy wraz z zawartoscia");
		a.pisz();
		System.out.println("\nmetoda znajdz");
		a.znajdz(35);
		System.out.println("\nMetoda usunPierwszy");
		a.usunPierwszy(5);
		System.out.println("Metoda usunPowtorzenia");
		a.usunPowtorzenia();
		System.out.println("Metoda odrwoc");
		a.odrwoc();
		Lista.zapisDoPliku(a, "C://Users//SagittariusPL//Documents//Git//cwiczenia1//Lista.ser");

	}
}
