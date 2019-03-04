package Modele.Composants.ItemList;

import Modele.Exceptions.ExceptionArbreVide;

public class ABR<E> {
	
	E element;
	ABR<E> arbG;
	ABR<E> arbD;
	
	public ABR() {
		this.element = null;
		this.arbD = null;
		this.arbG = null;
	}
	
	public ABR(E elem, ABR<E> arbG, ABR<E> arbD) {
		this.element = elem;
		this.arbD = arbD;
		this.arbG = arbG;
	}
	
	
	public boolean estVide() {
		return this.element==null;
	}

	public E racine() {
		if (this.estVide()) throw new ExceptionArbreVide();
		return this.element;
	}

	public ABR<E> sag() {
		if (this.estVide()) throw new ExceptionArbreVide();
		return this.arbG;
	}

	public ABR<E> sad() {
		if (this.estVide()) throw new ExceptionArbreVide();
		return this.arbD;
	}

	public int taille() {
		if (this.estVide()) return 0;
		else return 1 + this.sag().taille() + this.sad().taille();
	}

	public int hauteur() {
		if (this.estVide()) return 0;
		else return 1 + Math.max(this.sag().hauteur(), this.sad().hauteur());
	}
}
