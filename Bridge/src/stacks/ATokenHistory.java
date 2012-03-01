package stacks;
import tokens.Token;

public class ATokenHistory implements TokenList {
	private int size = 0;
	final int MAX = 50;
	Token stack[] = new Token[50];
	
	public int size() {
		return size;
	}

	public Token elementAt(int index) {
		return stack[index];
	}

	public void push(Token element) {
		stack[size] = element;
		if(size != MAX){
			size++;
		}
	}

	public void pop() {
		size--;
	}
}
