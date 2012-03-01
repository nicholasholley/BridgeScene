package stacks;
import tokens.Token;

public interface TokenList {
	public int size();
	public Token elementAt(int index);
	public void push(Token element);
	public void pop();
}
