package Lista.Lista;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ListaTest {

	private Lista list;
	
	@Before
	public void initializeTest(){
		System.out.println("Przed testem");
		list = new Lista(10);
	}
	
	@After
	public void after(){
		System.out.println("after");
	}
	@BeforeClass
	public static void bs(){
		System.out.println("before class");
	}
	@AfterClass
	public static void ac(){
		System.out.println("after class");
	}
	@Test
	public void shouldInitializeTheListWithGivenSize(){
		
		Assert.assertEquals(10, list.getLiczby().length);
	}
	
	
	@Test
	public void shouldAddElementToTheList(){
		
		list.dodajElement(1);
		
		Assert.assertEquals(1, list.getLiczby()[0]);
	}

	@Test
	public void shouldNotAddElementToTheListIfSizeOutOfRange(){
		
		Lista list = new Lista(1);
		
		list.dodajElement(5);
		list.dodajElement(15);
		
		Assert.assertEquals(1, list.getLiczby().length);
		Assert.assertEquals(5, list.getLiczby()[0]);
		
	}
	
	@Test
	public void shouldDeleteDuplications(){
		
		list.dodajElement(5);
		list.dodajElement(15);
		list.dodajElement(5);
		list.dodajElement(0);
		list.dodajElement(0);
		list.dodajElement(15);
		list.dodajElement(5);
		
		list.usunPowtorzenia();

		Assert.assertEquals(3, list.getRozmiar());
		Assert.assertEquals(5, list.getLiczby()[0]);
		Assert.assertEquals(15, list.getLiczby()[1]);
		Assert.assertEquals(0, list.getLiczby()[2]);
	}
}
