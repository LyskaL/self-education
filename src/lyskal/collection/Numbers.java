package lyskal.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;

public class Numbers {
	private Collection<Integer> _numbers;
	private static final int DEFAULT_SIZE = 5;

	public Numbers() {
		init(DEFAULT_SIZE);
	}
	
	public Numbers(final int size) {
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
		return Collections.unmodifiableCollection(_numbers);
	}
	
	public void sort() {
		List<Integer> sortedList = new ArrayList<>(_numbers);
		Collections.sort(sortedList);
		_numbers = new LinkedHashSet<>(sortedList);
	}
}
