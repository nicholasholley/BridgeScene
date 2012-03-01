package stacks;

public interface GenericStack<T> {
	public void push(T item);
	public void pop();
	public int size();
	public T elementAt(int index);
	public boolean isEmpty();
	public boolean isFull();
	public void shiftUp(int startIndex);
	public void shiftDown(int startIndex);
	public void begin(T element);
}
