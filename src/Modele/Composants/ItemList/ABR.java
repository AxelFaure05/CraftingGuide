package Modele.Composants.ItemList;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import Modele.Exceptions.ExceptionArbreVide;

public class ABR<E> implements Iterable<E>, Serializable{
	
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
	
	public int balance() {
		return this.arbD.hauteur()-this.arbG.hauteur();
	}
	
	public ArrayList<E> parcoursProfondeurRecursif(ABR<E> ab) {
		ArrayList<E> l = new ArrayList<E>();
		if (!ab.estVide()) {
			if (!ab.sag().estVide()) l.addAll(parcoursProfondeurRecursif(ab.sag()));
			if (!ab.sad().estVide()) l.addAll(parcoursProfondeurRecursif(ab.sad()));
			l.add(ab.racine());
		}
		return l;
	}

	@Override
	public Iterator<E> iterator() {
		return parcoursProfondeurRecursif(this).iterator();
	}

}
