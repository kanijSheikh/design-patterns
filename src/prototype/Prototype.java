package prototype;

public class Prototype implements Cloneable{

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	public static void main(String[] args) throws CloneNotSupportedException {
		Prototype prototype1 = new Prototype();
		
		Prototype prototype2 = (Prototype) prototype1.clone();
		
		System.out.println(prototype1);
		System.out.println(prototype2);
	}

}
