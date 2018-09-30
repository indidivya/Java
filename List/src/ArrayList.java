import java.util.Arrays;

public class ArrayList<T> implements List<T> {
	int numOfElem;
	int maxCount;
	Object[] array;
	
	public ArrayList() {
		numOfElem = 0;
		maxCount = 10;
		array = new Object[10];
	}
	public ArrayList(int size) {
		numOfElem = 0;
		maxCount = size;
		array = new Object[size];		
	}
	
	private void expand(int increaseBy) {
		Object[] tmpArray = Arrays.copyOf(array, maxCount+increaseBy);
		array = tmpArray;
		maxCount+=increaseBy;
	}
	
	private void Move(int index) {
		int tmp;
		tmp = numOfElem;
		if (numOfElem == maxCount) 
			expand(10);
		while (tmp > index) {
			array[tmp] = array[tmp-1];
			tmp--;
		}
		return;
	}
	
	public void Add(T ob, int index) {
		if (index >= numOfElem)
			throw new IndexOutOfBoundsException();
		
		Move(index);
 		array[index] = ob;
		numOfElem++;
	}
	
	public void Add(T ob) { 
		if (numOfElem == maxCount) 
			expand(10);
		
		array[numOfElem++] = ob;
	}
	
	private void Fill(int index) {
		int tmp;
		tmp = index;
		while (tmp < numOfElem-1) {
			array[tmp] = array[tmp+1];
			tmp++;
		}
		array[numOfElem-1] = null;
	}
	public void Remove(int index) {
		if (index < 0 || index >= numOfElem)
			throw new IndexOutOfBoundsException();
		
		Fill(index);
		numOfElem--;
	}
	
	private int Find(T ob, int startAt) {
		int i = startAt;
		while (i < numOfElem) {
			if (array[i] == ob) {
				Fill(i);
				numOfElem--;
				return i;
			}
			i++;
		}
		return -1;
	}
	
	public void Remove(T ob) {
		int ret;
		ret = Find(ob, 0);
		if (ret < 0) 
			System.out.println("Object Not Found");
		return;
	}
	
	public int RemoveAll(T ob) {
		int ret;
		int i = 0;
		int delCount = 0;
		while (i < numOfElem) {
			ret = Find(ob, i);
			if (ret < 0) 
				break;
			i = ret;
			delCount++;
		}
		return delCount;
	}
	
	public T Get(int index) {
		if (index >= numOfElem)
			throw new IndexOutOfBoundsException();
		return (T)array[index];
	}
	
	public void Print() {
		int i;
		for (i=0; i<numOfElem; i++) {
			System.out.println(array[i] + " ");
		}
	}
	
}
