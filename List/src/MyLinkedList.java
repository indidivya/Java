import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.ListIterator;
import java.util.Iterator;
import java.util.LinkedList;
public class MyLinkedList {
	
	static void insertMid(LinkedList newlist, Integer n) {
		ListIterator<Integer> lt = newlist.listIterator(newlist.size()/2);
		lt.add(n);
		//display(newlist);
	}
	static void display(LinkedList ll) {
		/*
		 * Print Linked List contents using Iterator
		 */
		Iterator<Integer> it = ll.iterator();
		while(it.hasNext()) {
			Integer tmp = it.next();
			System.out.print(tmp);
		}
		System.out.println("");
	}
	
	static void removeDuplicates(LinkedList ll) {
		Iterator<Integer> it = ll.iterator();
		HashMap<Integer, Boolean> hm = new HashMap <Integer, Boolean>();
		
		while(it.hasNext()) {
			Integer tmp = it.next();
			if (hm.containsKey(tmp) ){
				hm.put(tmp, true);
				continue;
			}
			hm.put(tmp, false);
		}
		it = ll.iterator();
		while(it.hasNext()) {
			Integer tmp = it.next();
			if (hm.get(tmp)) {
				it.remove();
			}
		}
	}
	public static void main(String args[]) {
		LinkedList<Integer> mylinkedlist = new LinkedList<Integer>();
		mylinkedlist.add(2);
		mylinkedlist.add(4);
		
		/*
		 * Simple print using for loop
		 */
		for (Integer tmp: mylinkedlist) {
			//System.out.println(tmp);
			
		}
		// Create a list and elements should always be inserted in the middle.
		LinkedList<Integer> newlist = new LinkedList<Integer>();
		
		insertMid(newlist,1);
		insertMid(newlist,4);
		insertMid(newlist,1);
		insertMid(newlist,1);
		insertMid(newlist,1);
		display(newlist);
		
		// Delete the elements in the list whose their sum is 0 - NP
		
		//Remove duplicate elements in an unsorted linkedlist
		removeDuplicates(newlist);
		display(newlist);
		// Detect a loop in a linkedlist.
		
		
	}
	
	
	
	
}
