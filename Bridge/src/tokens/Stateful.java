package tokens;

public class Stateful implements StatefulInterface {
	String input, output;
	
	public void setInput(String newInput) {
		input = newInput;
		output = Input(input);
	}

	public Stateful(String a) {
		input = a;
		output = Input(input);
	}

	public String getInput() {
		return input;
	}

	public String getOutput() {
		return output;
	}

	public String Input(String inputString) {
		int indexstring = 0;
		String lessString = "";
		while (indexstring < inputString.length()) {
			if (Character.isDigit(inputString.charAt(indexstring))) {
				Token NU = new Number(inputString.substring(indexstring,
						Number(inputString, indexstring)));
				indexstring = Number(inputString, indexstring);
				lessString = lessString + NU.getDescription() + ": "+ NU.getStringValue();
			}

			if (inputString.charAt(indexstring) == '"') {
				Token QU = new Quote(inputString.substring(indexstring + 1,
						Quote(inputString, indexstring)));
				indexstring = Quote(inputString, indexstring);
				lessString = lessString + QU.getDescription() + ": "+ QU.getStringValue();
			}

			if (Character.isLetter(inputString.charAt(indexstring))) {
				Token DU;
				DU = CaptainAmerica(inputString.substring(indexstring,Command(inputString, indexstring)));
				indexstring = Command(inputString, indexstring); 
				lessString = lessString + DU.getDescription() + ": " + DU.getStringValue();
			} 

			else if (inputString.charAt(indexstring) == ' '
					|| inputString.charAt(indexstring) == '"') {
				indexstring++;
			}
			// if the character is a space or double quote, skip it and continue
			// to the next character
			else if (inputString.charAt(indexstring) == '+') {
				// System.out.println("Plus: " +
				// inputString.charAt(indexstring));
				indexstring++;
			} else if (inputString.charAt(indexstring) == '-') {
				// System.out.println("Minus: " +
				// inputString.charAt(indexstring));
				indexstring++;
			}
			// extra credit, print out plus and minus in the main argument
			else {
				System.out.println("Illegal: "
						+ inputString.charAt(indexstring));
				indexstring++;
			}
			// if the character is illegal, print it and treat it as a space
		}
		return lessString;
	}

	private static int Number(String inputString, int index) {
		int indexright = index + 1; // index for the right hand value in the
									// substring
		char inputChar = inputString.charAt(indexright); // looks at the
															// character at
															// indexright
		while (Character.isDigit(inputChar)) { // every time the string is a
												// digit, indexright increases.
												// When an illegal character is
												// encountered, inputChar is
												// restarted.
			indexright++;
			inputChar = inputString.charAt(indexright);
		}
		return indexright;
	}

	private static int Quote(String inputString, int index) {
		int indexright = index + 1; // index for the right hand value in the
									// substring
		char inputChar = inputString.charAt(indexright); // looks at the
															// character at
															// indexright
		while (inputChar != '"') {
			indexright++;
			inputChar = inputString.charAt(indexright);
		}
		return indexright;
	}

	private static int Command(String inputString, int index) {
		int indexright = index + 1; // index for the right hand value in the
									// substring
		char inputChar = inputString.charAt(indexright); // looks at the
															// character at
															// indexright
		while (Character.isLetter(inputChar)) { // every time the string is a
												// digit, indexright increases.
												// When an illegal character is
												// encountered, inputChar is
												// restarted.
			indexright++;
			inputChar = inputString.charAt(indexright);
		}
		return indexright;
	}
	Token CaptainAmerica(String inputString){
		Token CU = new Command(inputString);
		return CU;
		}
}
