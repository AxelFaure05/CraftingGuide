package Modele.Composants;

import java.io.Serializable;

public class Item implements Comparable<Item>, Serializable {
	
	private int ID;
	private String name;
	private boolean isCraftable, isStackable, isGhost;
	
	public Item(int ID, String name, boolean isCraftable, boolean isStackable, boolean isGhost) {
		
		this.setID(ID);
		this.setName(name);
		this.setCraftable(isCraftable);
		this.setStackable(isStackable);
		this.setGhost(isGhost);
	}
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isCraftable() {
		return isCraftable;
	}
	public void setCraftable(boolean isCraftable) {
		this.isCraftable = isCraftable;
	}
	public boolean isStackable() {
		return isStackable;
	}
	public void setStackable(boolean isStackable) {
		this.isStackable = isStackable;
	}
	public boolean isGhost() {
		return isGhost;
	}
	public void setGhost(boolean isGhost) {
		this.isGhost = isGhost;
	}
	@Override
	public int compareTo(Item o) {
		if(this.name.compareTo(o.name)>0) return 1;
		if(this.name.compareTo(o.name)<0) return -1;
		return 0;
	}
}
