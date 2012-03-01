package tokens;

public class Assignment4 {
	public static void main(String[] args) {
		StatefulInterface sF = new Stateful(args[0]);
		
		System.out.println(sF.getOutput());
		
}
}
