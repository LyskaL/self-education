package lyskal.set.treeset.example1;

import java.util.SortedSet;
import java.util.TreeSet;

public class Main {

	public static void main(final String[] args) {
		Country ukraine = new Country("Ukraine");
		Country russia = new Country("Russia");
		Country england = new Country("England");
		Country italy = new Country("Italy");
		Country russia2 = new Country("Russia");
		
		SortedSet<Country> countries = new TreeSet<>();
		countries.add(ukraine);
		countries.add(russia);
		countries.add(england);
		countries.add(italy);
		countries.add(russia2); //Country is not added
		
		for (Country country : countries) {
			System.out.println(country);
		}
	}
}