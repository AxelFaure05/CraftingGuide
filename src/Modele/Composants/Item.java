package Modele.Composants;

import java.io.Serializable;

public class Item implements Serializable {
	
	private int ID;
	private String name;
	private String imLink;
	private boolean isStackable;
	
	public Item(int ID, String name, String imLink, boolean isStackable) {
		this.setID(ID);
		this.setName(name.toLowerCase());
		this.setImLink(imLink);
		this.setStackable(isStackable);
	}

	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		this.ID = iD;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImLink() {
		return imLink;
	}
	public void setImLink(String imLink) {
		this.imLink = imLink;
	}
	public boolean isStackable() {
		return isStackable;
	}
	public void setStackable(boolean isStackable) {
		this.isStackable = isStackable;
	}
	public int compareTo(Item o) {
		if(this.name.compareTo(o.name)>0) return 1;
		if(this.name.compareTo(o.name)<0) return -1;
		return 0;
	}
	@Override
	public boolean equals(Object it) {
		if(!(it instanceof Item)) return false;
		return this.getName().equals(((Item)it).getName());
	}
	@Override
	public int hashCode() {
		return this.ID + this.getName().hashCode();
	}
}
