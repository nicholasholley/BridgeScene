package main;

import sceneBuild.AComplexScene;
import tokens.Parser;
import bus.uigen.OEFrame;
import bus.uigen.ObjectEditor;

public class Assignment12 {
	public static void main(String[] args) {
		AComplexScene cS = new AComplexScene(135, 120, 20, 20);
				
		Parser pA = new Parser (cS, "");
		ObjectEditor.edit(pA); 
				
		OEFrame twoframe = ObjectEditor.edit(cS); 
		twoframe.hideMainPanel(); 
		twoframe.setSize(1100, 600);
		
		cS.addNotPassed("Arthur", "I am king.");
		cS.addNotPassed("Robin", "");
		cS.addNotPassed("Lancelot", "");
		

	}
	
}