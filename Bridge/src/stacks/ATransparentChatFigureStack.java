package stacks;

import shapesComposite.FigureWithChat;

public class ATransparentChatFigureStack extends AGenericStack<FigureWithChat> {
	public FigureWithChat elementAt(int index) {
		return (FigureWithChat) stack[index];
	}

	public void push(FigureWithChat element) {
		stack[size] = element;
		if(size != MAX_SIZE){
			size++;
		}
	}
	public void begin(FigureWithChat element){
		stack[0] = element;
		
	}
}
