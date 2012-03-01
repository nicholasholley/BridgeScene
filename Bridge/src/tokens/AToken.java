package tokens;

public abstract class AToken implements Token {

	String stringValue, stringDescrip;
	public String getStringValue() {
		return stringValue.toLowerCase();
	}
	public AToken(String input, String descrip){
		stringValue = input;
		stringDescrip =/* " " + */descrip;
	}

	public String getDescription() {
		return stringDescrip;
	}
	public String toString(){
		return stringValue;
	}

}
