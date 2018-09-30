import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import java.util.logging.*;
public class TestList {
	
	private LinkedList<Integer> testList;
	private ArrayList<Integer> testArrayList;
	
	@Before
	public void create() {
		testList = new LinkedList <Integer>();
		testArrayList = new ArrayList <Integer>();
	}
	
	@Test(expected=IndexOutOfBoundsException.class)
	public void testIndexOutOfBoundsException() {
		testList.Add(2,18);
		testList.Remove(4);
		testArrayList.Add(2,18);
		testArrayList.Remove(5);
		testArrayList.Get(5);
	}

	@Test
	public void test() {
		
		// Add
		testList.Add(1);
		testList.Add(2);
		testList.Add(3);
 		testList.Add(2);
		testList.Add(4);
		testList.Add(3);
		
		//Get length
		assertEquals(6, testList.GetLength());
		
		//Remove
		testList.Remove(1);
		testList.Remove(2);
		testList.RemoveAll(3);
		
		//Get
		assertEquals((Integer)1, testList.Get(0));
		assertEquals((Integer)3, testList.Get(3));
		
		//Print
		testList.Print();
	}
	
}
