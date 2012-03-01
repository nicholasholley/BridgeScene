package stacks;

import java.util.ArrayList;

import shapesAtomic.Label;
import util.models.VectorChangeEvent;
import util.models.VectorListener;

public class ATransparentLabelStack extends AGenericStack<Label> {
	public Label elementAt(int index) {
		return (Label) stack[index];
	}
	ArrayList<VectorListener> observers = new ArrayList<VectorListener>();

	public void addVectorListener(VectorListener listener) {
		if (!observers.contains(listener)) {
			observers.add(listener);
		}
	}

	void notifyAllListeners(VectorChangeEvent event) {
		for (int i = 0; i < observers.size(); i++) {
			observers.get(i).updateVector(event);
		}
	}
	public void push(Label item){
		if(!isFull()){
			stack[size] = item;
			notifyAllListeners(new VectorChangeEvent(this,
					VectorChangeEvent.AddComponentEvent, size() - 1, null,
					item, size()));
			size++;
		}
		else{System.out.println("Stack is full bro.");}
	}
	public void pop(){
		if(!isEmpty()){
			Label old = peek();
			size--;
			notifyAllListeners(new VectorChangeEvent(this,
				VectorChangeEvent.DeleteComponentEvent, size()+1, old, null,
				size()));
		}
		else{System.out.println("Stack is empty bro.");}
	}
	Label peek(){
		return elementAt(size());
	}
}
