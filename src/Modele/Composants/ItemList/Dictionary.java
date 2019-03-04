package Modele.Composants.ItemList;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

import Modele.Composants.Item;

public class Dictionary implements Map<Character, Map<Character, Vector<Item>>> {

	public Dictionary() {
		
	}
	
	public void load(String file) {

		try {
			BufferedReader bR = new BufferedReader(new FileReader(file));
			String str = new String(bR.readLine());
			String[] arg;

			while(str!=null) {
				arg = str.split(":");
				this.put(new Item(
						Integer.valueOf(arg[0]),
						arg[1],
						Boolean.getBoolean(arg[2]),
						Boolean.getBoolean(arg[3]),
						Boolean.getBoolean(arg[4])));
				str = bR.readLine();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void clear() {
		
	}

	@Override
	public boolean containsKey(Object key) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsValue(Object value) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Set<Entry<Character, Map<Character, Vector<Item>>>> entrySet() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<Character, Vector<Item>> get(Object key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Set<Character> keySet() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<Character, Vector<Item>> put(Character key, Map<Character, Vector<Item>> value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void putAll(Map<? extends Character, ? extends Map<Character, Vector<Item>>> m) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Map<Character, Vector<Item>> remove(Object key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Collection<Map<Character, Vector<Item>>> values() {
		// TODO Auto-generated method stub
		return null;
	}

}
