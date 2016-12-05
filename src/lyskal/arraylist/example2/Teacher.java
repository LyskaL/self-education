package lyskal.arraylist.example2;

import java.util.ArrayList;

public class Teacher {
	private String _name;
	private ArrayList<String> _items;
	private static final int SEARCH_ERROR = -1;
	
	public Teacher(final String name){
		if(name != null) {
			_name = name;
			_items = new ArrayList<>();
		}
	}
	
	public String getName() {
		return _name;
	}
	
	public void addItems(final String item) {
		_items.add(item);
	}
	
	public void removeItem(final String item) {
		int index = _items.indexOf(item);
		if(index != SEARCH_ERROR) {
			_items.remove(index);
		}
	}
	
	@Override
	public String toString() {
		StringBuilder temp = new StringBuilder("Name: " + _name + 
						" Numbet items " + getNumberItems() + ". ");
		int indexIntem = 0;
		for (String string : _items) {
			temp.append((++indexIntem) + "." + string + ";");
		}
		return temp.toString();
	}

	public int getNumberItems(){
		return _items.size();
	}
	
}
