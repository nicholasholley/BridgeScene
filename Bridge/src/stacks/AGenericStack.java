package stacks;

public class AGenericStack<T> implements GenericStack<T> {
	public final int MAX_SIZE = 250;
	int size;
	Object[] stack = new Object[MAX_SIZE];

	
	public void push(T item){
		if(!isFull()){
			stack[size] = item;
			size++;
			
		}
		else{System.out.println("Stack is full bro.");}
	}
	public void pop(){
		if(!isEmpty()){size--;
		}
		else{System.out.println("Stack is empty bro.");}
	}
	public int size(){
		return size;
	}
	public T elementAt(int index){
		return (T)stack[index];
	}
	public boolean isEmpty(){
		return size == 0;
	}
	public boolean isFull(){
		return size == 250;
	}
	public void shiftUp(int startIndex) {
		 for (int index = startIndex; index + 1 < size; index++) {
		        stack[index] = stack[index + 1];
		    }
		    size--;
	}
	public void shiftDown(int startIndex) {
		for (int index = size; index > 0; index--) {
	        stack[index] = stack[index-1];
	    }
	    size++;
	}
	public void begin(T element) {
		stack[0] = element;
	}
}
