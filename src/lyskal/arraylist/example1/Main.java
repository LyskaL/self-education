package lyskal.arraylist.example1;

import java.util.ArrayList;

public class Main {

	public static void main(final String[] args) {
		Student lena = new Student("Lena Ivanova", "30.11.1990", 4);
		Student max = new Student("Max Loren", "06.09.1993", 4);
		Student irina = new Student("Irina Ivanova", "30.11.1990", 1);
		
		ArrayList<Student> students = new ArrayList<>();
		students.add(irina);
		students.add(lena);
		students.add(max);
		
		show(students);
		students.remove(students.indexOf(irina));
		show(students);
	}
	
	public static void show(final ArrayList<Student> students) {
		System.out.println("\nNumber students in group: " + students.size());
		for (Student student : students) {
			System.out.println(student.toString());
		}
	}
}
