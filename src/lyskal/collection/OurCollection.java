package lyskal.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class OurCollection {
	private Collection<Integer> _numbers;
	private static final int DEFAULT_SIZE = 5;

	public OurCollection() {
		init(DEFAULT_SIZE);
	}
	
	public OurCollection(final int size) {
		init(size);
	}
	
	private void init(int size){
		if(size <= 0) {
			size = DEFAULT_SIZE;
		}
		_numbers = new HashSet<>();
		generateNumbers(_numbers, size);
	}
	
	public static void generateNumbers(final Collection<Integer> numbers, final int size) {
		for (int i = 0; i < size; i++) {
			numbers.add((int)(Math.random()*20)+1);
		}
	}
	
	public void add(final Integer number) {
		if(number != null){
			_numbers.add(number);
		}
	}
	
	public void add(final Collection<Integer> numbers) {
		if(numbers != null){
			_numbers.addAll(numbers);
		}
	}
	
	public Collection<Integer> getCollection() {
		return _numbers;
	}
	
	public void sort() {
		List<Integer> sortedList = new ArrayList<>(_numbers);
		Collections.sort(sortedList);
		_numbers = new HashSet<>(sortedList);
	}
}
