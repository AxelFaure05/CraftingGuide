package Modele.Composants;

public class Stack {
	
	int count;
	Item item;
	
	public Stack(Item item, int count) {
		
		this.setItem(item);
		this.setCount(count);
	}
	
	public void remove(int removedCount) {
		try {
			if(this.count-removedCount<0) {
				throw new RuntimeException("Tried to remove more item than there is");
			}
		} catch(Exception e) {
			e.printStackTrace();
		}	
	}

	public void add(Item item, int addedCount) {
		try {
			if(this.item!=item) {
				throw new RuntimeException("Cannot stack different items");
			} else if(this.count==64) {
				throw new RuntimeException("Cannot stack over 64 items");
			} else {
				this.count+=addedCount;
			}
			
		} catch(Exception e) {
			e.printStackTrace();
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
