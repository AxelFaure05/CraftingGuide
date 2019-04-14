package Modele.Composants;

import java.io.Serializable;

public class Stack implements Serializable {
	
	private Item item;
	private int count;
	
	public Stack(Item item, int count) {
		this.setItem(item);
		this.setCount(count);
	}

	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	@Override
	public int hashCode() {
		return this.item.hashCode();
	}
}

