package Modele;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Observable;

import Modele.Composants.Stack;
import Modele.Composants.Craft;
import Modele.Structures.CraftList;
import Modele.Structures.CraftListReversed;
import Modele.Structures.Inventory;
import Modele.Structures.ItemList;
import Modele.Structures.StackMatrix;

public class Modele extends Observable implements Serializable {
	
	public Inventory inventaireSurvie;
	public ItemList fullItemList;
	public StackMatrix tableDeCraft;
	public StackMatrix resultatCraft;
	public CraftList fullCraftList;
	public CraftListReversed fullCraftListReversed;
	
	public final static int invSize = 81;
	private final static String DATA = "./Data/DATA.dat"; 
	
	public Modele() {
		try {
			if(this.deserialize()==null) {
				throw new RuntimeException();
			} 
			System.out.println("Deserialized!");
		} catch (Exception e){
			System.out.println("Could not deserialize!");
			this.inventaireSurvie = new Inventory();
			this.fullItemList = new ItemList(ItemList.getRawlist());
			this.fullCraftList = new CraftList(this.fullItemList);
			this.fullCraftListReversed = new CraftListReversed(this.fullItemList);
		}
		
		this.tableDeCraft = new StackMatrix(9);
		this.resultatCraft = new StackMatrix(1);
	}
	
	public Stack getStackFromFullList(String itemName) {
		try {
			return new Stack(this.fullItemList.research(itemName, true).racine(), 1);
		} catch(Exception e) {
			return null;
		}
	}
	
	public Stack putInUncraftSlot(Stack stack) {
		if(this.resultatCraft != null) {
			Stack prev = this.resultatCraft.getStackAt(0);
			this.resultatCraft.add(stack, 0);
			return prev;
		}
		this.resultatCraft.add(stack, 0);
		this.Uncraft();
		return null;
		
	}
	public Stack putInTableSlot(int ind, Stack stack) {
		if(this.tableDeCraft.getStackAt(ind) != null) {
			Stack prev = this.tableDeCraft.getStackAt(0);
			this.tableDeCraft.add(stack, ind);
			return prev;
		}
		this.tableDeCraft.add(stack, ind);
		this.Craft();
		return null;
	}
	public Stack putInInv(int ind, Stack stack) {
		if(this.inventaireSurvie.get(ind) != null) {
			Stack prev = this.inventaireSurvie.get(ind);
			this.inventaireSurvie.set(ind, stack);
			return prev;
		}
		this.inventaireSurvie.set(ind, stack);
		return null;
	}
	
	public void Craft() {
		Craft craft = new Craft(this.tableDeCraft);
		String itemName = this.fullCraftList.get(craft);
		if(itemName != null) {
			this.resultatCraft = new StackMatrix(new Stack(this.fullItemList.research(itemName, true).racine(), 1), 1);
			this.hasChanged();
			this.notifyObservers();
		}
	}
	
	public void Uncraft() {
		Craft resultat = this.fullCraftListReversed.get(this.resultatCraft.getStackAt(0).getItem().getName());
		if(resultat != null) {
			this.tableDeCraft = resultat;
			this.hasChanged();
			this.notifyObservers();
		}
	}
	
	private void serialize() {
		try {
			FileOutputStream fos = new FileOutputStream(new File(Modele.DATA));
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(this);
			oos.close();
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public Modele deserialize() {
		try {
			FileInputStream fos = new FileInputStream(new File(Modele.DATA));
			ObjectInputStream oos = new ObjectInputStream(fos);
			Modele modl;
			modl = (Modele)oos.readObject();
			oos.close();
			fos.close();
			return modl;
		} catch (Exception e) {
			return null;
		}
	}
}
