package model;

public class Equation {
	
	public static final boolean OBJECTIVE= true;
	public static final boolean RESTRICTION = false;
	
	private double equality;
	private boolean type;
	private Variable [] variables;
	/**
	 * pre: los simbolos, los coeficiente y los tipos de variables respectivamente vienen separados por espacios " "
	 * @param ecua
	 */
	public Equation (String ecua) {
		String[] SimbYNum = ecua.split(" ");
		variables = new Variable[SimbYNum.length];
		for (int i = 0; i < variables.length; i+=3) {
			variables[i] = new Variable(SimbYNum[i].equals("+"),Double.parseDouble(SimbYNum[i+1]), Byte.parseByte(SimbYNum[i+2]));
		}
	}
}


//+ 1 z = + 2 x1 - 3 x2