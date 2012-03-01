package tokens;

import stacks.ATokenHistory;
import stacks.TokenList;

public class TokenStateful {
	String input;
	TokenList hist = new ATokenHistory();
	
	public void setInput(String newInput) {
		input = newInput + " ";
		Input(input);
	}

	public TokenStateful(String a) {
		input = a;
		Input(input);
	}

	public String getInput() {
		return input;
	}

	public TokenList getOutput() {
		return hist;
	}

	public TokenList Input(String inputString) {
		int indexstring = 0;
		while (indexstring < inputString.length()) {
			if (Character.isDigit(inputString.charAt(indexstring))) {
				Token NU = new Number(inputString.substring(indexstring,Number(inputString, indexstring)));
				indexstring = Number(inputString, indexstring);
				hist.push(NU);
			}

			if (inputString.charAt(indexstring) == '"') {
				Token QU = new Quote(inputString.substring(indexstring + 1,
						Quote(inputString, indexstring)));
				indexstring = Quote(inputString, indexstring);
				hist.push(QU);
			}

			if (Character.isLetter(inputString.charAt(indexstring))) {
				Token DU;
				DU = type(inputString.substring(indexstring,Command(inputString, indexstring)));
				indexstring = Command(inputString, indexstring); 
				hist.push(DU);
			} 

			else if (inputString.charAt(indexstring) == ' '
					|| inputString.charAt(indexstring) == '"') {
				indexstring++;
			}
			else if (inputString.charAt(indexstring) == '+') {
						indexstring++;
			} else if (inputString.charAt(indexstring) == '-') {
				indexstring++;
			}
			else {
				System.out.println("Illegal: "
						+ inputString.charAt(indexstring));
				indexstring++;
			}
		}
		return hist;
	}

	private static int Number(String inputString, int index) {
		int indexright = index + 1; 
		char inputChar = inputString.charAt(indexright); 
		while (Character.isDigit(inputChar)) {
			indexright++;
			inputChar = inputString.charAt(indexright);
		}
		return indexright;
	}

	private static int Quote(String inputString, int index) {
		int indexright = index + 1; 
		char inputChar = inputString.charAt(indexright); 
		while (inputChar != '"') {
			indexright++;
			inputChar = inputString.charAt(indexright);
		}
		return indexright;
	}

	private static int Command(String inputString, int index) {
		int indexright = index + 1;
		char inputChar = inputString.charAt(indexright); 
		while (Character.isLetter(inputChar)) { 
			indexright++;
			inputChar = inputString.charAt(indexright);
		}
		return indexright;
	}
	
	private static Command type(String inputString) {
		Command CU;
		if (inputString.equals("Move") || inputString.equals("move")
				|| inputString.equals("mov") || inputString.equals("mv")) {
			CU = new Move(inputString);
		}
		else if (inputString.equals("Say") || inputString.equals("say")
				|| inputString.equals("sy") || inputString.equals("SAy")) {
			CU = new Say(inputString);
		}
		else if (inputString.equals("Passed") || inputString.equals("passed")
				|| inputString.equals("Pass") || inputString.equals("pass")
				|| inputString.equals("ps")) {
			CU = new Passed(inputString);
		}
		else if (inputString.equals("Failed") || inputString.equals("failed")
				|| inputString.equals("Fail") || inputString.equals("fail")
				|| inputString.equals("fai")) {
			CU = new Failed(inputString);
		}
		else if (inputString.equals("Undo") || inputString.equals("undo")
				|| inputString.equals("Un") || inputString.equals("un")) {
			CU = new Undo(inputString);
		}
		else if (inputString.equals("Redo") || inputString.equals("redo")
				|| inputString.equals("Re") || inputString.equals("re")) {
			CU = new Redo(inputString);
		} else if (inputString.equals("Animate") || inputString.equals("animate")
				|| inputString.equals("anim") || inputString.equals("danceparty")) {
			CU = new Animate(inputString);
		}
		else {
			CU = new Command(inputString);
		}
		return CU;
	}
}
