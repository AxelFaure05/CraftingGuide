package Modele.Composants.Inventaire;

import java.util.ArrayList;

import Modele.Composants.Stack;

public class Inventaire extends ArrayList<Stack[]> {
	
	int rows, columns;
	
	public Inventaire(int rows, int columns) {
		super();
		for(int k = 0; k<rows; k++) {
			this.add(k, new Stack[columns]);
		}
	}
	
	public void place(int row, int column, Stack stack) {
		this.get(row)[column] = stack;
	}
	
	public void remove(int row, int column) {
		this.place(row, column, null);
	}
	
}
