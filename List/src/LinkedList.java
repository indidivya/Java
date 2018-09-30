/*
 * Doubts: 
 * 1) == Vs .equals 
 * 2) Constructors
 */
public class LinkedList<T> implements List<T> {
	int numOfElem;
	
	private class Node<T> {
		T data;
		Node next;
		Node(T newdata, Node nextnode) {
			data = newdata;
			next = nextnode;
		}
	}
	Node head;	
	Node LinkedList() {
		head = null;
		numOfElem = 0;
		return null;
	}
	Node LinkedList(T data) {
		head = new Node(data, null);
		numOfElem = 1;
		return head;
	}
	// More contructors - create a new from an existing?
	
	public void Add(T data) {
		Node n = new Node(data, null);
		Node tmp;
		if (head == null) {
			head = n;
			numOfElem++;
			return;
		}
		tmp = head;
		while(tmp.next != null) {
			tmp = tmp.next;
		}
		tmp.next = n;
		numOfElem++;
	}
	private Node FindNode(int pos) {
		
		if (pos > numOfElem || pos <= 0) 
			return null;
		
		int i = 1;
		Node tmp;
		
		if (head == null)
			return null;
		
		tmp = head;
		for (i=1; i<pos; i++) {
			tmp = tmp.next;
		}
		return tmp;
	}
	
	public void Add(T data, int pos) {
		Node tmp;
		Node newnode;
		
		if (pos > numOfElem + 1 || pos <= 0)
			throw new IndexOutOfBoundsException();
		
		tmp = FindNode(pos-1);
		newnode = new Node(data, null);
		if (tmp == null) {
			head = newnode;
			numOfElem++;
		}
		newnode.next = tmp.next;
		tmp.next = newnode;
		numOfElem++;
	}
	
	public void Remove(int pos) {
		
		if (pos > numOfElem || pos <= 0)
			throw new IndexOutOfBoundsException();
		
		Node tmp;
		tmp = FindNode(pos-1);
		
		if (tmp == null) {
			head = head.next;
			numOfElem--;
			return;
		}
		tmp.next = tmp.next.next;
		numOfElem--;
	}
	
	private int Del(T ob, boolean All) {
		Node tmp;
		Node prev;
		tmp = head;
		prev = null;
		int count = 0;
		while (tmp.next != null) {
			if (tmp.data == ob) {
				if (prev == null) {
					head = head.next;
					tmp = tmp.next;
				}
				else {
					prev.next = tmp.next;
					tmp = tmp.next;
				}
				count++;
				numOfElem--;
				if (All == false) 
					return count;
			}
		}
		if (tmp.data == ob) {
			 
			if (prev == null) 
				return count;

			prev.next = null; 
			numOfElem--;
			count++;
		}
		return count;	
	}
	
	public void Remove(T ob) {
		Del(ob, false);
	}
	
	public int RemoveAll(T ob) {
		return Del(ob, true);
	}
	
	public T Get(int pos) {
		Node tmp;
		tmp = FindNode(pos);
		if (tmp == null)
			throw new IllegalArgumentException();
		return (T)tmp.data;
	}
	
	public int GetLength() {
		return numOfElem;
	}
	
	public void Print() {
		Node tmp;
		tmp = head;
		while (tmp.next != null) {
			System.out.println(tmp.data + "->");
		}
		System.out.println(tmp.data);
	}
	// Concatenate 2 linked lists
	// Merge 2 linked lists
	// Clone a linked list
	// Find loop 
	// Find where the loop starts ---- check
}
