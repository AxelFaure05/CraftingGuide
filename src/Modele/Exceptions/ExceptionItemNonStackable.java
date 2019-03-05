package Modele.Exceptions;

public class ExceptionItemNonStackable extends RuntimeException {

	public ExceptionItemNonStackable() {
		System.out.println("Cet item n'est pas stackable!");
	}
}
