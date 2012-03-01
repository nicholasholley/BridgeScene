package collections;

import java.util.ArrayList;

import shapesComposite.AGuardWithChat;
import shapesComposite.AKnightWithChat;
import shapesComposite.FigureWithChat;
import stacks.ATransparentChatFigureStack;
import util.models.VectorChangeEvent;
import util.models.VectorListener;

public class AFallenAvatars implements FallenAvatars {
		int x, y, width, height;
		private ATransparentChatFigureStack stackB = new ATransparentChatFigureStack();

		public AFallenAvatars(int initX, int initY, int initWidth, int initHeight){
			x = initX;
			y = initY;
			width = initHeight;
			height = initWidth;
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
		
		public int getX() {
			return x;
		}

		public void setX(int newVal) {
			x = newVal;
			for (int i = 0; i < stackB.size(); i++) {
				stackB.elementAt(i).setX(x + width*3 * i);
			}
		}

		public int getY() {
			return y;
		}

		public void setY(int newVal) {
			y = newVal;
			for (int i = 0; i < stackB.size(); i++) {
				stackB.elementAt(i).setY(y);

			}
		}

		public int getHeight() {
			return height;
		}

		public int getWidth() {
			return width;
		}

		public void removeLatest() {
			stackB.pop();
		}

		public void addToEnd(int type, String aName, String aThought) {
			x = x + width*3;
			if(type == 0){
				AKnightWithChat dude = new AKnightWithChat(x,y,width,height, aName, aThought);
				stackB.push(dude);
				notifyAllListeners(new VectorChangeEvent(this,
						VectorChangeEvent.AddComponentEvent, stackB.size() - 1, null,
						dude, stackB.size()));
			}
			if(type == 1){
				AGuardWithChat dude = new AGuardWithChat(x,y,width,height, aName, aThought);
				stackB.push(dude);
				notifyAllListeners(new VectorChangeEvent(this,
						VectorChangeEvent.AddComponentEvent, stackB.size() - 1, null,
						dude, stackB.size()));
			}
		}

		public ATransparentChatFigureStack getStackB() {
			return stackB;
			
		}
		public void addToFrontDos(FigureWithChat theKnight) {
			x = x - width*3 * stackB.size();
			stackB.shiftDown(0);
			stackB.begin(theKnight);
			notifyAllListeners(new VectorChangeEvent(this,
					VectorChangeEvent.AddComponentEvent, stackB.size() - 1, null,
					theKnight, stackB.size()));
		}
	
}
