
public interface List<T> {
	void Add(T ob);
	void Add(T ob, int index);
	void Remove(int index);
	void Remove(T ob);
	int RemoveAll(T ob);
	T Get(int index);
	void Print();
};