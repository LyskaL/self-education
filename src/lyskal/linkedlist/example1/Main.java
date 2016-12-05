package lyskal.linkedlist.example1;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Main {

	public static void main(final String[] args) {
		List<String> list = new LinkedList<>();
		list.add("1. Lyuda");
		list.add("2. Irina");
		list.add("3. Maria");
		ListIterator<String> iterator = list.listIterator();
		iterator.next();
		iterator.add("4. Max");
		iterator.next();
		iterator.next();
		iterator.add("5. Tom");
		iterator.previous();
		iterator.previous();
		iterator.add("6. Nick");
		
		for (String string : list) {
			System.out.println(string.toString());
		}
	}
}
