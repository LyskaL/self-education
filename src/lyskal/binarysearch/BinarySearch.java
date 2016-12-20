package lyskal.binarysearch;

import java.util.Arrays;

public class BinarySearch {
	public static final int ERROR_SEARCH = -1;

	public static void main(final String[] args) {
		int[] array = new int[] {5, -6, 1, 8, -4, 56, -7, 20, 4, 6, 89};
		final int findNumber = 20;
		
		sort(array);
		System.out.println(Arrays.toString(array));
		
		System.out.println("Index " + findNumber + " = " +  binarySearch(array, findNumber));
	}
	
	public static void sort(final int[] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = array.length-1; j > i; j--) {
				if(array[i] > array[j]) {
					swap(array, i, j);
				}
			}
		}
	}
	
	public static void swap(final int[] array, final int fromIndex, final int toIndex) {
		int temp = array[fromIndex];
		array[fromIndex] = array[toIndex];
		array[toIndex] = temp;
	}
	
	public static int binarySearch(final int[] array, final int number) {
		return binarySearch(array, 0, array.length-1, number);
	}
	
	public static int binarySearch(final int[] array, final int fromIndex, final int toIndex, final int number){
		int offset = (toIndex-fromIndex)/2;
		int indexMid = fromIndex+offset;
		
		if(array[indexMid] == number) {
			return indexMid;
		}
		if(offset == 0) {
			return (array[indexMid+1] == number) ? indexMid+1 : ERROR_SEARCH;
		}
		if(array[indexMid] > number) {
			offset = toIndex - offset;
			return binarySearch(array, fromIndex, offset, number);
		} else {
			offset = fromIndex + offset;
			return binarySearch(array, offset, toIndex, number);
		}
	}
}
