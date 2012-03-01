package tokens;

public class Number extends AToken {
	int num;
	public Number(String input){
		super(input,"Number");
		num = Integer.parseInt(input);
	}
	public int getInteger(){
		return num;
	}
}
