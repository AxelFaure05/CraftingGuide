package Modele.Composants;

import Modele.Exceptions.ExceptionItemNonCorrespondant;
import Modele.Exceptions.ExceptionItemNonStackable;
import Modele.Exceptions.ExceptionStackOverflow;

public class Stack {
	
	int count;
	Item item;
	
	public Stack(Item item, int count) {
		
		try {
			if(!item.isStackable()) {
				throw new ExceptionItemNonStackable();
			} else {
				this.setItem(item);
				this.setCount(count);
			}
		} catch(ExceptionItemNonStackable e) {
			e.printStackTrace();
		}
	}
	
	public boolean remove(int removedCount) {
		try {
			if(this.count-removedCount<0) {
				throw new RuntimeException("Tried to remove more item than there is");
			} else {
				this.count -= removedCount;
				return true;
			}
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		}	
	}

	public boolean add(Item item, int addedCount) {
		try {
			if(this.item!=item) {
				throw new ExceptionItemNonCorrespondant();
			} else if(this.count==64) {
				throw new ExceptionStackOverflow();
			} else {
				this.count+=addedCount;
				return true;
			}
			
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
}
