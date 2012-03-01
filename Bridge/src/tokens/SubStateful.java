package tokens;

public class SubStateful extends Stateful {
	public SubStateful(String input) {
		super(input);
	}

	Token CaptainAmerica(String inputString) {
		Token CU;
		if (inputString.equals("Move") || inputString.equals("move")
				|| inputString.equals("mov") || inputString.equals("mv")) {
			CU = new Move(inputString);
		}
		if (inputString.equals("Say") || inputString.equals("say")
				|| inputString.equals("sy") || inputString.equals("SAy")) {
			CU = new Say(inputString);
		}
		if (inputString.equals("Passed") || inputString.equals("passed")
				|| inputString.equals("Pass") || inputString.equals("pass")
				|| inputString.equals("ps")) {
			CU = new Passed(inputString);
		}
		if (inputString.equals("Failed") || inputString.equals("failed")
				|| inputString.equals("Fail") || inputString.equals("fail")
				|| inputString.equals("fai")) {
			CU = new Failed(inputString);
		}
		if (inputString.equals("Undo") || inputString.equals("undo")
				|| inputString.equals("Un") || inputString.equals("un")) {
			CU = new Undo(inputString);
		}
		if (inputString.equals("Redo") || inputString.equals("redo")
				|| inputString.equals("Re") || inputString.equals("re")) {
			CU = new Redo(inputString);
		} else {
			CU = new Command(inputString);
		}
		return CU;
	}
}
