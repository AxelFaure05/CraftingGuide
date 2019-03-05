package Modele.Exceptions;

public class ExceptionItemNonCorrespondant extends RuntimeException {
	
	public ExceptionItemNonCorrespondant() {
		System.out.println("Cet item ne peut pas entrer dans ce stack");
	}
}
