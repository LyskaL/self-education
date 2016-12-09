package lyskal.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Main {
	
	public static void main(final String[] args) {
		Numbers numbers = new Numbers();
		
		System.out.println("Our Collaction: ");
		show(numbers.getCollection());
		
		List<Integer> addNumbers = new ArrayList<>();
		Numbers.generateNumbers(addNumbers, 10);
		
		System.out.println("List: ");
		show(addNumbers);
		
		numbers.add(addNumbers);
		numbers.sort();
		
		System.out.println("Concat: ");
		show(numbers.getCollection());
	}
	
	public static void show(final Collection<Integer> numbers) {
		for (Integer number : numbers) {
			System.out.print(number + "  ");
		}
		System.out.println();
	}
}