package tokens;

import sceneBuild.AComplexScene;
import stacks.TokenList;

public class Parser {
	String input;
	AComplexScene scene;
	TokenStateful state;
	int place = 0;

	public Parser(AComplexScene a, String b) {
		state = new TokenStateful(b);
		scene = a;
	}
	
	public String getInput(){
		return state.getInput();
	}
	
	public TokenList getOuptut(){
		return state.getOutput();
	}
	
	public void setInput(String newInput) {
		state.setInput(newInput);

		while (place < state.hist.size()) {
			if (state.hist.elementAt(place) instanceof Passed) {
				scene.leadKnightPasses();
			} else if (state.hist.elementAt(place) instanceof Failed) {
				scene.fail();
			} else if (state.hist.elementAt(place) instanceof Say) {
				place++;
				if (state.hist.elementAt(place) instanceof Quote) {
					scene.speak(state.hist.elementAt(place).getStringValue());
				}
			} else if (state.hist.elementAt(place) instanceof Move) {
				place++;
				if (state.hist.elementAt(place) instanceof Number) {
					scene.moveApproachingX(
							(((tokens.Number) state.hist.elementAt(place)).getInteger()));
				}
			} else if (state.hist.elementAt(place) instanceof Animate){
				scene.changeAnimate();
			}else if (state.hist.elementAt(place) instanceof Undo){
				scene.undo();
			}else if (state.hist.elementAt(place) instanceof Redo){
				scene.redo();
			}
			
			place++;
		}
	}

}
