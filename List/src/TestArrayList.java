import static org.junit.Assert.*;

import org.junit.Test;
import java.util.logging.*;
public class TestArrayList {
	
	@Test(expected=IndexOutOfBoundsException.class)
	public void testIndexOutOfBoundsException() {
		ArrayList<Integer> testArr = new ArrayList <Integer>();
		testArr.Print();
		System.out.println("------");
		testArr.Add(2,18);
	}

	@Test
	public void test() {
		
		// Constructors
		ArrayList<Integer> testArr1 = new ArrayList <Integer>();
		ArrayList<String> testArr2 = new ArrayList <String>(5);
		
		//Add
		testArr1.Add(4);
		assertEquals(1, testArr1.numOfElem);
		assertEquals(10, testArr1.maxCount);
		
		testArr1.Add(3,0);
		assertEquals(2, testArr1.numOfElem);
		assertEquals(10, testArr1.maxCount);
		
		testArr2.Add("Hello");
		testArr2.Add("Kitty");
		assertEquals(2, testArr2.numOfElem);
		assertEquals(5, testArr2.maxCount);
		
		testArr1.Add(6);
		testArr1.Add(7);
		testArr1.Add(4);
		testArr1.Add(4);
		testArr1.Add(6,3);
		testArr1.Add(9);
		testArr1.Add(10);
		testArr1.Add(100);
		testArr1.Add(11);
		System.out.println("MaxCount = "+ testArr1.maxCount);
		testArr2.Add("Meow",1);
		testArr2.Add("Hello");
		
		
		// Get
		assertEquals((Integer)4, testArr1.Get(1));
		
		// Print
		testArr1.Print();
		testArr2.Print();
		
		// Remove
		testArr1.Remove(3);
		testArr1.Remove(4);
		testArr1.RemoveAll(6);
		testArr1.Remove(2);
		testArr2.Remove("Hello");
		
		// Print
		System.out.println("--------");
		testArr1.Print();
		testArr2.Print();
	}
	
}
