package Modele.Composants.Inventaire;

import java.io.Serializable;
import java.util.ArrayList;

import Modele.Composants.Stack;

public class Inventaire implements Serializable {
	
	Stack[] inventaire;
	int size;
	
	public Inventaire(int size) {
		this.inventaire = new Stack[size];
		this.size = size;
	}
	
	public void place(int indice, Stack stack) {
		this.inventaire[indice] = stack;
	}
	
	public void remove(int indice) {
		this.inventaire[indice] = null;
	}
	
	public void serialize() {
		
	}
	
	public Inventaire deserialize() {
		return null;
	}
}
