package Modele.Exceptions;

public class ExceptionStackOverflow extends RuntimeException {
	
	public ExceptionStackOverflow() {
		System.out.println("Limite d'item dépassée");
	}
}
