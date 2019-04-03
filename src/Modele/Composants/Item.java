package Modele.Composants;

import java.io.Serializable;

public class Item implements Comparable<Item>, Serializable {
	
	private int ID;
	private String name, lien_image;
	private boolean isCraftable, isStackable, asFixedCraft;
	
	public Item(int ID, String name, String link, boolean isCraftable, boolean isStackable, boolean asFixedCraft) {
		
		this.setID(ID);
		this.setName(name);
		this.setLien(link);
		this.setCraftable(isCraftable);
		this.setStackable(isStackable);
		this.setFixedCraft(asFixedCraft);
	}
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getName() {
		return name.split(":")[1];
	}
	public void setName(String name) {
		this.name = "minecraft:" + name.toLowerCase();
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
	public boolean asFixedCraft() {
		return asFixedCraft;
	}
	public void setFixedCraft(boolean asFixedCraft) {
		this.asFixedCraft = asFixedCraft;
	}
	@Override
	public int compareTo(Item o) {
		if(this.name.compareTo(o.name)>0) return 1;
		if(this.name.compareTo(o.name)<0) return -1;
		return 0;
	}
	public boolean equals(Item it) {
		return this.ID == it.ID && this.name == it.name && this.isStackable == it.isStackable && this.isCraftable == it.isCraftable && this.asFixedCraft == it.asFixedCraft;
	}

	public String getLien() {
		return lien_image;
	}

	public void setLien(String lien_image) {
		this.lien_image = lien_image;
	}
}
