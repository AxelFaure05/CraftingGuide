package Modele.Exceptions;

public class ExceptionStackOverflow extends RuntimeException {
	
	public ExceptionStackOverflow() {
		System.out.println("Limite d'item d�pass�e");
	}
}
